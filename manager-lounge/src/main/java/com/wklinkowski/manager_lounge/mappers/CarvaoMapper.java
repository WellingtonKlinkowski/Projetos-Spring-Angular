package com.wklinkowski.manager_lounge.mappers;

import com.wklinkowski.manager_lounge.dtos.request.CarvaoRequest;
import com.wklinkowski.manager_lounge.dtos.response.CarvaoResponse;
import com.wklinkowski.manager_lounge.entities.CarvaoEntity;
import org.mapstruct.Mapper;

/**
 * Mapper para ajudar na conversão de carvao.
 *
 * @author WellingtonKlinkowski
 */
@Mapper(componentModel = "spring")
public interface CarvaoMapper {

    CarvaoEntity fromRequestToEntity(CarvaoRequest carvaoRequest);

    CarvaoResponse fromEntityToResponse(CarvaoEntity carvaoEntity);
}
