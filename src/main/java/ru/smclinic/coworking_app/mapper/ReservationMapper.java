package ru.smclinic.coworking_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.smclinic.coworking_app.dto.ReservationDto;
import ru.smclinic.coworking_app.entity.Reservation;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(source = "roomId", target = "room.id")
    Reservation toReservation(ReservationDto reservationDto);

}
