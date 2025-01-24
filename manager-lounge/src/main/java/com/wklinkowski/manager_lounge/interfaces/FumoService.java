package com.wklinkowski.manager_lounge.interfaces;

import com.wklinkowski.manager_lounge.dtos.request.FumoRequest;
import com.wklinkowski.manager_lounge.dtos.response.FumoResponse;
import com.wklinkowski.manager_lounge.entities.FumoEntity;
import com.wklinkowski.manager_lounge.enums.MarcasFumo;

import java.util.List;

/**
 * Interface para agrupar métodos usados no
 * gerenciamento dos fumos.
 *
 * Uso: FumoServiceImpl
 *
 * @author WellingtonKlinkowski
 */
public interface FumoService {

    FumoResponse criarFumo(FumoRequest fumoRequest);

    FumoResponse procurarFumoPorId(Long idFumo);

    List<FumoResponse> listarFumos();

    List<FumoResponse> procuraFumoPorMarcasFumo(MarcasFumo marcasFumo);

    List<FumoResponse> procuraFumoPorSaborFumo(String saborFumo);

    List<FumoResponse> procuraFumoPorPesoFumo(Integer pesoFumo);

    List<FumoResponse> procuraFumoPorMarcasFumoUsandoLike(String marcasFumo);

    List<FumoResponse> procuraFumoPorSaborFumoUsandoLike(String saborFumo);

    List<FumoResponse> procuraFumoEntrePesos(Integer pesoMinimoFumo, Integer pesoMaximoFumo);

    List<FumoResponse> procuraFumoPorQuantidadeEmEstoque(Integer quantidadeEstoqueFumo);

    FumoResponse atualizaFumoPorId(Long idFumo, FumoRequest fumoRequest);

    void retornaConsumoAluguelParaEstoque(Long idFumo, Integer quantidadeFumoUsadoAluguel);

    void consomeFumoDoEstoqueQuandoAlugado(Long idFumo, Integer quantidadeFumoUsado);

    void atualizarEstoqueDeCaixasFumo(FumoEntity fumoEntity);

    void deletaFumoPorId(Long idFumo);

    void apagaFumoPorMarcasFumo(MarcasFumo marcasFumo);
}
