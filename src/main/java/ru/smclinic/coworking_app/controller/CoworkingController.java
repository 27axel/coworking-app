package ru.smclinic.coworking_app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smclinic.coworking_app.dto.CoworkingDto;
import ru.smclinic.coworking_app.dto.CreateOrUpdateCoworkingDto;
import ru.smclinic.coworking_app.service.CoworkingService;

import java.util.Collection;

@RestController
@RequestMapping("/coworking")
public class CoworkingController {
    private final CoworkingService coworkingService;

    public CoworkingController(CoworkingService coworkingService) {
        this.coworkingService = coworkingService;
    }

    @PostMapping("/add")
    public ResponseEntity<CreateOrUpdateCoworkingDto> addCoworking(@RequestBody CreateOrUpdateCoworkingDto coworkingDto) {
        return ResponseEntity.ok(coworkingService.createCoworking(coworkingDto));
    }

    @GetMapping
    public ResponseEntity<Collection<CoworkingDto>> getCoworking() {
        return ResponseEntity.ok(coworkingService.getCoworkings());
    }

    @PatchMapping
    public ResponseEntity<CoworkingDto> updateCoworking(@RequestParam long id, @RequestBody CreateOrUpdateCoworkingDto coworkingDto) {
        return ResponseEntity.ok(coworkingService.updateCoworking(id, coworkingDto));
    }

    @DeleteMapping
    public ResponseEntity<CoworkingDto> deleteCoworking(@RequestParam long id) {
        coworkingService.deleteCoworking(id);
        return ResponseEntity.ok().build();
    }
}
