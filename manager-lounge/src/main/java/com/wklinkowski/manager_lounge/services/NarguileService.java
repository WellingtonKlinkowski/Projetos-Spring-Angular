package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.dtos.NarguileDTO;
import com.wklinkowski.manager_lounge.entities.NarguileEntity;
import com.wklinkowski.manager_lounge.enums.MarcasNarguile;
import com.wklinkowski.manager_lounge.enums.MaterialNarguile;
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

    private final NarguileRepository narguileRepository;

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

    @Transactional
    public List<NarguileDTO> procuraNarguilePorNomeNarguile (String nomeNarguile) {
        List<NarguileEntity> listaNarguilePorNome =
                narguileRepository.findByNomeNarguileOrderByNomeNarguileDesc(nomeNarguile);

        return listaNarguilePorNome.stream().map(narguile ->
                new NarguileDTO(narguile)).collect(Collectors.toList());
    }

    @Transactional
    public List<NarguileDTO> procuraNarguilePorMarcaNarguile (MarcasNarguile marcaNarguile) {
        List<NarguileEntity> listaNarguilePorMarca =
                narguileRepository.findByMarcasNarguileOrderByMarcasNarguileDesc(marcaNarguile);

        return listaNarguilePorMarca.stream().map(narguile ->
                new NarguileDTO(narguile)).collect(Collectors.toList());
    }

    @Transactional
    public List<NarguileDTO> procuraNarguilePorQuantidadeMangueirasNarguile (Integer quantidadeMangueirasNarguile) {
        List<NarguileEntity> listaNarguilePorQuantidadeMangueiras =
                narguileRepository.findByQuantidadeMangueirasNarguileOrderByQuantidadeMangueirasNarguileDesc(quantidadeMangueirasNarguile);

        return listaNarguilePorQuantidadeMangueiras.stream().map(narguile ->
                new NarguileDTO(narguile)).collect(Collectors.toList());
    }

    @Transactional
    public List<NarguileDTO> procuraNarguilePorMaterialNarguile (MaterialNarguile materialNarguile) {
        List<NarguileEntity> listaNarguilePorMaterial =
                narguileRepository.findByMaterialNarguileOrderByMaterialNarguileDesc(materialNarguile);

        return listaNarguilePorMaterial.stream().map(narguile ->
                new NarguileDTO(narguile)).collect(Collectors.toList());
    }

    @Transactional
    public List<NarguileDTO> procuraNarguilePorNomeNarguileComMetodoLike (String nomeNarguile) {
        List<NarguileEntity> listaNarguilePorMaterial =
                narguileRepository.procuraNomeNarguileComMetodoLike(nomeNarguile);

        return listaNarguilePorMaterial.stream().map(narguile ->
                new NarguileDTO(narguile)).collect(Collectors.toList());
    }

    @Transactional
    public List<NarguileDTO> procuraNarguilePorMarcasNarguileComMetodoLike (String marcaNarguile) {
        List<NarguileEntity> listaNarguilePorMarca =
                narguileRepository.procuraMarcasNarguileComMetodoLike(marcaNarguile);

        return listaNarguilePorMarca.stream().map(narguile ->
                new NarguileDTO(narguile)).collect(Collectors.toList());
    }

    @Transactional
    public List<NarguileDTO> procuraNarguilePorMaterialNarguileComMetodoLike (String materialNarguile) {
        List<NarguileEntity> listaNarguilePorMaterial =
                narguileRepository.procuraMaterialNarguileComMetodoLike(materialNarguile);

        return listaNarguilePorMaterial.stream().map(narguile ->
                new NarguileDTO(narguile)).collect(Collectors.toList());
    }

    @Transactional
    public List<NarguileDTO> procuraNarguileEntreQuantidadeMangueirasNarguile (Integer quantidadeMangueirasMinimo, Integer quantidadeMangueirasMaximo) {
        List<NarguileEntity> listaNarguilePorQuantidadeMangueiras =
                narguileRepository.findByQuantidadeMangueirasNarguileBetwenn(quantidadeMangueirasMinimo, quantidadeMangueirasMaximo);

        return listaNarguilePorQuantidadeMangueiras.stream().map(narguile ->
                new NarguileDTO(narguile)).collect(Collectors.toList());
    }

    @Transactional
    public void apagaNarguilePorMarcasNarguile (MarcasNarguile marcasNarguile) {
        narguileRepository.deleteByMarcasNarguile(marcasNarguile);
    }

    @Transactional
    public void apagaNarguilePorMaterialNarguile (MaterialNarguile materialNarguile) {
        narguileRepository.deleteByMaterialNarguile(materialNarguile);
    }

    @Transactional
    public void apagaNarguilePorQuantidadeMangueirasNarguile (Integer quantidadeMangueirasNarguile) {
        narguileRepository.deleteByQuantidadeMangueirasNarguile(quantidadeMangueirasNarguile);
    }
}
