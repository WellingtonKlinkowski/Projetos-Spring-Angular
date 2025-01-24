package com.wklinkowski.manager_lounge.mappers;

import com.wklinkowski.manager_lounge.dtos.request.NarguileRequest;
import com.wklinkowski.manager_lounge.dtos.response.NarguileResponse;
import com.wklinkowski.manager_lounge.entities.NarguileEntity;
import org.mapstruct.Mapper;

/**
 * Mapper para ajudar na conversão de narguile.
 *
 * @author WellingtonKlinkowski
 */
@Mapper(componentModel = "spring")
public interface NarguileMapper {

    NarguileEntity fromRequestToEntity(NarguileRequest narguileRequest);

    NarguileResponse fromEntityToResponse(NarguileEntity narguileEntity);
}
