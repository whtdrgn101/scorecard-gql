package com.tdtech.scorecardapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Setter
@Getter
public class RoundRequest {
    private String userId;
    private BowRequest bow;
    private String roundType;
    private Date roundDate;
    private String location;
    private String notes;
    private int score;
}
