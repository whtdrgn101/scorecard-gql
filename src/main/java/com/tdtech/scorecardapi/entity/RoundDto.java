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
    private long id;
    private long userId;
    private BowDto bow;
    private String roundType;
    private Date roundDate;
    private String location;
    private String notes;
    private int score;
}
