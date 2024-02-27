package com.tdtech.scorecardapi.service;

import com.tdtech.scorecardapi.entity.BowDto;
import com.tdtech.scorecardapi.entity.UserDto;
import com.tdtech.scorecardapi.entity.UserRequest;
import com.tdtech.scorecardapi.entity.UserResponse;
import com.tdtech.scorecardapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserResponse> getAllUsers() {
        List<UserResponse> response = new ArrayList<UserResponse>();
        userRepository.findAll().forEach(user -> {
            response.add(new UserResponse(user));
        });
        return response;
    }

    public UserResponse createUser(UserRequest user) {
        UserDto newUser = new UserDto(user);
        userRepository.save(newUser);
        return new UserResponse(newUser);
    }

    public UserResponse updateUser(String id, UserRequest user) {
        UserResponse response = null;
        if(userRepository.findById(id).isPresent()) {
            UserDto u = userRepository.findById(id).get();
            u.setFirstName(user.getFirstName());
            u.setLastName(user.getLastName());
            u.setEmail(user.getEmail());
            if(user.getBows() != null) {
                List<BowDto> bows = new ArrayList<BowDto>();
                user.getBows().forEach(bow -> {
                    bows.add(new BowDto(bow));
                });
                u.setBows(bows);
            }
            userRepository.save(u);
            response = new UserResponse(u);
        }
        return response;
    }
}
