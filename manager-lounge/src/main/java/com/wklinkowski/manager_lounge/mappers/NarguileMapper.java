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

    /**
     * Recebe os dados da requisição e transforma
     * na entidade narguile.
     *
     * @param narguileRequest recebe os dados para criar a entidade.
     * @return entidade de narguile criada com os dados recebidos.
     *
     * @author WellingtonKlinkowski
     */
    NarguileEntity fromRequestToEntity(NarguileRequest narguileRequest);

    /**
     * Recebe os dados do banco e transforma
     * no response de narguile.
     *
     * @param narguileEntity recebe os dados do banco e converte em um response.
     * @return response de narguile com os dados recebidos do banco.
     *
     * @author WellingtonKlinkowski
     */
    NarguileResponse fromEntityToResponse(NarguileEntity narguileEntity);
}
