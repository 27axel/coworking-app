package ru.smclinic.coworking_app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smclinic.coworking_app.dto.ReservationDto;
import ru.smclinic.coworking_app.service.ReservationService;

@RestController
@RequestMapping("/coworking/room/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<ReservationDto> reservationRoom(@RequestBody ReservationDto reservationDto) {
        return ResponseEntity.ok(reservationService.reservationRoom( reservationDto));
    }
}
