package com.tdtech.scorecardapi.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection="rounds")
@NoArgsConstructor
public class RoundDto {
    @Id
    private String id;
    @DBRef(lazy = true)
    private UserDto user;
    private BowDto bow;
    private String roundType;
    private Date roundDate;
    private String location;
    private String notes;
    private int score;

    public RoundDto(RoundRequest round, UserDto user) {
        if(user != null) {
            this.user = user;
        }
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
