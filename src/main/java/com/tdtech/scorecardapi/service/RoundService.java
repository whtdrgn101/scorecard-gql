package com.tdtech.scorecardapi.service;

import com.tdtech.scorecardapi.entity.*;
import com.tdtech.scorecardapi.repository.RoundRepository;
import com.tdtech.scorecardapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoundService {
    @Autowired
    RoundRepository roundRepository = null;

    @Autowired
    UserRepository userRepository = null;

    public List<RoundResponse> roundList(String userId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo -1, pageSize);
        List<RoundResponse> response = new ArrayList<RoundResponse>();
        List<RoundDto> rounds = roundRepository.findByUserId(userId, pageable);
        rounds.forEach(round -> {
            response.add(new RoundResponse(round));
        });
        return response;
    }

    public RoundResponse getRoundById(String roundId) {
        return new RoundResponse(roundRepository.findById(roundId).get());
    }

    public RoundResponse createRound(RoundRequest round) {
        UserDto user = userRepository.findById(round.getUserId()).get();
        RoundDto r = new RoundDto(round, user);
        roundRepository.save(r);
        return new RoundResponse(r);
    }

    public RoundResponse updateRound(String roundId, RoundRequest round) {

        if(roundRepository.findById(roundId).isPresent()) {

            RoundDto r = roundRepository.findById(roundId).get();
            if(round.getUserId() != null && !round.getUserId().isBlank()) {

                if(userRepository.findById(round.getUserId()).isPresent()) {
                    UserDto user = userRepository.findById(round.getUserId()).get();
                    r.setUser(user);
                }

            } else {
                r.setUser(null);
            }
            if(round.getBow() != null) {
                r.setBow(new BowDto(round.getBow()));
            } else {
                r.setBow(null);
            }
            r.setRoundType(round.getRoundType());
            r.setLocation(round.getLocation());
            r.setNotes(round.getNotes());
            r.setScore(round.getScore());
            roundRepository.save(r);
            return new RoundResponse(r);

        } else {
            return null;
        }

    }

    public Boolean deleteRound(String roundId) {
        try {
            roundRepository.deleteById(roundId);
            return true;
        } catch(Exception ex){
            return false;
        }

    }
}
