package com.wklinkowski.manager_lounge.mappers;

import com.wklinkowski.manager_lounge.dtos.request.RoshRequest;
import com.wklinkowski.manager_lounge.dtos.response.RoshResponse;
import com.wklinkowski.manager_lounge.entities.RoshEntity;
import org.mapstruct.Mapper;

/**
 * Mapper para ajudar na conversão do rosh.
 *
 * @author WellingtonKlinkowski
 */
@Mapper(componentModel = "spring")
public interface RoshMapper {

    RoshEntity fromRequestToEntity(RoshRequest roshRequest);

    RoshResponse fromEntityToResponse(RoshEntity roshEntity);
}
