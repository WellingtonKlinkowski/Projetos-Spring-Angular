package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.dtos.FumoDTO;
import com.wklinkowski.manager_lounge.entities.FumoEntity;
import com.wklinkowski.manager_lounge.enums.MarcasFumo;
import com.wklinkowski.manager_lounge.exceptions.EntidadeNaoEncontrada;
import com.wklinkowski.manager_lounge.repositories.FumoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FumoService {

    private final FumoRepository fumoRepository;

    @Autowired
    public FumoService(FumoRepository fumoRepository) {
        this.fumoRepository = fumoRepository;
    }

    @Transactional
    public FumoDTO criarFumo(FumoDTO fumoDTO) {
        FumoEntity fumoEntity = fumoRepository.save(new FumoEntity(fumoDTO));

        return new FumoDTO(fumoEntity);
    }

    @Transactional
    public FumoDTO procurarFumoPorId(Long idFumo) {
        Optional<FumoEntity> optionalFumo = fumoRepository.findById(idFumo);

        return optionalFumo.map(FumoDTO::new).orElse(null);
    }

    @Transactional
    public List<FumoDTO> listarFumos() {
        List<FumoEntity> listaFumoEntity = fumoRepository.findAll();

        return listaFumoEntity.stream().map(fumo -> new FumoDTO(fumo)).collect(Collectors.toList());
    }

    @Transactional
    public List<FumoDTO> procuraFumoPorMarcasFumo(MarcasFumo marcasFumo) {
        List<FumoEntity> listaFumoPorMarcasFumo =
                fumoRepository.findByMarcasFumoOrderByMarcasFumoDesc(marcasFumo);

        return listaFumoPorMarcasFumo.stream().map( fumo ->
                new FumoDTO(fumo)).collect(Collectors.toList());
    }

    @Transactional
    public List<FumoDTO> procuraFumoPorSaborFumo(String saborFumo) {
        List<FumoEntity> listaFumoPorSaborFumo =
                fumoRepository.findBySaborFumoOrderBySaborFumoDesc(saborFumo);

        return listaFumoPorSaborFumo.stream().map( fumo ->
                new FumoDTO(fumo)).collect(Collectors.toList());
    }

    @Transactional
    public List<FumoDTO> procuraFumoPorPesoFumo(Integer pesoFumo) {
        List<FumoEntity> listaFumoPorPesoFumo =
                fumoRepository.findByPesoFumoOrderByPesoFumoDesc(pesoFumo);

        return listaFumoPorPesoFumo.stream().map( fumo ->
                new FumoDTO(fumo)).collect(Collectors.toList());
    }

    @Transactional
    public List<FumoDTO> procuraFumoPorMarcasFumoUsandoLike(String marcasFumo) {
        List<FumoEntity> listaFumoPorMarcasFumo =
                fumoRepository.procuraMarcasFumoComMetodoLike(marcasFumo);

        return listaFumoPorMarcasFumo.stream().map( fumo ->
                new FumoDTO(fumo)).collect(Collectors.toList());
    }

    @Transactional
    public List<FumoDTO> procuraFumoPorSaborFumoUsandoLike(String saborFumo) {
        List<FumoEntity> listaFumoPorSaborFumo =
                fumoRepository.procuraSaborFumoComMetodoLike(saborFumo);

        return listaFumoPorSaborFumo.stream().map( fumo ->
                new FumoDTO(fumo)).collect(Collectors.toList());
    }

    @Transactional
    public List<FumoDTO> procuraFumoEntrePesos(Integer pesoMinimoFumo, Integer pesoMaximoFumo) {
        List<FumoEntity> listaFumoPorPesoFumo =
                fumoRepository.findByPesoFumoBetween(pesoMinimoFumo, pesoMaximoFumo);

        return listaFumoPorPesoFumo.stream().map( fumo ->
                new FumoDTO(fumo)).collect(Collectors.toList());
    }

    @Transactional
    public List<FumoDTO> procuraFumoPorQuantidadeEmEstoque(Integer quantidadeEstoqueFumo) {
        List<FumoEntity> listaFumoPorQuantidadeEstoque =
                fumoRepository.findByQuantidadeEstoqueFumoOrderByQuantidadeEstoqueFumoDesc(quantidadeEstoqueFumo);

        return listaFumoPorQuantidadeEstoque.stream().map( fumo ->
                new FumoDTO(fumo)).collect(Collectors.toList());
    }

    @Transactional
    public FumoDTO atualizaFumoPorId(Long idFumo, FumoDTO fumoDTO) {
        FumoEntity fumoEntity = fumoRepository.findById(idFumo).orElseThrow(() ->
                new EntidadeNaoEncontrada());

        fumoEntity.setMarcasFumo(fumoDTO.getMarcasFumo());
        fumoEntity.setPesoFumo(fumoDTO.getPesoFumo());
        fumoEntity.setSaborFumo(fumoDTO.getSaborFumo());
        fumoEntity.setQuantidadeEstoqueFumo(fumoDTO.getQuantidadeEstoqueFumo());

        return new FumoDTO(fumoRepository.save(fumoEntity));
    }

    @Transactional
    public void deletaFumoPorId(Long idFumo) {
        FumoEntity fumoEntity = fumoRepository.findById(idFumo).orElseThrow(() ->
                new EntidadeNaoEncontrada());

        fumoRepository.delete(fumoEntity);
    }

    @Transactional
    public void apagaFumoPorMarcasFumo(MarcasFumo marcasFumo) {

        fumoRepository.deleteByMarcasFumo(marcasFumo);
    }
}
