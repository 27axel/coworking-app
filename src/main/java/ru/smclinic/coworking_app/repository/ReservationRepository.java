package ru.smclinic.coworking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.smclinic.coworking_app.entity.Reservation;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
   Optional<Reservation> findByStartDateTime(LocalDateTime startDateTime);
}
