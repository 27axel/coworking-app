package ru.smclinic.coworking_app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smclinic.coworking_app.dto.ReservationDto;
import ru.smclinic.coworking_app.entity.Reservation;
import ru.smclinic.coworking_app.exception.WrongValueException;
import ru.smclinic.coworking_app.mapper.ReservationMapper;
import ru.smclinic.coworking_app.repository.ReservationRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper mapper;

    public ReservationService(ReservationRepository reservationRepository, ReservationMapper mapper) {
        this.reservationRepository = reservationRepository;
        this.mapper = mapper;
    }

    public ReservationDto reservationRoom(ReservationDto reservationDto) {
        LocalDateTime startTime = reservationDto.getStartDateTime();
        if (startTime.getMinute() == 30 || startTime.getMinute() == 0) {
            Optional<Reservation> reservation = reservationRepository.findByStartDateTime(startTime);
            if (reservation.isEmpty()) {
                Reservation newReservation = mapper.toReservation(reservationDto);
                reservationRepository.save(newReservation);
                return reservationDto;
            }
        }
       throw new WrongValueException(startTime);
    }
}
