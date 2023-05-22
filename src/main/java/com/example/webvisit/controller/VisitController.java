package com.example.webvisit.controller;

import com.example.webvisit.model.StatisticDto;
import com.example.webvisit.model.Visit;
import com.example.webvisit.model.command.CreateVisitCommand;
import com.example.webvisit.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class VisitController implements VisitControllerIF {

    private final VisitService visitService;

    @Override
    public ResponseEntity<Visit> saveVisit(CreateVisitCommand visit) {
        return new ResponseEntity<>(visitService.saveVisit(visit), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<StatisticDto>> getStatistics() {
        return new ResponseEntity<>(visitService.getStatistics(), HttpStatus.OK);
    }

}
