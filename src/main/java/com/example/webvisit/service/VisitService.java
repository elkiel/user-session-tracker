package com.example.webvisit.service;

import com.example.webvisit.model.StatisticDto;
import com.example.webvisit.model.Visit;
import com.example.webvisit.model.command.CreateVisitCommand;

import java.util.List;

public interface VisitService {

    Visit saveVisit(CreateVisitCommand visit);

    List<StatisticDto> getStatistics();

}
