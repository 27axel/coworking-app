package ru.smclinic.coworking_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.smclinic.coworking_app.dto.RoomDto;
import ru.smclinic.coworking_app.entity.Room;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    @Mapping(source = "coworkingId", target = "coworking.id")
    Room toRoom(RoomDto roomDto);

    @Mapping(source = "coworking.id", target = "coworkingId")
    RoomDto toDTO(Room room);

    Collection<RoomDto> listToDTO(Collection<Room> rooms);
}
