package com.tdtech.scorecardapi.repository;

import com.tdtech.scorecardapi.entity.RoundTypeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundTypeRepository extends JpaRepository<RoundTypeDto, Long> {
}
