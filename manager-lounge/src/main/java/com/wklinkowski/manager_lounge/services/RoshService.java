package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.dtos.RoshDTO;
import com.wklinkowski.manager_lounge.entities.RoshEntity;
import com.wklinkowski.manager_lounge.enums.MarcasRosh;
import com.wklinkowski.manager_lounge.enums.MaterialRosh;
import com.wklinkowski.manager_lounge.exceptions.EntidadeNaoEncontrada;
import com.wklinkowski.manager_lounge.repositories.RoshRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoshService {

    private final RoshRepository roshRepository;

    public RoshService(RoshRepository roshRepository) {
        this.roshRepository = roshRepository;
    }

    @Transactional
    public RoshDTO criarRosh(RoshDTO roshDTO) {
        RoshEntity roshEntity = roshRepository.save(new RoshEntity(roshDTO));

        return new RoshDTO(roshEntity);
    }

    @Transactional
    public RoshDTO procuraRoshPorId(Long idRosh) {
        Optional<RoshEntity> optionalRosh = roshRepository.findById(idRosh);

        return optionalRosh.map(RoshDTO::new).orElse(null);
    }

    @Transactional
    public List<RoshDTO> listarRosh() {
        List<RoshEntity> listaRoshEntity = roshRepository.findAll();

        return listaRoshEntity.stream().map(rosh -> new RoshDTO(rosh)).collect(Collectors.toList());
    }

    @Transactional
    public List<RoshDTO> procuraRoshPorMarcasRosh(MarcasRosh marcasRosh) {
        List<RoshEntity> listaRoshPorMarca = roshRepository.findByMarcasRoshOrderByMarcasRoshDesc(marcasRosh);

        return listaRoshPorMarca.stream().map(rosh ->
                new RoshDTO(rosh)).collect(Collectors.toList());
    }

    @Transactional
    public List<RoshDTO> procuraRoshPorMaterialRosh(MaterialRosh materialRosh) {
        List<RoshEntity> listaRoshPorMaterial = roshRepository.findByMaterialRoshOrderByMaterialRoshDesc(materialRosh);

        return listaRoshPorMaterial.stream().map(rosh ->
                new RoshDTO(rosh)).collect(Collectors.toList());
    }

    @Transactional
    public List<RoshDTO> procuraMarcasRoshComMetodoLike(String marcaRosh) {
        List<RoshEntity> listaRoshPorMarca = roshRepository.procuraMarcasRoshComMetodoLike(marcaRosh);

        return listaRoshPorMarca.stream().map(rosh ->
                new RoshDTO(rosh)).collect(Collectors.toList());
    }

    @Transactional
    public List<RoshDTO> procuraMaterialRoshComMetodoLike(String materialRosh) {
        List<RoshEntity> listaRoshPorMaterial = roshRepository.procuraMaterialRoshComMetodoLike(materialRosh);

        return listaRoshPorMaterial.stream().map(rosh ->
                new RoshDTO(rosh)).collect(Collectors.toList());
    }

    @Transactional
    public List<RoshDTO> procuraRoshPorQuantidadeEstoqueRosh(int quantidadeEstoqueRosh) {
        List<RoshEntity> listaRoshPorQuantidadeEstoque = roshRepository.findByQuantidadeEstoqueRoshOrderByQuantidadeEstoqueRoshDesc(quantidadeEstoqueRosh);

        return listaRoshPorQuantidadeEstoque.stream().map(rosh ->
                new RoshDTO(rosh)).collect(Collectors.toList());
    }

    @Transactional
    public RoshDTO atualizaRoshPorId(Long idRosh, RoshDTO roshDTO) {
        RoshEntity roshEntity = roshRepository.findById(idRosh).orElseThrow(() ->
                new EntidadeNaoEncontrada());

        roshEntity.setMaterialRosh(roshDTO.getMaterialRosh());
        roshEntity.setMarcasRosh(roshDTO.getMarcasRosh());
        roshEntity.setQuantidadeEstoqueRosh(roshDTO.getQuantidadeEstoqueRosh());

        return new RoshDTO(roshRepository.save(roshEntity));
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
