package com.tdtech.scorecardapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BowTypeResponse {
    private long id;
    private String name;

    public BowTypeResponse(BowTypeDto bowType) {
        this.id = bowType.getId();
        this.name = bowType.getName();
    }
}
