package com.wklinkowski.manager_lounge.mappers;

import com.wklinkowski.manager_lounge.dtos.AluguelDTO;
import com.wklinkowski.manager_lounge.entities.AluguelEntity;
import org.mapstruct.Mapper;

/**
 * Mapper para ajudar na conversão de aluguel.
 *
 * @author WellingtonKlinkowski
 */
@Mapper(componentModel = "spring")
public interface AluguelMapper {

    AluguelDTO toDto(AluguelEntity aluguelEntity);

    AluguelEntity toEntity(AluguelDTO aluguelDTO);
}
