package ru.smclinic.coworking_app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity
@Data
public class Coworking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "coworking")
    private Collection<Room> rooms;
}
