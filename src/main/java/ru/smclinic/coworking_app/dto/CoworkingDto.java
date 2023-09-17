package ru.smclinic.coworking_app.dto;

import lombok.Data;

import java.util.List;

@Data
public class CoworkingDto {
    private long id;
    private String name;
    private String address;
    private List<RoomDto> rooms;
}
