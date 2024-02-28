package com.tdtech.scorecardapi.entity;

import lombok.Data;

@Data
public class BowRequest {

    private String bowType;
    private String name;
    private String manufacturer;
    private String model;
    private double drawWeight;
    private double ataLength;
    private double braceHeight;
}
