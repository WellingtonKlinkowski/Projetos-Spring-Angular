package com.wklinkowski.manager_lounge.interfaces;

import com.wklinkowski.manager_lounge.dtos.NarguileDTO;
import com.wklinkowski.manager_lounge.enums.MarcasNarguile;
import com.wklinkowski.manager_lounge.enums.MaterialNarguile;

import java.util.List;

public interface NarguileService {

    NarguileDTO criarNarguile(NarguileDTO narguileDTO);

    NarguileDTO procuraNarguilePorId(Long idNarguile);

    List<NarguileDTO> listarNarguiles();

    List<NarguileDTO> procuraNarguilePorNomeNarguile(String nomeNarguile);

    List<NarguileDTO> procuraNarguilePorMarcaNarguile(MarcasNarguile marcaNarguile);

    List<NarguileDTO> procuraNarguilePorQuantidadeMangueirasNarguile(Integer quantidadeMangueirasNarguile);

    List<NarguileDTO> procuraNarguilePorMaterialNarguile(MaterialNarguile materialNarguile);

    List<NarguileDTO> procuraNarguilePorNomeNarguileComMetodoLike(String nomeNarguile);

    List<NarguileDTO> procuraNarguilePorMarcasNarguileComMetodoLike(String marcaNarguile);

    List<NarguileDTO> procuraNarguilePorMaterialNarguileComMetodoLike(String materialNarguile);

    List<NarguileDTO> procuraNarguileEntreQuantidadeMangueirasNarguile(Integer quantidadeMangueirasMinimo, Integer quantidadeMangueirasMaximo);

    List<NarguileDTO> procuraNarguilePorQuantidadeEstoqueNarguile(Integer quantidadeEstoqueNarguile);

    NarguileDTO atualizaNarguilePorId(Long idNarguile, NarguileDTO narguileDTO);

    void retornaConsumoAluguelParaEstoque(Long idNarguile, Integer quantidadeNarguileUsadoAluguel);

    void consomeNarguileDoEstoqueQuandoAlugado(Long idNarguile, Integer quantidadeNarguileUsada);

    void apagaNarguilePorMarcasNarguile(MarcasNarguile marcasNarguile);

    void apagaNarguilePorId(Long idNarguile);

    void apagaNarguilePorMaterialNarguile(MaterialNarguile materialNarguile);

    void apagaNarguilePorQuantidadeMangueirasNarguile(Integer quantidadeMangueirasNarguile);
}
