package com.tdtech.scorecardapi.controller;

import com.tdtech.scorecardapi.entity.RoundResponse;
import com.tdtech.scorecardapi.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RoundQuery {

    @Autowired
    RoundService roundService = null;

    @QueryMapping
    public List<RoundResponse> roundList(@Argument Integer userId) {
        return roundService.roundList((long)userId);
    }
}
