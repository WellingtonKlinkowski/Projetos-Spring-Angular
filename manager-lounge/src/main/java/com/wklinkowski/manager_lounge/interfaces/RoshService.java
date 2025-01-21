package com.wklinkowski.manager_lounge.interfaces;

import com.wklinkowski.manager_lounge.dtos.RoshDTO;
import com.wklinkowski.manager_lounge.enums.MarcasRosh;
import com.wklinkowski.manager_lounge.enums.MaterialRosh;

import java.util.List;

public interface RoshService {

    RoshDTO criarRosh(RoshDTO roshDTO);

    RoshDTO procuraRoshPorId(Long idRosh);

    List<RoshDTO> listarRosh();

    List<RoshDTO> procuraRoshPorMarcasRosh(MarcasRosh marcasRosh);

    List<RoshDTO> procuraRoshPorMaterialRosh(MaterialRosh materialRosh);

    List<RoshDTO> procuraMarcasRoshComMetodoLike(String marcaRosh);

    List<RoshDTO> procuraMaterialRoshComMetodoLike(String materialRosh);

    List<RoshDTO> procuraRoshPorQuantidadeEstoqueRosh(int quantidadeEstoqueRosh);

    RoshDTO atualizaRoshPorId(Long idRosh, RoshDTO roshDTO);

    void retornaConsumoAluguelParaEstoque(Long idRosh, Integer quantidadeRoshUsadoAluguel);

    void consomeRoshDoEstoqueQuandoAlugado(Long idRosh, Integer quantidadeRoshUsado);

    void deletaRoshPorId(Long idRosh);

    void apagaRoshPorMarcasRosh(MarcasRosh marcasRosh);

    void apagaRoshPorMaterialRosh(MaterialRosh materialRosh);
}
