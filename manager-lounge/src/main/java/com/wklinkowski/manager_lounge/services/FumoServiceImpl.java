package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.dtos.request.FumoRequest;
import com.wklinkowski.manager_lounge.dtos.response.FumoResponse;
import com.wklinkowski.manager_lounge.entities.FumoEntity;
import com.wklinkowski.manager_lounge.enums.MarcasFumo;
import com.wklinkowski.manager_lounge.exceptions.EntidadeNaoEncontrada;
import com.wklinkowski.manager_lounge.exceptions.InsumoInsuficienteException;
import com.wklinkowski.manager_lounge.interfaces.FumoService;
import com.wklinkowski.manager_lounge.mappers.FumoMapper;
import com.wklinkowski.manager_lounge.repositories.FumoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FumoServiceImpl implements FumoService {

    private final FumoRepository fumoRepository;
    private final FumoMapper fumoMapper;

    public FumoServiceImpl(FumoRepository fumoRepository, FumoMapper fumoMapper) {
        this.fumoRepository = fumoRepository;
        this.fumoMapper = fumoMapper;
    }

    @Override
    @Transactional
    public FumoResponse criarFumo(FumoRequest fumoRequest) {
        FumoEntity fumoEntity = fumoRepository.save(fumoMapper.fromRequestToEntity(fumoRequest));

        return fumoMapper.fromEntityToResponse(fumoEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public FumoResponse procurarFumoPorId(Long idFumo) {
        FumoEntity fumoResultado = fumoRepository.findById(idFumo)
                .orElseThrow(EntidadeNaoEncontrada::new);

        return fumoMapper.fromEntityToResponse(fumoResultado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FumoResponse> listarFumos() {
        List<FumoEntity> listaFumoEntity = fumoRepository.findAll();

        return listaFumoEntity.stream().map(fumoMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FumoResponse> procuraFumoPorMarcasFumo(MarcasFumo marcasFumo) {
        List<FumoEntity> listaFumoPorMarcasFumo =
                fumoRepository.findByMarcasFumoOrderByMarcasFumoDesc(marcasFumo);

        return listaFumoPorMarcasFumo.stream().map(fumoMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FumoResponse> procuraFumoPorSaborFumo(String saborFumo) {
        List<FumoEntity> listaFumoPorSaborFumo =
                fumoRepository.findBySaborFumoOrderBySaborFumoDesc(saborFumo);

        return listaFumoPorSaborFumo.stream().map(fumoMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FumoResponse> procuraFumoPorPesoFumo(Integer pesoFumo) {
        List<FumoEntity> listaFumoPorPesoFumo =
                fumoRepository.findByPesoFumoOrderByPesoFumoDesc(pesoFumo);

        return listaFumoPorPesoFumo.stream().map(fumoMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FumoResponse> procuraFumoPorMarcasFumoUsandoLike(String marcasFumo) {
        List<FumoEntity> listaFumoPorMarcasFumo =
                fumoRepository.procuraMarcasFumoComMetodoLike(marcasFumo);

        return listaFumoPorMarcasFumo.stream().map(fumoMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FumoResponse> procuraFumoPorSaborFumoUsandoLike(String saborFumo) {
        List<FumoEntity> listaFumoPorSaborFumo =
                fumoRepository.procuraSaborFumoComMetodoLike(saborFumo);

        return listaFumoPorSaborFumo.stream().map(fumoMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FumoResponse> procuraFumoEntrePesos(Integer pesoMinimoFumo, Integer pesoMaximoFumo) {
        List<FumoEntity> listaFumoPorPesoFumo =
                fumoRepository.findByPesoFumoBetween(pesoMinimoFumo, pesoMaximoFumo);

        return listaFumoPorPesoFumo.stream().map(fumoMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FumoResponse> procuraFumoPorQuantidadeEmEstoque(Integer quantidadeEstoqueFumo) {
        List<FumoEntity> listaFumoPorQuantidadeEstoque =
                fumoRepository.findByQuantidadeEstoqueFumoOrderByQuantidadeEstoqueFumoDesc(quantidadeEstoqueFumo);

        return listaFumoPorQuantidadeEstoque.stream().map(fumoMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public FumoResponse atualizaFumoPorId(Long idFumo, FumoRequest fumoRequest) {
        FumoEntity fumoEntity = fumoRepository.findById(idFumo).orElseThrow(() ->
                new EntidadeNaoEncontrada());

        fumoEntity.setMarcasFumo(fumoRequest.getMarcasFumo());
        fumoEntity.setPesoFumo(fumoRequest.getPesoFumo());
        fumoEntity.setSaborFumo(fumoRequest.getSaborFumo());
        fumoEntity.setQuantidadeEstoqueFumo(fumoRequest.getQuantidadeEstoqueFumo());
        fumoEntity.calculaQuantidadeTotalDeFumo();

        return fumoMapper.fromEntityToResponse(fumoRepository.save(fumoEntity));
    }

    @Override
    @Transactional
    public void consomeFumoDoEstoqueQuandoAlugado(Long idFumo, Integer quantidadeFumoUsado) {
        FumoEntity fumoResultado = fumoRepository.findById(idFumo)
                .orElseThrow(EntidadeNaoEncontrada::new);

        if(fumoResultado.getQuantidadeTotalFumo() < quantidadeFumoUsado){
            throw new InsumoInsuficienteException(fumoResultado.getMarcasFumo().toString());
        }

        fumoResultado.setQuantidadeTotalFumo(fumoResultado.getQuantidadeTotalFumo() - quantidadeFumoUsado);
        atualizarEstoqueDeCaixasFumo(fumoResultado);

        fumoRepository.save(fumoResultado);
    }

    @Override
    @Transactional
    public void retornaConsumoAluguelParaEstoque(Long idFumo, Integer quantidadeFumoUsadoAluguel) {
        FumoEntity fumoResultado = fumoRepository.findById(idFumo)
                .orElseThrow(EntidadeNaoEncontrada::new);

        fumoResultado.setQuantidadeTotalFumo(fumoResultado.getQuantidadeTotalFumo() + quantidadeFumoUsadoAluguel);
        atualizarEstoqueDeCaixasFumo(fumoResultado);

        fumoRepository.save(fumoResultado);
    }

    @Override
    @Transactional
    public void atualizarEstoqueDeCaixasFumo(FumoEntity fumoEntity) {
        int totalCaixasFechadas = fumoEntity.getQuantidadeTotalFumo() / fumoEntity.getPesoFumo();

        fumoEntity.setQuantidadeEstoqueFumo(totalCaixasFechadas);
    }

    @Override
    @Transactional
    public void deletaFumoPorId(Long idFumo) {
        FumoEntity fumoEntity = fumoRepository.findById(idFumo).orElseThrow(() ->
                new EntidadeNaoEncontrada());

        fumoRepository.delete(fumoEntity);
    }

    @Override
    @Transactional
    public void apagaFumoPorMarcasFumo(MarcasFumo marcasFumo) {

        fumoRepository.deleteByMarcasFumo(marcasFumo);
    }
}
