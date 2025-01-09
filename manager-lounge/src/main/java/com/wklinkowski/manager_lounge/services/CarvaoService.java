package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.dtos.CarvaoDTO;
import com.wklinkowski.manager_lounge.entities.CarvaoEntity;
import com.wklinkowski.manager_lounge.enums.MarcaCarvao;
import com.wklinkowski.manager_lounge.enums.MarcasRosh;
import com.wklinkowski.manager_lounge.exceptions.EntidadeNaoEncontrada;
import com.wklinkowski.manager_lounge.repositories.CarvaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarvaoService {

    private final CarvaoRepository carvaoRepository;

    @Autowired
    public CarvaoService(CarvaoRepository carvaoRepository){
        this.carvaoRepository = carvaoRepository;
    }

    @Transactional
    public CarvaoDTO criarCarvao (CarvaoDTO carvaoDTO){
        CarvaoEntity carvaoEntity = carvaoRepository.save(new CarvaoEntity(carvaoDTO));

        return new CarvaoDTO(carvaoEntity);
    }

    @Transactional
    public List<CarvaoDTO> listarCarvoes (){
        List<CarvaoEntity> listaCarvaoEntity = carvaoRepository.findAll();

        return listaCarvaoEntity.stream().map(carvao ->
                new CarvaoDTO(carvao)).collect(Collectors.toList());
    }

    @Transactional
    public CarvaoDTO procurarCarvaoPorId (Long id){
        Optional<CarvaoEntity> optionalCarvao = carvaoRepository.findById(id);

        return optionalCarvao.map(CarvaoDTO::new).orElse(null);
    }

    @Transactional
    public CarvaoDTO atualizarCarvaoPorId (Long idCarvao, CarvaoDTO carvao){

        CarvaoEntity carvaoEntity = carvaoRepository.findById(idCarvao).orElseThrow(() ->
                new EntidadeNaoEncontrada());

        carvaoEntity.setMarcaCarvao(carvao.getMarcaCarvao());
        carvaoEntity.setPesoCarvao(carvao.getPesoCarvao());
        carvaoEntity.setQuantidadeCarvao(carvao.getQuantidadeCarvao());
        carvaoEntity.setQuantidadeEstoqueCarvao(carvao.getQuantidadeEstoqueCarvao());

        return new CarvaoDTO(carvaoRepository.save(carvaoEntity));
    }

    @Transactional
    public void deletaCarvaoPorId (Long idCarvao) {
        CarvaoEntity carvaoEntity = carvaoRepository.findById(idCarvao).orElseThrow( () ->
                new EntidadeNaoEncontrada());

        carvaoRepository.delete(carvaoEntity);
    }

    @Transactional
    public List<CarvaoDTO> procuraCarvaoPorMarcaCarvao (MarcaCarvao marcaCarvao){

        List<CarvaoEntity> listaCarvaoPorMarcaCarvao = carvaoRepository.findByMarcaCarvaoOrderByMarcaCarvaoDesc(marcaCarvao);

        return listaCarvaoPorMarcaCarvao.stream().map(carvao ->
                new CarvaoDTO(carvao)).collect(Collectors.toList());
    }

    @Transactional
    public List<CarvaoDTO> procuraCarvaoPorPesoCarvao (Integer pesoCarvao){
        List<CarvaoEntity> listaCarvaoPorPeso = carvaoRepository.findByPesoCarvaoOrderByPesoCarvaoDesc(pesoCarvao);

        return listaCarvaoPorPeso.stream().map(carvao ->
                new CarvaoDTO(carvao)).collect(Collectors.toList());
    }

    @Transactional
    public List<CarvaoDTO> procuraCarvaoPorQuantidadeCarvao (Integer quantidadeCarvao){
        List<CarvaoEntity> listaCarvaoPorQuantidadeCarvao =
                carvaoRepository.findByQuantidadeCarvaoOrderByQuantidadeCarvaoDesc(quantidadeCarvao);

        return listaCarvaoPorQuantidadeCarvao.stream().map(carvao ->
                new CarvaoDTO(carvao)).collect(Collectors.toList());
    }

    @Transactional
    public List<CarvaoDTO> procuraCarvaoPorMarcaEPeso (MarcaCarvao marcaCarvao, Integer pesoCarvao){
        List<CarvaoEntity> listaCarvaoPorMarcaEPesoCarvao = carvaoRepository.procuraCarvaoPorMarcaEPeso(marcaCarvao, pesoCarvao);

        return listaCarvaoPorMarcaEPesoCarvao.stream().map(carvao ->
                new CarvaoDTO(carvao)).collect(Collectors.toList());
    }

    @Transactional
    public List<CarvaoDTO> procuraMarcaCarvaoUsandoLike (String marcaCarvao){
        List<CarvaoEntity> listaCarvaoPorMarca = carvaoRepository.procuraMarcaCarvaoComMetodoLike(marcaCarvao);

        return listaCarvaoPorMarca.stream().map(carvao ->
                new CarvaoDTO(carvao)).collect(Collectors.toList());
    }

    @Transactional
    public List<CarvaoDTO> procuraCarvaoComPesoEntreDoisValores (Integer pesoMinimo, Integer pesoMaximo){
        List<CarvaoEntity> listaCarvaoComPesoEntreDoisValores = carvaoRepository.findByPesoCarvaoBetween(pesoMinimo, pesoMaximo);

        return listaCarvaoComPesoEntreDoisValores.stream().map(carvao ->
                new CarvaoDTO(carvao)).collect(Collectors.toList());
    }

    @Transactional
    public List<CarvaoDTO> procuraCarvaoPorQuantidadeEmEstoque (Integer quantidadeEstoqueCarvao){
        List<CarvaoEntity> listaCarvaoPorQuantidadeEstoque =
                carvaoRepository.findByQuantidadeEstoqueCarvaoOrderByQuantidadeEstoqueCarvaoDesc(quantidadeEstoqueCarvao);

        return listaCarvaoPorQuantidadeEstoque.stream().map(carvao ->
                new CarvaoDTO(carvao)).collect(Collectors.toList());
    }

    @Transactional
    public void deletarCarvaoPorMarcaCarvao (MarcaCarvao marcaCarvao){
        carvaoRepository.deleteByMarcaCarvao(marcaCarvao);
    }
}
