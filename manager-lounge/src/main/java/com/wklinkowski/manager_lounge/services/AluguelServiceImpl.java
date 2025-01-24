package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.dtos.request.AluguelRequest;
import com.wklinkowski.manager_lounge.dtos.response.AluguelResponse;
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

/**
 * Classe service usada para a manipulação
 * dos alugueis, contendo toda a regra de
 * negócio necessária.
 *
 * @author WellingtonKlinkowski
 */
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

    /**
     * Recebe os dados do endpoint já validados
     * e cria uma instância da entidade Aluguel,
     * salvando no banco, consumindo os materiais
     * usados no aluguel e retornando os dados salvos.
     *
     * @param aluguelRequest os dados para criar o aluguel.
     * @return dados salvos do aluguel.
     *
     * @author WellingtonKlinkowski
     */
    @Override
    @Transactional
    public AluguelResponse criarAluguel(AluguelRequest aluguelRequest) {
        AluguelEntity aluguelSalvo = aluguelRepository.save(aluguelMapper.fromRequestToEntity(aluguelRequest));

        consumirMateriaisUsadosNoAluguelAtualizado(aluguelSalvo);

        return aluguelMapper.fromEntityToResponse(aluguelSalvo);
    }

    /**
     * Recebe o identificador do aluguel e faz
     * a busca no banco, caso não haja registro
     * lança exception informando sobre, caso
     * contrário retorna os dados.
     *
     * @param idAluguel o identificador do aluguel.
     * @return registro retornado do banco.
     *
     * @author WellingtonKlinkowski
     */
    @Override
    @Transactional(readOnly = true)
    public AluguelResponse procuraAluguelPorId(Long idAluguel) {
        AluguelEntity aluguelResultado = aluguelRepository.findById(idAluguel)
                .orElseThrow(EntidadeNaoEncontrada::new);

        return aluguelMapper.fromEntityToResponse(aluguelResultado);
    }

    /**
     * Faz a busca de todos os alugueis salvos no
     * banco, indiferente se for ativo ou inativo.
     *
     * @return todos os alugueis do banco.
     *
     * @author WellingtonKlinkowski
     */
    @Override
    @Transactional(readOnly = true)
    public List<AluguelResponse> listarAlugueis() {
        List<AluguelEntity> listaAluguel = aluguelRepository.findAll();

        return listaAluguel.stream().map(aluguelMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    /**
     * Procura o aluguel que está ativo pelo
     * número da mesa e retorna os dados se for
     * encontrado registro com o valor passado.
     *
     * @param numeroMesaAluguel número da mesa salvo no aluguel.
     * @return o aluguel que contém a mesa passada por parâmetro.
     *
     * @author WellingtonKlinkowski
     */
    @Override
    @Transactional(readOnly = true)
    public AluguelResponse procuraAluguelPorNumeroDaMesa(Integer numeroMesaAluguel) {
        AluguelEntity aluguelResultado = aluguelRepository.findByNumeroMesaAluguel(numeroMesaAluguel)
                .orElseThrow(EntidadeNaoEncontrada::new);

        return aluguelMapper.fromEntityToResponse(aluguelResultado);
    }

    /**
     * Procura os alugueis que usam o identificador
     * do fumo passado por parâmetro, independente
     * se estiver inativo ou ativo.
     *
     * @param idFumo identificador do fumo usado no aluguel.
     * @return os alugueis que usam o fumo passado por parâmetro.
     *
     * @author WellingtonKlinkowski
     */
    @Override
    @Transactional(readOnly = true)
    public List<AluguelResponse> procuraAluguelPorFumo(Long idFumo) {
        List<AluguelEntity> listaAluguelResultado = aluguelRepository.findByFumoAluguel(idFumo);

        return listaAluguelResultado.stream().map(aluguelMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    /**
     * Procura os alugueis que usam o identificador
     * do carvão passado por parâmetro, independente
     * se estiver inativo ou ativo.
     *
     * @param idCarvao identificador do carvão usado no aluguel.
     * @return os alugueis que usam o carvão passado por parâmetro.
     *
     * @author WellingtonKlinkowski
     */
    @Override
    @Transactional(readOnly = true)
    public List<AluguelResponse> procuraAluguelPorCarvao(Long idCarvao) {
        List<AluguelEntity> listaAluguelResultado = aluguelRepository.findByCarvaoAluguel(idCarvao);

        return listaAluguelResultado.stream().map(aluguelMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    /**
     * Procura os alugueis que usam o identificador
     * do rosh passado por parâmetro, independente
     * se estiver inativo ou ativo.
     *
     * @param idRosh identificador do rosh usado no aluguel.
     * @return os alugueis que usam o rosh passado por parâmetro.
     *
     * @author WellingtonKlinkowski
     */
    @Override
    @Transactional(readOnly = true)
    public List<AluguelResponse> procuraAluguelPorRosh(Long idRosh) {
        List<AluguelEntity> listaAluguelResultado = aluguelRepository.findByRoshAluguel(idRosh);

        return listaAluguelResultado.stream().map(aluguelMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    /**
     * Procura os alugueis que usam o identificador
     * da narguile passada por parâmetro, independente
     * se estiver inativo ou ativo.
     *
     * @param idNarguile identificador da narguile usada no aluguel.
     * @return os alugueis que usam a narguile passada por parâmetro.
     *
     * @author WellingtonKlinkowski
     */
    @Override
    @Transactional(readOnly = true)
    public List<AluguelResponse> procuraAluguelPorNarguile(Long idNarguile) {
        List<AluguelEntity> listaAluguelResultado = aluguelRepository.findByNarguileAluguel(idNarguile);

        return listaAluguelResultado.stream().map(aluguelMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    /**
     * Procura os alugueis que foram criados na data
     * passada por parâmetro, independente se estiver
     * inativo ou ativo.
     *
     * @param dataAluguel data que o aluguel foi criado.
     * @return os alugueis que foram criados nessa data.
     *
     * @author WellingtonKlinkowski
     */
    @Override
    @Transactional(readOnly = true)
    public List<AluguelResponse> procuraAluguelPorData(LocalDate dataAluguel) {
        List<AluguelEntity> listaAluguelResultado = aluguelRepository.findByDataAluguel(dataAluguel);

        return listaAluguelResultado.stream().map(aluguelMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AluguelResponse> procuraAluguelPorDataHora(LocalDateTime dataHoraAluguel) {
        List<AluguelEntity> listaAluguelResultado = aluguelRepository.findByHoraAluguel(dataHoraAluguel);

        return listaAluguelResultado.stream().map(aluguelMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AluguelResponse> procuraAluguelPorDuracao(Duration minimoDuracaoAluguel, Duration maximoDuracaoAluguel) {
        List<AluguelEntity> listaAluguelResultado =
                aluguelRepository.findByDuracaoAluguelBetween(minimoDuracaoAluguel, maximoDuracaoAluguel);

        return listaAluguelResultado.stream().map(aluguelMapper::fromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AluguelResponse atualizaAluguelPorId(Long idAluguel, AluguelRequest aluguelRequest) {
        AluguelEntity aluguelResultado = aluguelRepository.findById(idAluguel)
                .orElseThrow(EntidadeNaoEncontrada::new);

        if (aluguelRequest.isAtivoAluguel()) {
            processarAtualizacaoAluguel(aluguelResultado, aluguelRequest);
        }

        return aluguelMapper.fromEntityToResponse(aluguelRepository.save(aluguelResultado));
    }

    private void processarAtualizacaoAluguel(AluguelEntity aluguelEntity, AluguelRequest aluguelRequest) {
        devolverMateriaisUsadosNoAluguelParaEstoque(aluguelEntity);
        atualizarDadosDoAluguel(aluguelEntity, aluguelRequest);
        consumirMateriaisUsadosNoAluguelAtualizado(aluguelEntity);
    }

    private void atualizarDadosDoAluguel(AluguelEntity aluguelEntity, AluguelRequest aluguelRequest) {
        aluguelEntity.setNumeroMesaAluguel(aluguelRequest.getNumeroMesaAluguel());
        aluguelEntity.setFumoAluguel(aluguelRequest.getFumoAluguel());
        aluguelEntity.setQuantidadeFumoUsado(aluguelRequest.getQuantidadeFumoUsado());
        aluguelEntity.setCarvaoAluguel(aluguelRequest.getCarvaoAluguel());
        aluguelEntity.setQuantidadeCarvaoUsado(aluguelRequest.getQuantidadeCarvaoUsado());
        aluguelEntity.setRoshAluguel(aluguelRequest.getRoshAluguel());
        aluguelEntity.setQuantidadeRoshUsado(aluguelRequest.getQuantidadeRoshUsado());
        aluguelEntity.setNarguileAluguel(aluguelRequest.getNarguileAluguel());
        aluguelEntity.setQuantidadeNarguileUsado(aluguelRequest.getQuantidadeNarguileUsado());
        aluguelEntity.setDataAluguel(LocalDate.now());
        aluguelEntity.setHoraAluguel(LocalDateTime.now());
        aluguelEntity.setDuracaoAluguel(aluguelRequest.getDuracaoAluguel());
        aluguelEntity.setAtivoAluguel(aluguelRequest.isAtivoAluguel());
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
