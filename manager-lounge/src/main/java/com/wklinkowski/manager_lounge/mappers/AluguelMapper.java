package com.wklinkowski.manager_lounge.mappers;

import com.wklinkowski.manager_lounge.dtos.AluguelDTO;
import com.wklinkowski.manager_lounge.entities.AluguelEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AluguelMapper {

    AluguelDTO toDto(AluguelEntity aluguelEntity);

    AluguelEntity toEntity(AluguelDTO aluguelDTO);
}
