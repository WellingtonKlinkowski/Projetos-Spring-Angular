package com.wklinkowski.manager_lounge.interfaces;

import com.wklinkowski.manager_lounge.dtos.request.NarguileRequest;
import com.wklinkowski.manager_lounge.dtos.response.NarguileResponse;
import com.wklinkowski.manager_lounge.enums.MarcasNarguile;
import com.wklinkowski.manager_lounge.enums.MaterialNarguile;

import java.util.List;

/**
 * Interface para agrupar métodos usados no
 * gerenciamento das narguiles.
 *
 * Uso: NarguileServiceImpl
 *
 * @author WellingtonKlinkowski
 */
public interface NarguileService {

    NarguileResponse criarNarguile(NarguileRequest narguileRequest);

    NarguileResponse procuraNarguilePorId(Long idNarguile);

    List<NarguileResponse> listarNarguiles();

    List<NarguileResponse> procuraNarguilePorNomeNarguile(String nomeNarguile);

    List<NarguileResponse> procuraNarguilePorMarcaNarguile(MarcasNarguile marcaNarguile);

    List<NarguileResponse> procuraNarguilePorQuantidadeMangueirasNarguile(Integer quantidadeMangueirasNarguile);

    List<NarguileResponse> procuraNarguilePorMaterialNarguile(MaterialNarguile materialNarguile);

    List<NarguileResponse> procuraNarguilePorNomeNarguileComMetodoLike(String nomeNarguile);

    List<NarguileResponse> procuraNarguilePorMarcasNarguileComMetodoLike(String marcaNarguile);

    List<NarguileResponse> procuraNarguilePorMaterialNarguileComMetodoLike(String materialNarguile);

    List<NarguileResponse> procuraNarguileEntreQuantidadeMangueirasNarguile(Integer quantidadeMangueirasMinimo, Integer quantidadeMangueirasMaximo);

    List<NarguileResponse> procuraNarguilePorQuantidadeEstoqueNarguile(Integer quantidadeEstoqueNarguile);

    NarguileResponse atualizaNarguilePorId(Long idNarguile, NarguileRequest narguileRequest);

    void retornaConsumoAluguelParaEstoque(Long idNarguile, Integer quantidadeNarguileUsadoAluguel);

    void consomeNarguileDoEstoqueQuandoAlugado(Long idNarguile, Integer quantidadeNarguileUsada);

    void apagaNarguilePorMarcasNarguile(MarcasNarguile marcasNarguile);

    void apagaNarguilePorId(Long idNarguile);

    void apagaNarguilePorMaterialNarguile(MaterialNarguile materialNarguile);

    void apagaNarguilePorQuantidadeMangueirasNarguile(Integer quantidadeMangueirasNarguile);
}
