package com.tdtech.scorecardapi.entity;

import com.tdtech.scorecardapi.repository.BowRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BowResponse {
    private Long id;
    private Long userId;
    private BowTypeResponse bowType;
    private String name;
    private String manufacturer;
    private String model;
    private Double ataLength;
    private Double drawWeight;
    private Double braceHeight;

    public BowResponse(BowDto bow) {
        this.id = bow.getId();
        this.userId = bow.getUserId();
        this.bowType = new BowTypeResponse(bow.getBowType());
        this.name = bow.getName();
        this.manufacturer = bow.getManufacturer();
        this.model = bow.getModel();
        this.drawWeight = bow.getDrawWeight();
        this.ataLength = bow.getAtaLength();
        this.braceHeight = bow.getBraceHeight();
    }
}
