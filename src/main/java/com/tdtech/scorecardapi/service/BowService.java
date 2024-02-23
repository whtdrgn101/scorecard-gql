package com.tdtech.scorecardapi.service;

import com.tdtech.scorecardapi.entity.BowDto;
import com.tdtech.scorecardapi.entity.BowResponse;
import com.tdtech.scorecardapi.repository.BowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BowService {

    @Autowired
    private BowRepository bowRepository;
    public List<BowResponse> getBowList(Integer user_id) {
        List<BowDto> bows = bowRepository.findByUserId(user_id);
        List<BowResponse> list = new ArrayList<BowResponse>();
        bows.forEach(bow -> {
            list.add(new BowResponse(bow));
        });
        return list;
    }

    public BowResponse getBowById(Long bow_id) {
        BowDto bow = bowRepository.findById(bow_id).get();
        return new BowResponse(bow);
    }
}
