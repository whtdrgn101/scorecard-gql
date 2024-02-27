package com.tdtech.scorecardapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection = "users")
@NoArgsConstructor
public class UserDto {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<BowDto> bows;

    public UserDto(UserRequest user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        if(user.getBows() != null) {
            List<BowDto> bows = new ArrayList<BowDto>();
            user.getBows().forEach(bow -> {
                bows.add(new BowDto(bow));
            });
        }
    }
}
