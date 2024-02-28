package com.tdtech.scorecardapi.service;

import com.tdtech.scorecardapi.entity.RoundDto;
import com.tdtech.scorecardapi.entity.RoundRequest;
import com.tdtech.scorecardapi.entity.RoundResponse;
import com.tdtech.scorecardapi.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoundService {
    @Autowired
    RoundRepository roundRepository = null;

    public List<RoundResponse> roundList(String userId) {
        List<RoundResponse> response = new ArrayList<RoundResponse>();
        List<RoundDto> rounds = roundRepository.findByUserId(userId);
        rounds.forEach(round -> {
            response.add(new RoundResponse(round));
        });
        return response;
    }

    public RoundResponse createRound(RoundRequest round) {
        RoundDto r = new RoundDto(round);
        roundRepository.save(r);
        return new RoundResponse(r);
    }
}
