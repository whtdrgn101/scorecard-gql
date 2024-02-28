package com.tdtech.scorecardapi.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection="rounds")
@AllArgsConstructor
@NoArgsConstructor
public class RoundDto {
    @Id
    private String id;
    private String userId;
    private BowDto bow;
    private String roundType;
    private Date roundDate;
    private String location;
    private String notes;
    private int score;

    public RoundDto(RoundRequest round) {
        this.userId = round.getUserId();
        if(round.getBow() != null) {
            this.bow = new BowDto(round.getBow());
        }
        this.roundType = round.getRoundType();
        this.roundDate = round.getRoundDate();
        this.location = round.getLocation();
        this.notes = round.getNotes();
        this.score = round.getScore();
    }
}
