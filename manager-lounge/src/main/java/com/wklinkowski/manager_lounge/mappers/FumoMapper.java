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

    /**
     * Recebe os dados da requisição e transforma
     * na entidade fumo.
     *
     * @param fumoRequest recebe os dados para criar a entidade.
     * @return entidade de fumo criada com os dados recebidos.
     *
     * @author WellingtonKlinkowski
     */
    FumoEntity fromRequestToEntity(FumoRequest fumoRequest);

    /**
     * Recebe os dados do banco e transforma
     * no response de fumo.
     *
     * @param fumoEntity recebe os dados do banco e converte em um response.
     * @return response de fumo com os dados recebidos do banco.
     *
     * @author WellingtonKlinkowski
     */
    FumoResponse fromEntityToResponse(FumoEntity fumoEntity);
}
