package ru.smclinic.coworking_app.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smclinic.coworking_app.dto.RoomDto;
import ru.smclinic.coworking_app.service.RoomService;

import java.time.LocalDateTime;
import java.util.Collection;

@RestController
@RequestMapping("/coworking")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public ResponseEntity<Collection<RoomDto>> getRooms() {
        return ResponseEntity.ok(roomService.getRooms());
    }

    @PostMapping("/room/add")
    public ResponseEntity<RoomDto> addRoom(@RequestParam long coworkingId, @RequestParam @Min(1) @Max(20) int countOfPlaces) {
        return ResponseEntity.ok(roomService.createRoom(coworkingId, countOfPlaces));
    }

    @DeleteMapping("/room")
    public ResponseEntity<RoomDto> deleteRoom(@RequestParam long roomId) {
        roomService.deleteRoom(roomId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/room/edit")
    public ResponseEntity<RoomDto> updateRoom(@RequestParam long roomId, @RequestParam @Min(1) @Max(20) int countOfPlaces) {
        return ResponseEntity.ok(roomService.updateRoom(roomId, countOfPlaces));
    }

    @GetMapping("/rooms/filterByLimit")
    public ResponseEntity<Collection<RoomDto>> filterRoomsByLimit(@RequestParam(required = false) @Min(1) @Max(20) int limit) {
        return ResponseEntity.ok(roomService.filterRoomsByLimit(limit));
    }

    @GetMapping("/rooms/filterByDate")
    public ResponseEntity<Collection<RoomDto>> filterRoomsByDate(@RequestParam LocalDateTime startDateTime, @RequestParam LocalDateTime endDateTime) {
        return ResponseEntity.ok(roomService.filterRoomsByDate(startDateTime, endDateTime));
    }

    @GetMapping("/rooms/filterByLimitAndDate")
    public ResponseEntity<Collection<RoomDto>> filterRoomsByLimitAndDate(@RequestParam @Min(1) @Max(20) int limit, @RequestParam LocalDateTime startDateTime, @RequestParam LocalDateTime endDateTime) {
        return ResponseEntity.ok(roomService.filterRoomsByLimitAndDate(limit, startDateTime, endDateTime));
    }
}
