package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.dtos.request.RoshRequest;
import com.wklinkowski.manager_lounge.dtos.response.RoshResponse;
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
    public RoshResponse criarRosh(RoshRequest roshRequest) {
        RoshEntity roshEntity = roshRepository.save(roshMapper.fromRequestToEntity(roshRequest));

        return roshMapper.fromEntityToResponse(roshEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public RoshResponse procuraRoshPorId(Long idRosh) {
        RoshEntity roshResultado = roshRepository.findById(idRosh)
                .orElseThrow(EntidadeNaoEncontrada::new);

        return roshMapper.fromEntityToResponse(roshResultado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoshResponse> listarRosh() {
        List<RoshEntity> listaRoshEntity = roshRepository.findAll();

        return listaRoshEntity.stream().map(roshMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoshResponse> procuraRoshPorMarcasRosh(MarcasRosh marcasRosh) {
        List<RoshEntity> listaRoshPorMarca = roshRepository.findByMarcasRoshOrderByMarcasRoshDesc(marcasRosh);

        return listaRoshPorMarca.stream().map(roshMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoshResponse> procuraRoshPorMaterialRosh(MaterialRosh materialRosh) {
        List<RoshEntity> listaRoshPorMaterial = roshRepository.findByMaterialRoshOrderByMaterialRoshDesc(materialRosh);

        return listaRoshPorMaterial.stream().map(roshMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoshResponse> procuraMarcasRoshComMetodoLike(String marcaRosh) {
        List<RoshEntity> listaRoshPorMarca = roshRepository.procuraMarcasRoshComMetodoLike(marcaRosh);

        return listaRoshPorMarca.stream().map(roshMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoshResponse> procuraMaterialRoshComMetodoLike(String materialRosh) {
        List<RoshEntity> listaRoshPorMaterial = roshRepository.procuraMaterialRoshComMetodoLike(materialRosh);

        return listaRoshPorMaterial.stream().map(roshMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoshResponse> procuraRoshPorQuantidadeEstoqueRosh(int quantidadeEstoqueRosh) {
        List<RoshEntity> listaRoshPorQuantidadeEstoque =
                roshRepository.findByQuantidadeEstoqueRoshOrderByQuantidadeEstoqueRoshDesc(quantidadeEstoqueRosh);

        return listaRoshPorQuantidadeEstoque.stream().map(roshMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public RoshResponse atualizaRoshPorId(Long idRosh, RoshRequest roshRequest) {
        RoshEntity roshEntity = roshRepository.findById(idRosh).orElseThrow(() ->
                new EntidadeNaoEncontrada());

        roshEntity.setMaterialRosh(roshRequest.getMaterialRosh());
        roshEntity.setMarcasRosh(roshRequest.getMarcasRosh());
        roshEntity.setQuantidadeEstoqueRosh(roshRequest.getQuantidadeEstoqueRosh());

        return roshMapper.fromEntityToResponse(roshRepository.save(roshEntity));
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
    public void retornaConsumoAluguelParaEstoque(Long idRosh, Integer quantidadeRoshUsadoAluguel) {
        RoshEntity roshResultado = roshRepository.findById(idRosh)
                .orElseThrow(EntidadeNaoEncontrada::new);

        roshResultado.setQuantidadeEstoqueRosh(roshResultado.getQuantidadeEstoqueRosh() + quantidadeRoshUsadoAluguel);

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
