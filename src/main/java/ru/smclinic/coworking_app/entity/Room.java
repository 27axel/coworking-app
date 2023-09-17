package ru.smclinic.coworking_app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "count_of_places")
    private int countOfPlaces;

    @ManyToOne
    @JoinColumn(name = "coworking_id")
    private Coworking coworking;

    @OneToMany(mappedBy = "room")
    private List<Reservation> listReservation;
}
