package com.tdtech.scorecardapi.entity;

import lombok.Data;
import java.util.List;

@Data
public class UserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<BowRequest> bows;
}
