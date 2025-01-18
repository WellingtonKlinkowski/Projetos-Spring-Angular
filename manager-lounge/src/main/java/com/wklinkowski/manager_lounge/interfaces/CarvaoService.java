package com.wklinkowski.manager_lounge.interfaces;

import com.wklinkowski.manager_lounge.dtos.CarvaoDTO;
import com.wklinkowski.manager_lounge.entities.CarvaoEntity;
import com.wklinkowski.manager_lounge.enums.MarcaCarvao;
import com.wklinkowski.manager_lounge.exceptions.InsumoInsuficienteException;

import java.util.List;

public interface CarvaoService {

    CarvaoDTO criarCarvao(CarvaoDTO carvaoDTO);

    CarvaoDTO procurarCarvaoPorId(Long id);

    List<CarvaoDTO> listarCarvoes();

    List<CarvaoDTO> procuraCarvaoPorMarcaCarvao(MarcaCarvao marcaCarvao);

    List<CarvaoDTO> procuraCarvaoPorPesoCarvao(Integer pesoCarvao);

    List<CarvaoDTO> procuraCarvaoPorQuantidadeCarvao(Integer quantidadeCarvao);

    List<CarvaoDTO> procuraCarvaoPorMarcaEPeso(MarcaCarvao marcaCarvao, Integer pesoCarvao);

    List<CarvaoDTO> procuraMarcaCarvaoUsandoLike(String marcaCarvao);

    List<CarvaoDTO> procuraCarvaoComPesoEntreDoisValores(Integer pesoMinimo, Integer pesoMaximo);

    List<CarvaoDTO> procuraCarvaoPorQuantidadeEmEstoque(Integer quantidadeEstoqueCarvao);

    CarvaoDTO atualizarCarvaoPorId(Long idCarvao, CarvaoDTO carvao);

    void consomeCarvaoDoEstoqueQuandoAlugado(Long idCarvao, Integer quantidadeCarvaoUsado) throws InsumoInsuficienteException;

    void atualizarEstoqueDeCaixasCarvao(CarvaoEntity carvaoEntity);

    void deletaCarvaoPorId(Long idCarvao);

    void deletarCarvaoPorMarcaCarvao(MarcaCarvao marcaCarvao);
}
