package com.tdtech.scorecardapi.service;

import com.tdtech.scorecardapi.entity.RoundTypeDto;
import com.tdtech.scorecardapi.entity.RoundTypeResponse;
import com.tdtech.scorecardapi.repository.RoundTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoundTypeService {

    @Autowired
    RoundTypeRepository roundTypeRepository = null;

    public List<RoundTypeResponse> getRoundTypeList() {
        List<RoundTypeResponse> response = new ArrayList<RoundTypeResponse>();
        List<RoundTypeDto> roundTypes = roundTypeRepository.findAll();
        roundTypes.forEach(roundType -> {
            response.add(new RoundTypeResponse(roundType));
        });
        return response;
    }
}
