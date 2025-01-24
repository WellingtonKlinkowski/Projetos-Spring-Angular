package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.dtos.request.CarvaoRequest;
import com.wklinkowski.manager_lounge.dtos.response.CarvaoResponse;
import com.wklinkowski.manager_lounge.entities.CarvaoEntity;
import com.wklinkowski.manager_lounge.enums.MarcaCarvao;
import com.wklinkowski.manager_lounge.exceptions.EntidadeNaoEncontrada;
import com.wklinkowski.manager_lounge.exceptions.InsumoInsuficienteException;
import com.wklinkowski.manager_lounge.interfaces.CarvaoService;
import com.wklinkowski.manager_lounge.mappers.CarvaoMapper;
import com.wklinkowski.manager_lounge.repositories.CarvaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarvaoServiceImpl implements CarvaoService {

    private final CarvaoRepository carvaoRepository;
    private final CarvaoMapper carvaoMapper;

    public CarvaoServiceImpl(CarvaoRepository carvaoRepository, CarvaoMapper carvaoMapper) {
        this.carvaoRepository = carvaoRepository;
        this.carvaoMapper = carvaoMapper;
    }

    @Override
    @Transactional
    public CarvaoResponse criarCarvao(CarvaoRequest carvaoRequest) {
        CarvaoEntity carvaoEntity = carvaoMapper.fromRequestToEntity(carvaoRequest);

        carvaoEntity.calculaQuantidadeTotalDeCarvao();

        return carvaoMapper.fromEntityToResponse(carvaoRepository.save(carvaoEntity));
    }

    @Override
    @Transactional(readOnly = true)
    public CarvaoResponse procurarCarvaoPorId(Long id) {
        CarvaoEntity carvaoResultado = carvaoRepository.findById(id)
                .orElseThrow(EntidadeNaoEncontrada::new);

        return carvaoMapper.fromEntityToResponse(carvaoResultado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CarvaoResponse> listarCarvoes() {
        List<CarvaoEntity> listaCarvao = carvaoRepository.findAll();

        return listaCarvao.stream().map(carvaoMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CarvaoResponse> procuraCarvaoPorMarcaCarvao(MarcaCarvao marcaCarvao) {
        List<CarvaoEntity> listaCarvaoPorMarcaCarvao = carvaoRepository.findByMarcaCarvaoOrderByMarcaCarvaoDesc(marcaCarvao);

        return listaCarvaoPorMarcaCarvao.stream().map(carvaoMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CarvaoResponse> procuraCarvaoPorPesoCarvao(Integer pesoCarvao) {
        List<CarvaoEntity> listaCarvaoPorPeso = carvaoRepository.findByPesoCarvaoOrderByPesoCarvaoDesc(pesoCarvao);

        return listaCarvaoPorPeso.stream().map(carvaoMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CarvaoResponse> procuraCarvaoPorQuantidadeCarvao(Integer quantidadeCarvao) {
        List<CarvaoEntity> listaCarvaoPorQuantidadeCarvao =
                carvaoRepository.findByQuantidadeCarvaoOrderByQuantidadeCarvaoDesc(quantidadeCarvao);

        return listaCarvaoPorQuantidadeCarvao.stream().map(carvaoMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CarvaoResponse> procuraCarvaoPorMarcaEPeso(MarcaCarvao marcaCarvao, Integer pesoCarvao) {
        List<CarvaoEntity> listaCarvaoPorMarcaEPesoCarvao = carvaoRepository.procuraCarvaoPorMarcaEPeso(marcaCarvao, pesoCarvao);

        return listaCarvaoPorMarcaEPesoCarvao.stream().map(carvaoMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CarvaoResponse> procuraMarcaCarvaoUsandoLike(String marcaCarvao) {
        List<CarvaoEntity> listaCarvaoPorMarca = carvaoRepository.procuraMarcaCarvaoComMetodoLike(marcaCarvao);

        return listaCarvaoPorMarca.stream().map(carvaoMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CarvaoResponse> procuraCarvaoComPesoEntreDoisValores(Integer pesoMinimo, Integer pesoMaximo) {
        List<CarvaoEntity> listaCarvaoComPesoEntreDoisValores = carvaoRepository.findByPesoCarvaoBetween(pesoMinimo, pesoMaximo);

        return listaCarvaoComPesoEntreDoisValores.stream().map(carvaoMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CarvaoResponse> procuraCarvaoPorQuantidadeEmEstoque(Integer quantidadeEstoqueCarvao) {
        List<CarvaoEntity> listaCarvaoPorQuantidadeEstoque =
                carvaoRepository.findByQuantidadeEstoqueCaixaCarvaoOrderByQuantidadeEstoqueCaixaCarvaoDesc(quantidadeEstoqueCarvao);

        return listaCarvaoPorQuantidadeEstoque.stream().map(carvaoMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CarvaoResponse atualizarCarvaoPorId(Long idCarvao, CarvaoRequest carvaoRequest) {
        CarvaoEntity carvaoEntity = carvaoRepository.findById(idCarvao).orElseThrow(() ->
                new EntidadeNaoEncontrada());

        carvaoEntity.setMarcaCarvao(carvaoRequest.getMarcaCarvao());
        carvaoEntity.setPesoCarvao(carvaoRequest.getPesoCarvao());
        carvaoEntity.setQuantidadeCarvao(carvaoRequest.getQuantidadeCarvao());
        carvaoEntity.setQuantidadeEstoqueCaixaCarvao(carvaoRequest.getQuantidadeEstoqueCaixaCarvao());
        carvaoEntity.calculaQuantidadeTotalDeCarvao();

        return carvaoMapper.fromEntityToResponse(carvaoRepository.save(carvaoEntity));
    }

    @Override
    @Transactional
    public void consomeCarvaoDoEstoqueQuandoAlugado(Long idCarvao, Integer quantidadeCarvaoUsado) throws InsumoInsuficienteException {
        CarvaoEntity carvaoResultado = carvaoRepository.findById(idCarvao)
                .orElseThrow(EntidadeNaoEncontrada::new);

        if(carvaoResultado.getQuantidadeTotalCarvao() < quantidadeCarvaoUsado) {
            throw new InsumoInsuficienteException(carvaoResultado.getMarcaCarvao().toString());
        }

        carvaoResultado.setQuantidadeTotalCarvao(carvaoResultado.getQuantidadeTotalCarvao() - quantidadeCarvaoUsado);
        atualizarEstoqueDeCaixasCarvao(carvaoResultado);

        carvaoRepository.save(carvaoResultado);
    }

    @Override
    @Transactional
    public void retornaConsumoAluguelParaEstoque(Long idCarvao, Integer quantidadeCarvaoUsadoAluguel) {
        CarvaoEntity carvaoResultado = carvaoRepository.findById(idCarvao)
                .orElseThrow(EntidadeNaoEncontrada::new);

        carvaoResultado.setQuantidadeTotalCarvao(carvaoResultado.getQuantidadeTotalCarvao() + quantidadeCarvaoUsadoAluguel);
        atualizarEstoqueDeCaixasCarvao(carvaoResultado);

        carvaoRepository.save(carvaoResultado);
    }

    @Override
    @Transactional
    public void atualizarEstoqueDeCaixasCarvao(CarvaoEntity carvaoEntity) {
        int totalCaixasFechadas = carvaoEntity.getQuantidadeTotalCarvao() / carvaoEntity.getQuantidadeCarvao();

        carvaoEntity.setQuantidadeEstoqueCaixaCarvao(totalCaixasFechadas);
    }

    @Override
    @Transactional
    public void deletaCarvaoPorId(Long idCarvao) {
        CarvaoEntity carvaoEntity = carvaoRepository.findById(idCarvao).orElseThrow( () ->
                new EntidadeNaoEncontrada());

        carvaoRepository.delete(carvaoEntity);
    }

    @Override
    @Transactional
    public void deletarCarvaoPorMarcaCarvao(MarcaCarvao marcaCarvao) {
        carvaoRepository.deleteByMarcaCarvao(marcaCarvao);
    }
}
