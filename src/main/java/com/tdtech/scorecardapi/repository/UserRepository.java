package com.tdtech.scorecardapi.repository;

import com.tdtech.scorecardapi.entity.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDto, String> {

}
