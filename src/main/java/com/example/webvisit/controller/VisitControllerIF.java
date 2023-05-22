package com.example.webvisit.controller;

import com.example.webvisit.model.StatisticDto;
import com.example.webvisit.model.Visit;
import com.example.webvisit.model.command.CreateVisitCommand;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


public interface VisitControllerIF {

    @ResponseBody
    @PostMapping("/save")
    ResponseEntity<Visit> saveVisit(@Valid @RequestBody CreateVisitCommand visit);

    @ResponseBody
    @GetMapping("/statistics")
    ResponseEntity<List<StatisticDto>> getStatistics();
}
