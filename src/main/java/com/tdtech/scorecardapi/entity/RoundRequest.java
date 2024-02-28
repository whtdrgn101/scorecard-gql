package com.tdtech.scorecardapi.entity;

import lombok.Data;
import java.util.Date;

@Data
public class RoundRequest {
    private String userId;
    private BowRequest bow;
    private String roundType;
    private Date roundDate;
    private String location;
    private String notes;
    private int score;
}
