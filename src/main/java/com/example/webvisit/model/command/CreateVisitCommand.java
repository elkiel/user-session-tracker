package com.example.webvisit.model.command;

import com.example.webvisit.controller.error.annotation.CorrectIP;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Validated
public class CreateVisitCommand {
    @NotNull(message = "DATE_NOT_NULL")
    @PastOrPresent(message = "DATE_PAST_VIOLATED")
    private LocalDate dateTime;
    @NotNull(message = "IP_NOT_NULL")
    @CorrectIP
    private String ip;
}
