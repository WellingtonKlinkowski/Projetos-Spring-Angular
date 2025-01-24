package com.wklinkowski.manager_lounge.interfaces;

import com.wklinkowski.manager_lounge.dtos.request.RoshRequest;
import com.wklinkowski.manager_lounge.dtos.response.RoshResponse;
import com.wklinkowski.manager_lounge.enums.MarcasRosh;
import com.wklinkowski.manager_lounge.enums.MaterialRosh;

import java.util.List;

/**
 * Interface para agrupar métodos usados no
 * gerenciamento dos roshs.
 *
 * Uso: RoshServiceImpl
 *
 * @author WellingtonKlinkowski
 */
public interface RoshService {

    RoshResponse criarRosh(RoshRequest roshRequest);

    RoshResponse procuraRoshPorId(Long idRosh);

    List<RoshResponse> listarRosh();

    List<RoshResponse> procuraRoshPorMarcasRosh(MarcasRosh marcasRosh);

    List<RoshResponse> procuraRoshPorMaterialRosh(MaterialRosh materialRosh);

    List<RoshResponse> procuraMarcasRoshComMetodoLike(String marcaRosh);

    List<RoshResponse> procuraMaterialRoshComMetodoLike(String materialRosh);

    List<RoshResponse> procuraRoshPorQuantidadeEstoqueRosh(int quantidadeEstoqueRosh);

    RoshResponse atualizaRoshPorId(Long idRosh, RoshRequest roshRequest);

    void retornaConsumoAluguelParaEstoque(Long idRosh, Integer quantidadeRoshUsadoAluguel);

    void consomeRoshDoEstoqueQuandoAlugado(Long idRosh, Integer quantidadeRoshUsado);

    void deletaRoshPorId(Long idRosh);

    void apagaRoshPorMarcasRosh(MarcasRosh marcasRosh);

    void apagaRoshPorMaterialRosh(MaterialRosh materialRosh);
}
