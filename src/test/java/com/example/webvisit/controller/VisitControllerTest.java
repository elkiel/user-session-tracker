package com.example.webvisit.controller;

import com.example.webvisit.model.StatisticDto;
import com.example.webvisit.model.Visit;
import com.example.webvisit.model.command.CreateVisitCommand;
import com.example.webvisit.service.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class VisitControllerTest {
    @Mock
    private VisitService visitService;

    @InjectMocks
    private VisitController visitController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
    }

    @Test
    public void testSaveVisit() throws Exception {
        when(visitService.saveVisit(CreateVisitCommand.builder()
                .dateTime(LocalDate.of(2001, 12, 13))
                .ip("212.34.52.103")
                .build())).thenReturn(Visit.builder()
                .visitDate(LocalDate.of(2001, 12, 13))
                .ip("212.34.52.103")
                .build());

        mockMvc.perform(post("/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"dateTime\": \"2023-05-22\",\n" +
                                "  \"ip\": \"212.34.52.103\"\n" +
                                "}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetStatistics() throws Exception {
        List<StatisticDto> statistics = Arrays.asList(
                new StatisticDto(LocalDate.of(2023, 05, 21), 4L),
                new StatisticDto(LocalDate.of(2023, 05, 19), 3L),
                new StatisticDto(LocalDate.of(2023, 05, 20), 6L),
                new StatisticDto(LocalDate.of(2023, 05, 22), 5L)
        );

        when(visitService.getStatistics()).thenReturn(statistics);

        mockMvc.perform(get("/statistics")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
