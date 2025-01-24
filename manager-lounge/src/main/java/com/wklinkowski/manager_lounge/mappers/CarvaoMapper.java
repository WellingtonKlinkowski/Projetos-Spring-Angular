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

    /**
     * Recebe os dados da requisição e transforma
     * na entidade carvão.
     *
     * @param carvaoRequest recebe os dados para criar a entidade.
     * @return entidade de carvão criada com os dados recebidos.
     *
     * @author WellingtonKlinkowski
     */
    CarvaoEntity fromRequestToEntity(CarvaoRequest carvaoRequest);

    /**
     * Recebe os dados do banco e transforma
     * no response de carvão.
     *
     * @param carvaoEntity recebe os dados do banco e converte em um response.
     * @return response de carvão com os dados recebidos do banco.
     *
     * @author WellingtonKlinkowski
     */
    CarvaoResponse fromEntityToResponse(CarvaoEntity carvaoEntity);
}
