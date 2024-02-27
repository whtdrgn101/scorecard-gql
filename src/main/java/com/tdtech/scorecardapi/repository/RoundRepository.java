package com.tdtech.scorecardapi.repository;

import com.tdtech.scorecardapi.entity.RoundDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoundRepository extends MongoRepository<RoundDto, Long> {
    public List<RoundDto> findByUserId(long userId);
    public RoundDto findByIdAndUserId(long id, long userId);
}
