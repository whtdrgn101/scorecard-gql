package com.tdtech.scorecardapi.controller;

import com.tdtech.scorecardapi.entity.BowResponse;
import com.tdtech.scorecardapi.entity.BowTypeResponse;
import com.tdtech.scorecardapi.service.BowService;
import com.tdtech.scorecardapi.service.BowTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BowQuery {

    @Autowired
    private BowService bowService = null;
    @Autowired
    private BowTypeService bowTypeService = null;

    @QueryMapping
    public List<BowResponse> bowList(@Argument Integer user_id) {
        return bowService.getBowList(user_id);
    }

    @QueryMapping
    public BowResponse bowById(@Argument Integer bow_id) {
        return bowService.getBowById((long)bow_id);
    }

    @QueryMapping
    public List<BowTypeResponse> bowTypeList() {
        return bowTypeService.getBowTypeList();
    }
}
