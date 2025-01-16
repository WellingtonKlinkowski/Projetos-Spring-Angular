package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.dtos.RoshDTO;
import com.wklinkowski.manager_lounge.entities.RoshEntity;
import com.wklinkowski.manager_lounge.enums.MarcasRosh;
import com.wklinkowski.manager_lounge.enums.MaterialRosh;
import com.wklinkowski.manager_lounge.exceptions.EntidadeNaoEncontrada;
import com.wklinkowski.manager_lounge.mappers.RoshMapper;
import com.wklinkowski.manager_lounge.repositories.RoshRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoshService {

    private final RoshRepository roshRepository;
    private final RoshMapper roshMapper;

    public RoshService(RoshRepository roshRepository, RoshMapper roshMapper) {
        this.roshRepository = roshRepository;
        this.roshMapper = roshMapper;
    }

    @Transactional
    public RoshDTO criarRosh(RoshDTO roshDTO) {
        RoshEntity roshEntity = roshRepository.save(roshMapper.toEntity(roshDTO));

        return roshMapper.toDto(roshEntity);
    }

    @Transactional
    public RoshDTO procuraRoshPorId(Long idRosh) {
        Optional<RoshEntity> optionalRosh = roshRepository.findById(idRosh);

        return optionalRosh.map(roshMapper::toDto).orElse(null);
    }

    @Transactional
    public List<RoshDTO> listarRosh() {
        List<RoshEntity> listaRoshEntity = roshRepository.findAll();

        return listaRoshEntity.stream().map(roshMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<RoshDTO> procuraRoshPorMarcasRosh(MarcasRosh marcasRosh) {
        List<RoshEntity> listaRoshPorMarca = roshRepository.findByMarcasRoshOrderByMarcasRoshDesc(marcasRosh);

        return listaRoshPorMarca.stream().map(roshMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<RoshDTO> procuraRoshPorMaterialRosh(MaterialRosh materialRosh) {
        List<RoshEntity> listaRoshPorMaterial = roshRepository.findByMaterialRoshOrderByMaterialRoshDesc(materialRosh);

        return listaRoshPorMaterial.stream().map(roshMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<RoshDTO> procuraMarcasRoshComMetodoLike(String marcaRosh) {
        List<RoshEntity> listaRoshPorMarca = roshRepository.procuraMarcasRoshComMetodoLike(marcaRosh);

        return listaRoshPorMarca.stream().map(roshMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<RoshDTO> procuraMaterialRoshComMetodoLike(String materialRosh) {
        List<RoshEntity> listaRoshPorMaterial = roshRepository.procuraMaterialRoshComMetodoLike(materialRosh);

        return listaRoshPorMaterial.stream().map(roshMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<RoshDTO> procuraRoshPorQuantidadeEstoqueRosh(int quantidadeEstoqueRosh) {
        List<RoshEntity> listaRoshPorQuantidadeEstoque = roshRepository.findByQuantidadeEstoqueRoshOrderByQuantidadeEstoqueRoshDesc(quantidadeEstoqueRosh);

        return listaRoshPorQuantidadeEstoque.stream().map(roshMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public RoshDTO atualizaRoshPorId(Long idRosh, RoshDTO roshDTO) {
        RoshEntity roshEntity = roshRepository.findById(idRosh).orElseThrow(() ->
                new EntidadeNaoEncontrada());

        roshEntity.setMaterialRosh(roshDTO.getMaterialRosh());
        roshEntity.setMarcasRosh(roshDTO.getMarcasRosh());
        roshEntity.setQuantidadeEstoqueRosh(roshDTO.getQuantidadeEstoqueRosh());

        return roshMapper.toDto(roshRepository.save(roshEntity));
    }

    @Transactional
    public void deletaRoshPorId(Long idRosh) {
        RoshEntity roshEntity = roshRepository.findById(idRosh).orElseThrow(() ->
                new EntidadeNaoEncontrada());

        roshRepository.delete(roshEntity);
    }

    @Transactional
    public void apagaRoshPorMarcasRosh(MarcasRosh marcasRosh) {
        roshRepository.deleteByMarcasRosh(marcasRosh);
    }

    @Transactional
    public void apagaRoshPorMaterialRosh(MaterialRosh materialRosh) {
        roshRepository.deleteByMaterialRosh(materialRosh);
    }
}
