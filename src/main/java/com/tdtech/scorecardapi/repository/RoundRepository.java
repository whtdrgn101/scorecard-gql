package com.tdtech.scorecardapi.repository;

import com.tdtech.scorecardapi.entity.RoundDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoundRepository extends MongoRepository<RoundDto, String> {
    public List<RoundDto> findByUserId(String userId);
}
