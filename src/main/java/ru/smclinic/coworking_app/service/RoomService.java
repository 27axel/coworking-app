package ru.smclinic.coworking_app.service;

import org.springframework.stereotype.Service;
import ru.smclinic.coworking_app.dto.RoomDto;
import ru.smclinic.coworking_app.entity.Coworking;
import ru.smclinic.coworking_app.entity.Room;
import ru.smclinic.coworking_app.exception.NotFoundException;
import ru.smclinic.coworking_app.mapper.RoomMapper;
import ru.smclinic.coworking_app.repository.CoworkingRepository;
import ru.smclinic.coworking_app.repository.RoomRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final CoworkingRepository coworkingRepository;
    private final RoomMapper mapper;

    public RoomService(RoomRepository roomRepository, CoworkingRepository coworkingRepository, RoomMapper mapper) {
        this.roomRepository = roomRepository;
        this.coworkingRepository = coworkingRepository;
        this.mapper = mapper;
    }

    public RoomDto createRoom(long coworkingId, int countOfPlaces) {
        Optional<Coworking> optionalCoworking = coworkingRepository.findById(coworkingId);
        if (optionalCoworking.isPresent()) {
            Room room = new Room();
            room.setCountOfPlaces(countOfPlaces);
            room.setCoworking(optionalCoworking.get());
            roomRepository.save(room);
            return mapper.toDTO(room);
        }
        throw new NotFoundException("Coworking");
    }

    public void deleteRoom(long roomId) {
        roomRepository.deleteById(roomId);
    }

    public RoomDto updateRoom(long roomId, int countOfPlaces) {
        Optional<Room> room = roomRepository.findById(roomId);
        if (room.isPresent()) {
            Room newRoom = room.get();
            newRoom.setCountOfPlaces(countOfPlaces);
            roomRepository.save(newRoom);
            return mapper.toDTO(newRoom);
        }
        throw new NotFoundException("Room");
    }


    public Collection<RoomDto> getRooms() {
        Collection<Room> rooms = roomRepository.findAll();
        return mapper.listToDTO(rooms);
    }

    public Collection<RoomDto> filterRoomsByLimit(int limit) {
        Collection<Room> rooms = roomRepository.findRoomsByCountOfPlacesGreaterThanEqual(limit);
        return mapper.listToDTO(rooms);
    }

    public Collection<RoomDto> filterRoomsByDate(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Collection<Room> roomsReserved = roomRepository.findByDate(startDateTime, endDateTime);
        Collection<Room> rooms = roomRepository.findAll();
        rooms.removeAll(roomsReserved);
        return mapper.listToDTO(rooms);
    }

    public Collection<RoomDto> filterRoomsByLimitAndDate(int limit, LocalDateTime startDate, LocalDateTime endDate) {
        Collection<Room> rooms = roomRepository.findRoomsByCountOfPlacesGreaterThanEqual(limit);
        Collection<Room> roomsReserved = roomRepository.findByDate(startDate, endDate);
        rooms.removeAll(roomsReserved);
        return mapper.listToDTO(rooms);
    }
}
