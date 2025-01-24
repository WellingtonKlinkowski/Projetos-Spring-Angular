package com.wklinkowski.manager_lounge.interfaces;

import com.wklinkowski.manager_lounge.dtos.request.CarvaoRequest;
import com.wklinkowski.manager_lounge.dtos.response.CarvaoResponse;
import com.wklinkowski.manager_lounge.entities.CarvaoEntity;
import com.wklinkowski.manager_lounge.enums.MarcaCarvao;
import com.wklinkowski.manager_lounge.exceptions.InsumoInsuficienteException;

import java.util.List;

/**
 * Interface para agrupar métodos usados no
 * gerenciamento dos carvões.
 *
 * Uso: CarvaoServiceImpl
 *
 * @author WellingtonKlinkowski
 */
public interface CarvaoService {

    CarvaoResponse criarCarvao(CarvaoRequest carvaoRequest);

    CarvaoResponse procurarCarvaoPorId(Long id);

    List<CarvaoResponse> listarCarvoes();

    List<CarvaoResponse> procuraCarvaoPorMarcaCarvao(MarcaCarvao marcaCarvao);

    List<CarvaoResponse> procuraCarvaoPorPesoCarvao(Integer pesoCarvao);

    List<CarvaoResponse> procuraCarvaoPorQuantidadeCarvao(Integer quantidadeCarvao);

    List<CarvaoResponse> procuraCarvaoPorMarcaEPeso(MarcaCarvao marcaCarvao, Integer pesoCarvao);

    List<CarvaoResponse> procuraMarcaCarvaoUsandoLike(String marcaCarvao);

    List<CarvaoResponse> procuraCarvaoComPesoEntreDoisValores(Integer pesoMinimo, Integer pesoMaximo);

    List<CarvaoResponse> procuraCarvaoPorQuantidadeEmEstoque(Integer quantidadeEstoqueCarvao);

    CarvaoResponse atualizarCarvaoPorId(Long idCarvao, CarvaoRequest carvaoRequest);

    void retornaConsumoAluguelParaEstoque(Long idCarvao, Integer quantidadeCarvaoUsadoAluguel);

    void consomeCarvaoDoEstoqueQuandoAlugado(Long idCarvao, Integer quantidadeCarvaoUsado) throws InsumoInsuficienteException;

    void atualizarEstoqueDeCaixasCarvao(CarvaoEntity carvaoEntity);

    void deletaCarvaoPorId(Long idCarvao);

    void deletarCarvaoPorMarcaCarvao(MarcaCarvao marcaCarvao);
}
