package com.wklinkowski.manager_lounge.mappers;

import com.wklinkowski.manager_lounge.dtos.request.AluguelRequest;
import com.wklinkowski.manager_lounge.dtos.response.AluguelResponse;
import com.wklinkowski.manager_lounge.entities.AluguelEntity;
import org.mapstruct.Mapper;

/**
 * Mapper para ajudar na conversão de aluguel.
 *
 * @author WellingtonKlinkowski
 */
@Mapper(componentModel = "spring")
public interface AluguelMapper {

    AluguelEntity fromRequestToEntity(AluguelRequest aluguelRequest);

    AluguelResponse fromEntityToResponse(AluguelEntity aluguelEntity);
}
