package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.dtos.NarguileDTO;
import com.wklinkowski.manager_lounge.entities.NarguileEntity;
import com.wklinkowski.manager_lounge.enums.MarcasNarguile;
import com.wklinkowski.manager_lounge.enums.MaterialNarguile;
import com.wklinkowski.manager_lounge.exceptions.EntidadeNaoEncontrada;
import com.wklinkowski.manager_lounge.interfaces.NarguileService;
import com.wklinkowski.manager_lounge.mappers.NarguileMapper;
import com.wklinkowski.manager_lounge.repositories.NarguileRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public NarguileDTO criarNarguile(NarguileDTO narguileDTO) {
        NarguileEntity narguileEntity = narguileRepository.save(narguileMapper.toEntity(narguileDTO));

        return narguileMapper.toDto(narguileEntity);
    }

    @Override
    @Transactional
    public NarguileDTO procuraNarguilePorId(Long idNarguile) {
        Optional<NarguileEntity> opationalNarguile = narguileRepository.findById(idNarguile);

        return opationalNarguile.map(narguileMapper::toDto).orElse(null);
    }

    @Override
    @Transactional
    public List<NarguileDTO> listarNarguiles() {
        List<NarguileEntity> listaNarguileEntity = narguileRepository.findAll();

        return listaNarguileEntity.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<NarguileDTO> procuraNarguilePorNomeNarguile(String nomeNarguile) {
        List<NarguileEntity> listaNarguilePorNome =
                narguileRepository.findByNomeNarguileOrderByNomeNarguileDesc(nomeNarguile);

        return listaNarguilePorNome.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<NarguileDTO> procuraNarguilePorMarcaNarguile(MarcasNarguile marcaNarguile) {
        List<NarguileEntity> listaNarguilePorMarca =
                narguileRepository.findByMarcasNarguileOrderByMarcasNarguileDesc(marcaNarguile);

        return listaNarguilePorMarca.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<NarguileDTO> procuraNarguilePorQuantidadeMangueirasNarguile(Integer quantidadeMangueirasNarguile) {
        List<NarguileEntity> listaNarguilePorQuantidadeMangueiras =
                narguileRepository.findByQuantidadeMangueirasNarguileOrderByQuantidadeMangueirasNarguileDesc(quantidadeMangueirasNarguile);

        return listaNarguilePorQuantidadeMangueiras.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<NarguileDTO> procuraNarguilePorMaterialNarguile(MaterialNarguile materialNarguile) {
        List<NarguileEntity> listaNarguilePorMaterial =
                narguileRepository.findByMaterialNarguileOrderByMaterialNarguileDesc(materialNarguile);

        return listaNarguilePorMaterial.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<NarguileDTO> procuraNarguilePorNomeNarguileComMetodoLike(String nomeNarguile) {
        List<NarguileEntity> listaNarguilePorMaterial =
                narguileRepository.procuraNomeNarguileComMetodoLike(nomeNarguile);

        return listaNarguilePorMaterial.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<NarguileDTO> procuraNarguilePorMarcasNarguileComMetodoLike(String marcaNarguile) {
        List<NarguileEntity> listaNarguilePorMarca =
                narguileRepository.procuraMarcasNarguileComMetodoLike(marcaNarguile);

        return listaNarguilePorMarca.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<NarguileDTO> procuraNarguilePorMaterialNarguileComMetodoLike(String materialNarguile) {
        List<NarguileEntity> listaNarguilePorMaterial =
                narguileRepository.procuraMaterialNarguileComMetodoLike(materialNarguile);

        return listaNarguilePorMaterial.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<NarguileDTO> procuraNarguileEntreQuantidadeMangueirasNarguile(Integer quantidadeMangueirasMinimo, Integer quantidadeMangueirasMaximo) {
        List<NarguileEntity> listaNarguilePorQuantidadeMangueiras =
                narguileRepository.findByQuantidadeMangueirasNarguileBetween(quantidadeMangueirasMinimo, quantidadeMangueirasMaximo);

        return listaNarguilePorQuantidadeMangueiras.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<NarguileDTO> procuraNarguilePorQuantidadeEstoqueNarguile(Integer quantidadeEstoqueNarguile) {
        List<NarguileEntity> listaNarguilePorQuantidadeEstoque =
                narguileRepository.findByQuantidadeEstoqueNarguileOrderByQuantidadeEstoqueNarguileDesc(quantidadeEstoqueNarguile);

        return listaNarguilePorQuantidadeEstoque.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public NarguileDTO atualizaNarguilePorId(Long idNarguile, NarguileDTO narguileDTO) {
        NarguileEntity narguileEntity = narguileRepository.findById(idNarguile).orElseThrow(() ->
                new EntidadeNaoEncontrada());

        narguileEntity.setMarcasNarguile(narguileDTO.getMarcasNarguile());
        narguileEntity.setMaterialNarguile(narguileDTO.getMaterialNarguile());
        narguileEntity.setNomeNarguile(narguileDTO.getNomeNarguile());
        narguileEntity.setQuantidadeMangueirasNarguile(narguileDTO.getQuantidadeMangueirasNarguile());
        narguileEntity.setQuantidadeEstoqueNarguile(narguileDTO.getQuantidadeEstoqueNarguile());

        return narguileMapper.toDto(narguileRepository.save(narguileEntity));
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
