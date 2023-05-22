package com.example.webvisit.repository;

import com.example.webvisit.model.StatisticDto;
import com.example.webvisit.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Integer> {

    @Query("SELECT new com.example.webvisit.model.StatisticDto(v.visitDate, COUNT(v)) FROM Visit v GROUP BY v.visitDate")
    List<StatisticDto> findVisitsByDate();
}
