package ru.smclinic.coworking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.smclinic.coworking_app.entity.Room;

import java.time.LocalDateTime;
import java.util.Collection;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Collection<Room> findRoomsByCountOfPlacesGreaterThanEqual(int countOfPlaces);

    @Query(value = "SELECT room.* FROM room inner join reservation on room.id = reservation.room_id where start_date_time=?1 or end_date_time=?2", nativeQuery = true)
    Collection<Room> findByDate(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
