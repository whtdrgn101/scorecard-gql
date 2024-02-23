package com.tdtech.scorecardapi.repository;

import com.tdtech.scorecardapi.entity.BowDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BowRepository extends JpaRepository<BowDto, Long> {
    public List<BowDto> findByUserId(long userId);
    public BowDto findByIdAndUserId(long id, long userId);
}
