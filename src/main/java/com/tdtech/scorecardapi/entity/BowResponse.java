package com.tdtech.scorecardapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BowResponse {
    private String bowType;
    private String name;
    private String manufacturer;
    private String model;
    private Double ataLength;
    private Double drawWeight;
    private Double braceHeight;

    public BowResponse(BowDto bow) {
        this.bowType = bow.getBowType();
        this.name = bow.getName();
        this.manufacturer = bow.getManufacturer();
        this.model = bow.getModel();
        this.drawWeight = bow.getDrawWeight();
        this.ataLength = bow.getAtaLength();
        this.braceHeight = bow.getBraceHeight();
    }
}
