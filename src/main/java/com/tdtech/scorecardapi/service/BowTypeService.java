package com.tdtech.scorecardapi.service;

import com.tdtech.scorecardapi.entity.BowTypeDto;
import com.tdtech.scorecardapi.entity.BowTypeResponse;
import com.tdtech.scorecardapi.repository.BowTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BowTypeService {
    @Autowired
    BowTypeRepository bowTypeRepository = null;

    public List<BowTypeResponse> getBowTypeList() {
        List<BowTypeResponse> response = new ArrayList<>();
        List<BowTypeDto> bowTypes = bowTypeRepository.findAll();
        bowTypes.forEach(bowType -> {
            response.add(new BowTypeResponse(bowType));
        });
        return response;
    }
}
