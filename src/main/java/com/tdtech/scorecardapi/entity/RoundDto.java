package com.tdtech.scorecardapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name="round")
@AllArgsConstructor
@NoArgsConstructor
public class RoundDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    @OneToOne
    @JoinColumn(name="bowId")
    private BowDto bow;
    @OneToOne
    @JoinColumn(name="roundTypeId")
    private RoundTypeDto roundType;
    private Date roundDate;
    private String location;
    private String notes;
    private int score;
}
