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

    /**
     * Recebe os dados da requisição e transforma
     * na entidade rosh.
     *
     * @param roshRequest recebe os dados para criar a entidade.
     * @return entidade de rosh criada com os dados recebidos.
     *
     * @author WellingtonKlinkowski
     */
    RoshEntity fromRequestToEntity(RoshRequest roshRequest);

    /**
     * Recebe os dados do banco e transforma
     * no response de rosh.
     *
     * @param roshEntity recebe os dados do banco e converte em um response.
     * @return response de rosh com os dados recebidos do banco.
     *
     * @author WellingtonKlinkowski
     */
    RoshResponse fromEntityToResponse(RoshEntity roshEntity);
}
