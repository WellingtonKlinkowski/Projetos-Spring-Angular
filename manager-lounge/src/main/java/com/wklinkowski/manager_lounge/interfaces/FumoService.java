package com.wklinkowski.manager_lounge.interfaces;

import com.wklinkowski.manager_lounge.dtos.FumoDTO;
import com.wklinkowski.manager_lounge.entities.FumoEntity;
import com.wklinkowski.manager_lounge.enums.MarcasFumo;

import java.util.List;

public interface FumoService {

    FumoDTO criarFumo(FumoDTO fumoDTO);

    FumoDTO procurarFumoPorId(Long idFumo);

    List<FumoDTO> listarFumos();

    List<FumoDTO> procuraFumoPorMarcasFumo(MarcasFumo marcasFumo);

    List<FumoDTO> procuraFumoPorSaborFumo(String saborFumo);

    List<FumoDTO> procuraFumoPorPesoFumo(Integer pesoFumo);

    List<FumoDTO> procuraFumoPorMarcasFumoUsandoLike(String marcasFumo);

    List<FumoDTO> procuraFumoPorSaborFumoUsandoLike(String saborFumo);

    List<FumoDTO> procuraFumoEntrePesos(Integer pesoMinimoFumo, Integer pesoMaximoFumo);

    List<FumoDTO> procuraFumoPorQuantidadeEmEstoque(Integer quantidadeEstoqueFumo);

    FumoDTO atualizaFumoPorId(Long idFumo, FumoDTO fumoDTO);

    void retornaConsumoAluguelParaEstoque(Long idFumo, Integer quantidadeFumoUsadoAluguel);

    void consomeFumoDoEstoqueQuandoAlugado(Long idFumo, Integer quantidadeFumoUsado);

    void atualizarEstoqueDeCaixasFumo(FumoEntity fumoEntity);

    void deletaFumoPorId(Long idFumo);

    void apagaFumoPorMarcasFumo(MarcasFumo marcasFumo);
}
