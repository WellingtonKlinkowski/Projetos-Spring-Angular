package com.wklinkowski.manager_lounge.mappers;

import com.wklinkowski.manager_lounge.dtos.CarvaoDTO;
import com.wklinkowski.manager_lounge.entities.CarvaoEntity;
import org.mapstruct.Mapper;

/**
 * Mapper para ajudar na conversão de carvao.
 *
 * @author WellingtonKlinkowski
 */
@Mapper(componentModel = "spring")
public interface CarvaoMapper {

    CarvaoDTO toDto(CarvaoEntity carvaoEntity);

    CarvaoEntity toEntity(CarvaoDTO carvaoDTO);
}
