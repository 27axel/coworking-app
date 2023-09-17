package ru.smclinic.coworking_app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
