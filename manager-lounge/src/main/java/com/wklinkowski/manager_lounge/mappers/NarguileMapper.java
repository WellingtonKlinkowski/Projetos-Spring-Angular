package com.wklinkowski.manager_lounge.mappers;

import com.wklinkowski.manager_lounge.dtos.NarguileDTO;
import com.wklinkowski.manager_lounge.entities.NarguileEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NarguileMapper {

    NarguileDTO toDto(NarguileEntity narguileEntity);

    NarguileEntity toEntity(NarguileDTO narguileDTO);
}
