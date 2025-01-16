package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.dtos.CarvaoDTO;
import com.wklinkowski.manager_lounge.entities.CarvaoEntity;
import com.wklinkowski.manager_lounge.enums.MarcaCarvao;
import com.wklinkowski.manager_lounge.exceptions.EntidadeNaoEncontrada;
import com.wklinkowski.manager_lounge.mappers.CarvaoMapper;
import com.wklinkowski.manager_lounge.repositories.CarvaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarvaoService {

    private final CarvaoRepository carvaoRepository;
    private final CarvaoMapper carvaoMapper;

    public CarvaoService(CarvaoRepository carvaoRepository, CarvaoMapper carvaoMapper) {
        this.carvaoRepository = carvaoRepository;
        this.carvaoMapper = carvaoMapper;
    }

    @Transactional
    public CarvaoDTO criarCarvao(CarvaoDTO carvaoDTO) {
        CarvaoEntity carvaoEntity = carvaoRepository.save(carvaoMapper.toEntity(carvaoDTO));

        return carvaoMapper.toDto(carvaoEntity);
    }

    @Transactional
    public CarvaoDTO procurarCarvaoPorId(Long id) {
        Optional<CarvaoEntity> optionalCarvao = carvaoRepository.findById(id);

        return optionalCarvao.map(carvaoMapper::toDto).orElse(null);
    }

    @Transactional
    public List<CarvaoDTO> listarCarvoes() {
        List<CarvaoEntity> listaCarvao = carvaoRepository.findAll();

        return listaCarvao.stream().map(carvaoMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<CarvaoDTO> procuraCarvaoPorMarcaCarvao(MarcaCarvao marcaCarvao) {

        List<CarvaoEntity> listaCarvaoPorMarcaCarvao = carvaoRepository.findByMarcaCarvaoOrderByMarcaCarvaoDesc(marcaCarvao);

        return listaCarvaoPorMarcaCarvao.stream().map(carvaoMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<CarvaoDTO> procuraCarvaoPorPesoCarvao(Integer pesoCarvao) {
        List<CarvaoEntity> listaCarvaoPorPeso = carvaoRepository.findByPesoCarvaoOrderByPesoCarvaoDesc(pesoCarvao);

        return listaCarvaoPorPeso.stream().map(carvaoMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<CarvaoDTO> procuraCarvaoPorQuantidadeCarvao(Integer quantidadeCarvao) {
        List<CarvaoEntity> listaCarvaoPorQuantidadeCarvao =
                carvaoRepository.findByQuantidadeCarvaoOrderByQuantidadeCarvaoDesc(quantidadeCarvao);

        return listaCarvaoPorQuantidadeCarvao.stream().map(carvaoMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<CarvaoDTO> procuraCarvaoPorMarcaEPeso(MarcaCarvao marcaCarvao, Integer pesoCarvao) {
        List<CarvaoEntity> listaCarvaoPorMarcaEPesoCarvao = carvaoRepository.procuraCarvaoPorMarcaEPeso(marcaCarvao, pesoCarvao);

        return listaCarvaoPorMarcaEPesoCarvao.stream().map(carvaoMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<CarvaoDTO> procuraMarcaCarvaoUsandoLike(String marcaCarvao) {
        List<CarvaoEntity> listaCarvaoPorMarca = carvaoRepository.procuraMarcaCarvaoComMetodoLike(marcaCarvao);

        return listaCarvaoPorMarca.stream().map(carvaoMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<CarvaoDTO> procuraCarvaoComPesoEntreDoisValores(Integer pesoMinimo, Integer pesoMaximo) {
        List<CarvaoEntity> listaCarvaoComPesoEntreDoisValores = carvaoRepository.findByPesoCarvaoBetween(pesoMinimo, pesoMaximo);

        return listaCarvaoComPesoEntreDoisValores.stream().map(carvaoMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<CarvaoDTO> procuraCarvaoPorQuantidadeEmEstoque(Integer quantidadeEstoqueCarvao) {
        List<CarvaoEntity> listaCarvaoPorQuantidadeEstoque =
                carvaoRepository.findByQuantidadeEstoqueCarvaoOrderByQuantidadeEstoqueCarvaoDesc(quantidadeEstoqueCarvao);

        return listaCarvaoPorQuantidadeEstoque.stream().map(carvaoMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public CarvaoDTO atualizarCarvaoPorId(Long idCarvao, CarvaoDTO carvao) {

        CarvaoEntity carvaoEntity = carvaoRepository.findById(idCarvao).orElseThrow(() ->
                new EntidadeNaoEncontrada());

        carvaoEntity.setMarcaCarvao(carvao.getMarcaCarvao());
        carvaoEntity.setPesoCarvao(carvao.getPesoCarvao());
        carvaoEntity.setQuantidadeCarvao(carvao.getQuantidadeCarvao());
        carvaoEntity.setQuantidadeEstoqueCarvao(carvao.getQuantidadeEstoqueCarvao());

        return carvaoMapper.toDto(carvaoRepository.save(carvaoEntity));
    }

    @Transactional
    public void deletaCarvaoPorId(Long idCarvao) {
        CarvaoEntity carvaoEntity = carvaoRepository.findById(idCarvao).orElseThrow( () ->
                new EntidadeNaoEncontrada());

        carvaoRepository.delete(carvaoEntity);
    }

    @Transactional
    public void deletarCarvaoPorMarcaCarvao(MarcaCarvao marcaCarvao) {
        carvaoRepository.deleteByMarcaCarvao(marcaCarvao);
    }
}
