package ru.smclinic.coworking_app.mapper;

import org.mapstruct.Mapper;
import ru.smclinic.coworking_app.dto.CoworkingDto;
import ru.smclinic.coworking_app.dto.CreateOrUpdateCoworkingDto;
import ru.smclinic.coworking_app.entity.Coworking;

import java.util.Collection;

@Mapper(uses = RoomMapper.class, componentModel = "spring")
public interface CoworkingMapper {

    CoworkingDto toDTO(Coworking coworking);

    Coworking toCreateCoworking(CreateOrUpdateCoworkingDto coworkingDto);

    Collection<CoworkingDto> listToDTO(Collection<Coworking> coworkings);
}
