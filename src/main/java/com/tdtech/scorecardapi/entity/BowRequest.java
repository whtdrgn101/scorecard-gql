package com.tdtech.scorecardapi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class BowRequest {

    private String bowType;
    private String name;
    private String manufacturer;
    private String model;
    private double drawWeight;
    private double ataLength;
    private double braceHeight;
}
