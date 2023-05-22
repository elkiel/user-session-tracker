package com.example.webvisit.service;

import com.example.webvisit.model.StatisticDto;
import com.example.webvisit.model.Visit;
import com.example.webvisit.model.command.CreateVisitCommand;
import com.example.webvisit.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final ModelMapper modelMapper;

    @Override
    public Visit saveVisit(CreateVisitCommand visit) {
        return save(modelMapper.map(visit, Visit.class));
    }

    @Override
    public List<StatisticDto> getStatistics() {
        return visitRepository.findVisitsByDate();
    }

    @Transactional(readOnly = true)
    public Visit save(Visit toSave) {
        return visitRepository.saveAndFlush(toSave);
    }

}
