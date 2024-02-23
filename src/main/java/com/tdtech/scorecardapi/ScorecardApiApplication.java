package com.tdtech.scorecardapi;

import com.tdtech.scorecardapi.repository.BowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.tdtech.scorecardapi.controller", "com.tdtech.scorecardapi.service"})
@EntityScan({"com.tdtech.scorecardapi.entity"})
@EnableJpaRepositories({"com.tdtech.scorecardapi.repository"})
public class ScorecardApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScorecardApiApplication.class, args);
    }

}
