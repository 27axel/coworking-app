package ru.smclinic.coworking_app.dto;

import lombok.Data;

@Data
public class CreateOrUpdateCoworkingDto {
    private String name;
    private String address;
}
