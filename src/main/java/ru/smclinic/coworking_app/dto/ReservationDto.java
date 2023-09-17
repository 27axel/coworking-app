package ru.smclinic.coworking_app.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationDto {
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private int roomId;
}
