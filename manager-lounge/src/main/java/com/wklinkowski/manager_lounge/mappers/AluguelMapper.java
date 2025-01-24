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

    /**
     * Recebe os dados da requisição e transforma
     * na entidade aluguel.
     *
     * @param aluguelRequest recebe os dados para criar a entidade.
     * @return entidade de aluguel criada com os dados recebidos.
     *
     * @author WellingtonKlinkowski
     */
    AluguelEntity fromRequestToEntity(AluguelRequest aluguelRequest);

    /**
     * Recebe os dados do banco e transforma
     * no response de aluguel.
     *
     * @param aluguelEntity recebe os dados do banco e converte em um response.
     * @return response de aluguel com os dados recebidos do banco.
     *
     * @author WellingtonKlinkowski
     */
    AluguelResponse fromEntityToResponse(AluguelEntity aluguelEntity);
}
