package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.dtos.NarguileDTO;
import com.wklinkowski.manager_lounge.entities.NarguileEntity;
import com.wklinkowski.manager_lounge.exceptions.EntidadeNaoEncontrada;
import com.wklinkowski.manager_lounge.repositories.NarguileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NarguileService {

    private NarguileRepository narguileRepository;

    @Autowired
    public NarguileService (NarguileRepository narguileRepository){
        this.narguileRepository = narguileRepository;
    }

    @Transactional
    public NarguileDTO criarNarguile(NarguileDTO narguileDTO){
        NarguileEntity narguileEntity = narguileRepository.save(new NarguileEntity(narguileDTO));

        return new NarguileDTO(narguileEntity);
    }

    @Transactional
    public List<NarguileDTO> listarNarguiles (){
        List<NarguileEntity> listaNarguileEntity = narguileRepository.findAll();

        return listaNarguileEntity.stream().map(narguile -> new NarguileDTO(narguile)).collect(Collectors.toList());
    }

    @Transactional
    public NarguileDTO procuraNarguilePorId (Long idNarguile){
        Optional<NarguileEntity> opationalNarguile = narguileRepository.findById(idNarguile);

        return opationalNarguile.map(NarguileDTO::new).orElse(null);
    }

    @Transactional
    public NarguileDTO atualizaNarguilePorId (Long idNarguile, NarguileDTO narguileDTO){
        NarguileEntity narguileEntity = narguileRepository.findById(idNarguile).orElseThrow(() ->
                new EntidadeNaoEncontrada());

        narguileEntity.setMarcasNarguile(narguileDTO.getMarcasNarguile());
        narguileEntity.setMaterialNarguile(narguileDTO.getMaterialNarguile());
        narguileEntity.setNomeNarguile(narguileDTO.getNomeNarguile());
        narguileEntity.setQuantidadeMangueirasNarguile(narguileDTO.getQuantidadeMangueirasNarguile());

        return new NarguileDTO(narguileRepository.save(narguileEntity));
    }

    @Transactional
    public void deletaNarguilePorId (Long idNarguile) {
        NarguileEntity narguileEntity = narguileRepository.findById(idNarguile).orElseThrow( () ->
                new EntidadeNaoEncontrada());

        narguileRepository.delete(narguileEntity);
    }

}
