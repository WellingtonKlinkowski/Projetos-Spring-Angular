package com.wklinkowski.manager_lounge.mappers;

import com.wklinkowski.manager_lounge.dtos.RoshDTO;
import com.wklinkowski.manager_lounge.entities.RoshEntity;
import org.mapstruct.Mapper;

/**
 * Mapper para ajudar na conversão do rosh.
 *
 * @author WellingtonKlinkowski
 */
@Mapper(componentModel = "spring")
public interface RoshMapper {

    RoshDTO toDto(RoshEntity roshEntity);

    RoshEntity toEntity(RoshDTO roshDTO);
}
