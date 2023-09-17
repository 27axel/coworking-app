package ru.smclinic.coworking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.smclinic.coworking_app.entity.Coworking;

public interface CoworkingRepository extends JpaRepository<Coworking, Long> {
}
