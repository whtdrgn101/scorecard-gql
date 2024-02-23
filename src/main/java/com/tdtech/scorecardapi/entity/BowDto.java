package com.tdtech.scorecardapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="bow")
@AllArgsConstructor
@NoArgsConstructor
public class BowDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    @OneToOne
    @JoinColumn(name="bowTypeId")
    private BowTypeDto bowType;
    private String name;
    private String manufacturer;
    private String model;
    private double drawWeight;
    private double ataLength;
    private double braceHeight;
}
