package com.example.webvisit.config.converter;

import com.example.webvisit.model.Visit;
import com.example.webvisit.model.command.CreateVisitCommand;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class VisitConverter implements Converter<CreateVisitCommand, Visit> {
    @Override
    public Visit convert(MappingContext<CreateVisitCommand, Visit> mappingContext) {
        return Visit.builder()
                .ip(mappingContext.getSource().getIp())
                .visitDate(mappingContext.getSource().getDateTime())
                .build();
    }
}
