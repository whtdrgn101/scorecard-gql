package com.tdtech.scorecardapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoundTypeResponse {
    private long id;
    private String name;

    public RoundTypeResponse(RoundTypeDto round) {
        this.id = round.getId();
        this.name = round.getName();
    }
}
