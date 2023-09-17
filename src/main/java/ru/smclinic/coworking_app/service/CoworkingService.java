package ru.smclinic.coworking_app.service;

import org.springframework.stereotype.Service;
import ru.smclinic.coworking_app.dto.CoworkingDto;
import ru.smclinic.coworking_app.dto.CreateOrUpdateCoworkingDto;
import ru.smclinic.coworking_app.entity.Coworking;
import ru.smclinic.coworking_app.exception.NotFoundException;
import ru.smclinic.coworking_app.mapper.CoworkingMapper;
import ru.smclinic.coworking_app.repository.CoworkingRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class CoworkingService {
    private final CoworkingRepository repository;
    private final CoworkingMapper mapper;

    public CoworkingService(CoworkingRepository repository, CoworkingMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CreateOrUpdateCoworkingDto createCoworking(CreateOrUpdateCoworkingDto coworkingDto) {
        Coworking coworking = mapper.toCreateCoworking(coworkingDto);
        repository.save(coworking);
        return coworkingDto;
    }

    public void deleteCoworking(long coworkingId) {
        repository.deleteById(coworkingId);
    }

    public CoworkingDto updateCoworking(long id, CreateOrUpdateCoworkingDto coworkingDto) {
        Optional<Coworking> coworking = repository.findById(id);
        if (coworking.isPresent()) {
            Coworking newCoworking = coworking.get();
            newCoworking.setName(mapper.toCreateCoworking(coworkingDto).getName());
            newCoworking.setAddress(mapper.toCreateCoworking(coworkingDto).getAddress());
            repository.save(newCoworking);
            return mapper.toDTO(newCoworking);
        }
        throw new NotFoundException("Coworking");
    }

    public Collection<CoworkingDto> getCoworkings() {
        Collection<Coworking> coworkings = repository.findAll();
        return mapper.listToDTO(coworkings);
    }
}
