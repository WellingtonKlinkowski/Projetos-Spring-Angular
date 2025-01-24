package com.wklinkowski.manager_lounge.mappers;

import com.wklinkowski.manager_lounge.dtos.request.FumoRequest;
import com.wklinkowski.manager_lounge.dtos.response.FumoResponse;
import com.wklinkowski.manager_lounge.entities.FumoEntity;
import org.mapstruct.Mapper;

/**
 * Mapper para ajudar na conversão de fumo.
 *
 * @author WellingtonKlinkowski
 */
@Mapper(componentModel = "spring")
public interface FumoMapper {

    FumoEntity fromRequestToEntity(FumoRequest fumoRequest);

    FumoResponse fromEntityToResponse(FumoEntity fumoEntity);
}
