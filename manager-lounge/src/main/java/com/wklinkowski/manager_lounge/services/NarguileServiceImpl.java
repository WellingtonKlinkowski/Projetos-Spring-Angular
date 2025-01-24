package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.dtos.request.NarguileRequest;
import com.wklinkowski.manager_lounge.dtos.response.NarguileResponse;
import com.wklinkowski.manager_lounge.entities.NarguileEntity;
import com.wklinkowski.manager_lounge.enums.MarcasNarguile;
import com.wklinkowski.manager_lounge.enums.MaterialNarguile;
import com.wklinkowski.manager_lounge.exceptions.EntidadeNaoEncontrada;
import com.wklinkowski.manager_lounge.exceptions.InsumoInsuficienteException;
import com.wklinkowski.manager_lounge.interfaces.NarguileService;
import com.wklinkowski.manager_lounge.mappers.NarguileMapper;
import com.wklinkowski.manager_lounge.repositories.NarguileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NarguileServiceImpl implements NarguileService {

    private final NarguileRepository narguileRepository;
    private final NarguileMapper narguileMapper;

    public NarguileServiceImpl(NarguileRepository narguileRepository, NarguileMapper narguileMapper) {
        this.narguileRepository = narguileRepository;
        this.narguileMapper = narguileMapper;
    }

    @Override
    @Transactional
    public NarguileResponse criarNarguile(NarguileRequest narguileRequest) {
        NarguileEntity narguileEntity = narguileRepository.save(narguileMapper.fromRequestToEntity(narguileRequest));

        return narguileMapper.fromEntityToResponse(narguileEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public NarguileResponse procuraNarguilePorId(Long idNarguile) {
        NarguileEntity narguileResultado = narguileRepository.findById(idNarguile)
                .orElseThrow(EntidadeNaoEncontrada::new);

        return narguileMapper.fromEntityToResponse(narguileResultado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileResponse> listarNarguiles() {
        List<NarguileEntity> listaNarguileEntity = narguileRepository.findAll();

        return listaNarguileEntity.stream().map(narguileMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileResponse> procuraNarguilePorNomeNarguile(String nomeNarguile) {
        List<NarguileEntity> listaNarguilePorNome =
                narguileRepository.findByNomeNarguileOrderByNomeNarguileDesc(nomeNarguile);

        return listaNarguilePorNome.stream().map(narguileMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileResponse> procuraNarguilePorMarcaNarguile(MarcasNarguile marcaNarguile) {
        List<NarguileEntity> listaNarguilePorMarca =
                narguileRepository.findByMarcasNarguileOrderByMarcasNarguileDesc(marcaNarguile);

        return listaNarguilePorMarca.stream().map(narguileMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileResponse> procuraNarguilePorQuantidadeMangueirasNarguile(Integer quantidadeMangueirasNarguile) {
        List<NarguileEntity> listaNarguilePorQuantidadeMangueiras =
                narguileRepository.findByQuantidadeMangueirasNarguileOrderByQuantidadeMangueirasNarguileDesc(quantidadeMangueirasNarguile);

        return listaNarguilePorQuantidadeMangueiras.stream().map(narguileMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileResponse> procuraNarguilePorMaterialNarguile(MaterialNarguile materialNarguile) {
        List<NarguileEntity> listaNarguilePorMaterial =
                narguileRepository.findByMaterialNarguileOrderByMaterialNarguileDesc(materialNarguile);

        return listaNarguilePorMaterial.stream().map(narguileMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileResponse> procuraNarguilePorNomeNarguileComMetodoLike(String nomeNarguile) {
        List<NarguileEntity> listaNarguilePorMaterial =
                narguileRepository.procuraNomeNarguileComMetodoLike(nomeNarguile);

        return listaNarguilePorMaterial.stream().map(narguileMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileResponse> procuraNarguilePorMarcasNarguileComMetodoLike(String marcaNarguile) {
        List<NarguileEntity> listaNarguilePorMarca =
                narguileRepository.procuraMarcasNarguileComMetodoLike(marcaNarguile);

        return listaNarguilePorMarca.stream().map(narguileMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileResponse> procuraNarguilePorMaterialNarguileComMetodoLike(String materialNarguile) {
        List<NarguileEntity> listaNarguilePorMaterial =
                narguileRepository.procuraMaterialNarguileComMetodoLike(materialNarguile);

        return listaNarguilePorMaterial.stream().map(narguileMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileResponse> procuraNarguileEntreQuantidadeMangueirasNarguile(Integer quantidadeMangueirasMinimo, Integer quantidadeMangueirasMaximo) {
        List<NarguileEntity> listaNarguilePorQuantidadeMangueiras =
                narguileRepository.findByQuantidadeMangueirasNarguileBetween(quantidadeMangueirasMinimo, quantidadeMangueirasMaximo);

        return listaNarguilePorQuantidadeMangueiras.stream().map(narguileMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileResponse> procuraNarguilePorQuantidadeEstoqueNarguile(Integer quantidadeEstoqueNarguile) {
        List<NarguileEntity> listaNarguilePorQuantidadeEstoque =
                narguileRepository.findByQuantidadeEstoqueNarguileOrderByQuantidadeEstoqueNarguileDesc(quantidadeEstoqueNarguile);

        return listaNarguilePorQuantidadeEstoque.stream().map(narguileMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public NarguileResponse atualizaNarguilePorId(Long idNarguile, NarguileRequest narguileRequest) {
        NarguileEntity narguileEntity = narguileRepository.findById(idNarguile).orElseThrow(() ->
                new EntidadeNaoEncontrada());

        narguileEntity.setMarcasNarguile(narguileRequest.getMarcasNarguile());
        narguileEntity.setMaterialNarguile(narguileRequest.getMaterialNarguile());
        narguileEntity.setNomeNarguile(narguileRequest.getNomeNarguile());
        narguileEntity.setQuantidadeMangueirasNarguile(narguileRequest.getQuantidadeMangueirasNarguile());
        narguileEntity.setQuantidadeEstoqueNarguile(narguileRequest.getQuantidadeEstoqueNarguile());

        return narguileMapper.fromEntityToResponse(narguileRepository.save(narguileEntity));
    }

    @Override
    @Transactional
    public void consomeNarguileDoEstoqueQuandoAlugado(Long idNarguile, Integer quantidadeNarguileUsada) {
        NarguileEntity narguileResultado = narguileRepository.findById(idNarguile)
                .orElseThrow(EntidadeNaoEncontrada::new);

        if(narguileResultado.getQuantidadeEstoqueNarguile() < quantidadeNarguileUsada){
            throw new InsumoInsuficienteException(narguileResultado.getNomeNarguile());
        }

        narguileResultado.setQuantidadeEstoqueNarguile(
                narguileResultado.getQuantidadeEstoqueNarguile() - quantidadeNarguileUsada);

        narguileRepository.save(narguileResultado);
    }

    @Override
    @Transactional
    public void retornaConsumoAluguelParaEstoque(Long idNarguile, Integer quantidadeNarguileUsadoAluguel) {
        NarguileEntity narguileResultado = narguileRepository.findById(idNarguile)
                .orElseThrow(EntidadeNaoEncontrada::new);

        narguileResultado.setQuantidadeEstoqueNarguile(narguileResultado.getQuantidadeEstoqueNarguile() + quantidadeNarguileUsadoAluguel);

        narguileRepository.save(narguileResultado);
    }

    @Override
    @Transactional
    public void apagaNarguilePorMarcasNarguile(MarcasNarguile marcasNarguile) {
        narguileRepository.deleteByMarcasNarguile(marcasNarguile);
    }

    @Override
    @Transactional
    public void apagaNarguilePorId(Long idNarguile) {
        NarguileEntity narguileEntity = narguileRepository.findById(idNarguile).orElseThrow( () ->
                new EntidadeNaoEncontrada());

        narguileRepository.delete(narguileEntity);
    }

    @Override
    @Transactional
    public void apagaNarguilePorMaterialNarguile(MaterialNarguile materialNarguile) {
        narguileRepository.deleteByMaterialNarguile(materialNarguile);
    }

    @Override
    @Transactional
    public void apagaNarguilePorQuantidadeMangueirasNarguile(Integer quantidadeMangueirasNarguile) {
        narguileRepository.deleteByQuantidadeMangueirasNarguile(quantidadeMangueirasNarguile);
    }
}
