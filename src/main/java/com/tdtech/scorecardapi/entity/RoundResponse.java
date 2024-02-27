package com.tdtech.scorecardapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class RoundResponse {
    private long id;
    private long userId;
    private BowResponse bow;
    private String roundType;
    private Date roundDate;
    private String location;
    private String notes;
    private int score;

    public RoundResponse(RoundDto round) {
        this.id = round.getId();
        this.userId = round.getUserId();
        this.bow = new BowResponse(round.getBow());
        this.roundType = round.getRoundType();
        this.roundDate = round.getRoundDate();
        this.location = round.getLocation();
        this.notes = round.getNotes();
        this.score = round.getScore();
    }
}
