package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.dtos.CarvaoDTO;
import com.wklinkowski.manager_lounge.entities.CarvaoEntity;
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

    private CarvaoRepository carvaoRepository;

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

        return listaCarvaoEntity.stream().map(carvao -> new CarvaoDTO(carvao)).collect(Collectors.toList());
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

        return new CarvaoDTO(carvaoRepository.save(carvaoEntity));
    }

    @Transactional
    public void deletaCarvaoPorId (Long idCarvao) {
        CarvaoEntity carvaoEntity = carvaoRepository.findById(idCarvao).orElseThrow( () ->
                new EntidadeNaoEncontrada());

        carvaoRepository.delete(carvaoEntity);
    }

}
