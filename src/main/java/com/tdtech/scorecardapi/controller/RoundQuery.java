package com.tdtech.scorecardapi.controller;

import com.tdtech.scorecardapi.entity.RoundDto;
import com.tdtech.scorecardapi.entity.RoundRequest;
import com.tdtech.scorecardapi.entity.RoundResponse;
import com.tdtech.scorecardapi.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RoundQuery {

    @Autowired
    RoundService roundService = null;

    @QueryMapping
    public List<RoundResponse> roundList(@Argument String userId, @Argument int pageNo, @Argument int pageSize) {
        return roundService.roundList(userId, pageNo, pageSize);
    }

    @MutationMapping
    public RoundResponse createRound(@Argument RoundRequest round) {
        return roundService.createRound(round);
    }
}
