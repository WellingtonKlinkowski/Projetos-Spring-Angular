package com.wklinkowski.manager_lounge.mappers;

import com.wklinkowski.manager_lounge.dtos.FumoDTO;
import com.wklinkowski.manager_lounge.entities.FumoEntity;
import org.mapstruct.Mapper;

/**
 * Mapper para ajudar na conversão de fumo.
 *
 * @author WellingtonKlinkowski
 */
@Mapper(componentModel = "spring")
public interface FumoMapper {

    FumoDTO toDto(FumoEntity fumoEntity);

    FumoEntity toEntity(FumoDTO fumoDTO);
}
