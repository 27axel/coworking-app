package ru.smclinic.coworking_app.dto;

import lombok.Data;

@Data
public class RoomDto {
    private long id;
    private int countOfPlaces;
    private int coworkingId;
}
