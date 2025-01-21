package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.dtos.RoshDTO;
import com.wklinkowski.manager_lounge.entities.RoshEntity;
import com.wklinkowski.manager_lounge.enums.MarcasRosh;
import com.wklinkowski.manager_lounge.enums.MaterialRosh;
import com.wklinkowski.manager_lounge.exceptions.EntidadeNaoEncontrada;
import com.wklinkowski.manager_lounge.exceptions.InsumoInsuficienteException;
import com.wklinkowski.manager_lounge.interfaces.RoshService;
import com.wklinkowski.manager_lounge.mappers.RoshMapper;
import com.wklinkowski.manager_lounge.repositories.RoshRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoshServiceImpl implements RoshService {

    private final RoshRepository roshRepository;
    private final RoshMapper roshMapper;

    public RoshServiceImpl(RoshRepository roshRepository, RoshMapper roshMapper) {
        this.roshRepository = roshRepository;
        this.roshMapper = roshMapper;
    }

    @Override
    @Transactional
    public RoshDTO criarRosh(RoshDTO roshDTO) {
        RoshEntity roshEntity = roshRepository.save(roshMapper.toEntity(roshDTO));

        return roshMapper.toDto(roshEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public RoshDTO procuraRoshPorId(Long idRosh) {
        RoshEntity roshResultado = roshRepository.findById(idRosh)
                .orElseThrow(EntidadeNaoEncontrada::new);

        return roshMapper.toDto(roshResultado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoshDTO> listarRosh() {
        List<RoshEntity> listaRoshEntity = roshRepository.findAll();

        return listaRoshEntity.stream().map(roshMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoshDTO> procuraRoshPorMarcasRosh(MarcasRosh marcasRosh) {
        List<RoshEntity> listaRoshPorMarca = roshRepository.findByMarcasRoshOrderByMarcasRoshDesc(marcasRosh);

        return listaRoshPorMarca.stream().map(roshMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoshDTO> procuraRoshPorMaterialRosh(MaterialRosh materialRosh) {
        List<RoshEntity> listaRoshPorMaterial = roshRepository.findByMaterialRoshOrderByMaterialRoshDesc(materialRosh);

        return listaRoshPorMaterial.stream().map(roshMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoshDTO> procuraMarcasRoshComMetodoLike(String marcaRosh) {
        List<RoshEntity> listaRoshPorMarca = roshRepository.procuraMarcasRoshComMetodoLike(marcaRosh);

        return listaRoshPorMarca.stream().map(roshMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoshDTO> procuraMaterialRoshComMetodoLike(String materialRosh) {
        List<RoshEntity> listaRoshPorMaterial = roshRepository.procuraMaterialRoshComMetodoLike(materialRosh);

        return listaRoshPorMaterial.stream().map(roshMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoshDTO> procuraRoshPorQuantidadeEstoqueRosh(int quantidadeEstoqueRosh) {
        List<RoshEntity> listaRoshPorQuantidadeEstoque = roshRepository.findByQuantidadeEstoqueRoshOrderByQuantidadeEstoqueRoshDesc(quantidadeEstoqueRosh);

        return listaRoshPorQuantidadeEstoque.stream().map(roshMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public RoshDTO atualizaRoshPorId(Long idRosh, RoshDTO roshDTO) {
        RoshEntity roshEntity = roshRepository.findById(idRosh).orElseThrow(() ->
                new EntidadeNaoEncontrada());

        roshEntity.setMaterialRosh(roshDTO.getMaterialRosh());
        roshEntity.setMarcasRosh(roshDTO.getMarcasRosh());
        roshEntity.setQuantidadeEstoqueRosh(roshDTO.getQuantidadeEstoqueRosh());

        return roshMapper.toDto(roshRepository.save(roshEntity));
    }

    @Override
    @Transactional
    public void consomeRoshDoEstoqueQuandoAlugado(Long idRosh, Integer quantidadeRoshUsado) {
        RoshEntity roshResultado = roshRepository.findById(idRosh)
                .orElseThrow(EntidadeNaoEncontrada::new);

        if(roshResultado.getQuantidadeEstoqueRosh() < quantidadeRoshUsado) {
            throw new InsumoInsuficienteException(roshResultado.getMarcasRosh().toString());
        }

        roshResultado.setQuantidadeEstoqueRosh(roshResultado.getQuantidadeEstoqueRosh() - quantidadeRoshUsado);

        roshRepository.save(roshResultado);
    }

    @Override
    @Transactional
    public void deletaRoshPorId(Long idRosh) {
        RoshEntity roshEntity = roshRepository.findById(idRosh).orElseThrow(() ->
                new EntidadeNaoEncontrada());

        roshRepository.delete(roshEntity);
    }

    @Override
    @Transactional
    public void apagaRoshPorMarcasRosh(MarcasRosh marcasRosh) {
        roshRepository.deleteByMarcasRosh(marcasRosh);
    }

    @Override
    @Transactional
    public void apagaRoshPorMaterialRosh(MaterialRosh materialRosh) {
        roshRepository.deleteByMaterialRosh(materialRosh);
    }
}
