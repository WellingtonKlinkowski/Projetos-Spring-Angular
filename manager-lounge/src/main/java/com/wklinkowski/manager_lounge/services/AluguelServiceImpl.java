package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.dtos.AluguelDTO;
import com.wklinkowski.manager_lounge.entities.AluguelEntity;
import com.wklinkowski.manager_lounge.exceptions.EntidadeNaoEncontrada;
import com.wklinkowski.manager_lounge.interfaces.AluguelService;
import com.wklinkowski.manager_lounge.mappers.AluguelMapper;
import com.wklinkowski.manager_lounge.repositories.AluguelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AluguelServiceImpl implements AluguelService {

    private final AluguelRepository aluguelRepository;
    private final AluguelMapper aluguelMapper;
    private final CarvaoServiceImpl carvaoServiceImpl;
    private final RoshServiceImpl roshServiceImpl;
    private final FumoServiceImpl fumoServiceImpl;
    private final NarguileServiceImpl narguileServiceImpl;

    public AluguelServiceImpl(AluguelRepository aluguelRepository, AluguelMapper aluguelMapper, CarvaoServiceImpl carvaoServiceImpl, RoshServiceImpl roshServiceImpl,
                              FumoServiceImpl fumoServiceImpl, NarguileServiceImpl narguileServiceImpl) {

        this.aluguelRepository = aluguelRepository;
        this.aluguelMapper = aluguelMapper;
        this.carvaoServiceImpl = carvaoServiceImpl;
        this.roshServiceImpl = roshServiceImpl;
        this.fumoServiceImpl = fumoServiceImpl;
        this.narguileServiceImpl = narguileServiceImpl;
    }

    @Override
    @Transactional
    public AluguelDTO criarAluguel(AluguelDTO aluguelDTO) {
        AluguelEntity aluguelSalvo = aluguelRepository.save(aluguelMapper.toEntity(aluguelDTO));

        consumirMateriaisUsadosNoAluguelAtualizado(aluguelSalvo);

        return aluguelMapper.toDto(aluguelSalvo);
    }

    @Override
    @Transactional(readOnly = true)
    public AluguelDTO procuraAluguelPorId(Long idAluguel) {
        AluguelEntity aluguelResultado = aluguelRepository.findById(idAluguel)
                .orElseThrow(EntidadeNaoEncontrada::new);

        return aluguelMapper.toDto(aluguelResultado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AluguelDTO> listarAlugueis() {
        List<AluguelEntity> listaAluguel = aluguelRepository.findAll();

        return listaAluguel.stream().map(aluguelMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public AluguelDTO procuraAluguelPorNumeroDaMesa(Integer numeroMesaAluguel) {
        AluguelEntity aluguelResultado = aluguelRepository.findByNumeroMesaAluguel(numeroMesaAluguel)
                .orElseThrow(EntidadeNaoEncontrada::new);

        return aluguelMapper.toDto(aluguelResultado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AluguelDTO> procuraAluguelPorFumo(Long idFumo) {
        List<AluguelEntity> listaAluguelResultado = aluguelRepository.findByFumoAluguel(idFumo);

        return listaAluguelResultado.stream().map(aluguelMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AluguelDTO> procuraAluguelPorCarvao(Long idCarvao) {
        List<AluguelEntity> listaAluguelResultado = aluguelRepository.findByCarvaoAluguel(idCarvao);

        return listaAluguelResultado.stream().map(aluguelMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AluguelDTO> procuraAluguelPorRosh(Long idRosh) {
        List<AluguelEntity> listaAluguelResultado = aluguelRepository.findByRoshAluguel(idRosh);

        return listaAluguelResultado.stream().map(aluguelMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AluguelDTO> procuraAluguelPorNarguile(Long idNarguile) {
        List<AluguelEntity> listaAluguelResultado = aluguelRepository.findByNarguileAluguel(idNarguile);

        return listaAluguelResultado.stream().map(aluguelMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AluguelDTO> procuraAluguelPorData(LocalDate dataAluguel) {
        List<AluguelEntity> listaAluguelResultado = aluguelRepository.findByDataAluguel(dataAluguel);

        return listaAluguelResultado.stream().map(aluguelMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AluguelDTO> procuraAluguelPorDataHora(LocalDateTime dataHoraAluguel) {
        List<AluguelEntity> listaAluguelResultado = aluguelRepository.findByHoraAluguel(dataHoraAluguel);

        return listaAluguelResultado.stream().map(aluguelMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AluguelDTO> procuraAluguelPorDuracao(Duration minimoDuracaoAluguel, Duration maximoDuracaoAluguel) {
        List<AluguelEntity> listaAluguelResultado =
                aluguelRepository.findByDuracaoAluguelBetween(minimoDuracaoAluguel, maximoDuracaoAluguel);

        return listaAluguelResultado.stream().map(aluguelMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AluguelDTO atualizaAluguelPorId(Long idAluguel, AluguelDTO aluguelDTO) {
        AluguelEntity aluguelResultado = aluguelRepository.findById(idAluguel)
                .orElseThrow(EntidadeNaoEncontrada::new);

        if (aluguelDTO.isAtivoAluguel()) {
            processarAtualizacaoAluguel(aluguelResultado, aluguelDTO);
        }

        return aluguelMapper.toDto(aluguelRepository.save(aluguelResultado));
    }

    private void processarAtualizacaoAluguel(AluguelEntity aluguelEntity, AluguelDTO aluguelDTO) {
        devolverMateriaisUsadosNoAluguelParaEstoque(aluguelEntity);
        atualizarDadosDoAluguel(aluguelEntity, aluguelDTO);
        consumirMateriaisUsadosNoAluguelAtualizado(aluguelEntity);
    }

    private void atualizarDadosDoAluguel(AluguelEntity aluguelEntity, AluguelDTO aluguelDTO) {
        aluguelEntity.setNumeroMesaAluguel(aluguelDTO.getNumeroMesaAluguel());
        aluguelEntity.setFumoAluguel(aluguelDTO.getFumoAluguel());
        aluguelEntity.setQuantidadeFumoUsado(aluguelDTO.getQuantidadeFumoUsado());
        aluguelEntity.setCarvaoAluguel(aluguelDTO.getCarvaoAluguel());
        aluguelEntity.setQuantidadeCarvaoUsado(aluguelDTO.getQuantidadeCarvaoUsado());
        aluguelEntity.setRoshAluguel(aluguelDTO.getRoshAluguel());
        aluguelEntity.setQuantidadeRoshUsado(aluguelDTO.getQuantidadeRoshUsado());
        aluguelEntity.setNarguileAluguel(aluguelDTO.getNarguileAluguel());
        aluguelEntity.setQuantidadeNarguileUsado(aluguelDTO.getQuantidadeNarguileUsado());
        aluguelEntity.setDataAluguel(LocalDate.now());
        aluguelEntity.setHoraAluguel(LocalDateTime.now());
        aluguelEntity.setDuracaoAluguel(aluguelDTO.getDuracaoAluguel());
        aluguelEntity.setAtivoAluguel(aluguelDTO.isAtivoAluguel());
    }

    private void consumirMateriaisUsadosNoAluguelAtualizado(AluguelEntity aluguelEntity) {
        processarMateriaisNoEstoque(aluguelEntity, true);
    }

    private void devolverMateriaisUsadosNoAluguelParaEstoque(AluguelEntity aluguelEntity) {
        processarMateriaisNoEstoque(aluguelEntity, false);
    }

    private void processarMateriaisNoEstoque(AluguelEntity aluguelEntity, boolean consumir) {
        if (consumir) {
            carvaoServiceImpl.consomeCarvaoDoEstoqueQuandoAlugado(
                    aluguelEntity.getCarvaoAluguel().getId(), aluguelEntity.getQuantidadeCarvaoUsado());
            fumoServiceImpl.consomeFumoDoEstoqueQuandoAlugado(
                    aluguelEntity.getFumoAluguel().getId(), aluguelEntity.getQuantidadeFumoUsado());
            roshServiceImpl.consomeRoshDoEstoqueQuandoAlugado(
                    aluguelEntity.getRoshAluguel().getId(), aluguelEntity.getQuantidadeRoshUsado());
            narguileServiceImpl.consomeNarguileDoEstoqueQuandoAlugado(
                    aluguelEntity.getNarguileAluguel().getId(), aluguelEntity.getQuantidadeNarguileUsado());
        } else {
            carvaoServiceImpl.retornaConsumoAluguelParaEstoque(
                    aluguelEntity.getCarvaoAluguel().getId(), aluguelEntity.getQuantidadeCarvaoUsado());
            fumoServiceImpl.retornaConsumoAluguelParaEstoque(
                    aluguelEntity.getFumoAluguel().getId(), aluguelEntity.getQuantidadeFumoUsado());
            roshServiceImpl.retornaConsumoAluguelParaEstoque(
                    aluguelEntity.getRoshAluguel().getId(), aluguelEntity.getQuantidadeRoshUsado());
            narguileServiceImpl.retornaConsumoAluguelParaEstoque(
                    aluguelEntity.getNarguileAluguel().getId(), aluguelEntity.getQuantidadeNarguileUsado());
        }
    }

    @Override
    @Transactional
    public void retornaAoEstoqueSuprimentosNaoConsumiveisAposEncerrarAluguel() {
        List<AluguelEntity> alugueisResultado = aluguelRepository.findAluguelIsAtivo();

        alugueisResultado.forEach(aluguelEntity -> {
            if(isAluguelExpirado(aluguelEntity)) {
                devolveRoshENarguileAoEstoque(aluguelEntity);
            }
        });
    }

    @Override
    public boolean isAluguelExpirado(AluguelEntity aluguelEntity) {
        LocalDateTime dataHoraCriacaoAluguel = aluguelEntity.getHoraAluguel();

        return dataHoraCriacaoAluguel.plus(aluguelEntity.getDuracaoAluguel()).isBefore(LocalDateTime.now());
    }

    private void devolveRoshENarguileAoEstoque(AluguelEntity aluguelEntity) {
        roshServiceImpl.retornaConsumoAluguelParaEstoque(
                aluguelEntity.getRoshAluguel().getId(), aluguelEntity.getQuantidadeRoshUsado());
        narguileServiceImpl.retornaConsumoAluguelParaEstoque(
                aluguelEntity.getNarguileAluguel().getId(), aluguelEntity.getQuantidadeNarguileUsado());

        aluguelEntity.setAtivoAluguel(false);

        aluguelRepository.save(aluguelEntity);
    }

    @Override
    @Transactional
    public void desativarAluguel(Long idAluguel) {
        AluguelEntity aluguelResultado = aluguelRepository.findById(idAluguel)
                .orElseThrow(EntidadeNaoEncontrada::new);

        devolveRoshENarguileAoEstoque(aluguelResultado);
    }

    @Override
    @Transactional
    public void deletarAluguelPorId(Long idAluguel) {
        AluguelEntity aluguelResultado = aluguelRepository.findById(idAluguel)
                        .orElseThrow(EntidadeNaoEncontrada::new);

        aluguelRepository.delete(aluguelResultado);
    }
}
