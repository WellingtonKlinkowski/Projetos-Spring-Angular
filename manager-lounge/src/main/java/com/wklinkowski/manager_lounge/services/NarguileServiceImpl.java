package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.dtos.NarguileDTO;
import com.wklinkowski.manager_lounge.entities.FumoEntity;
import com.wklinkowski.manager_lounge.entities.NarguileEntity;
import com.wklinkowski.manager_lounge.enums.MarcasNarguile;
import com.wklinkowski.manager_lounge.enums.MaterialNarguile;
import com.wklinkowski.manager_lounge.exceptions.EntidadeNaoEncontrada;
import com.wklinkowski.manager_lounge.exceptions.InsumoInsuficienteException;
import com.wklinkowski.manager_lounge.interfaces.NarguileService;
import com.wklinkowski.manager_lounge.mappers.NarguileMapper;
import com.wklinkowski.manager_lounge.repositories.NarguileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NarguileServiceImpl implements NarguileService {

    private final NarguileRepository narguileRepository;
    private final NarguileMapper narguileMapper;

    public NarguileServiceImpl(NarguileRepository narguileRepository, NarguileMapper narguileMapper) {
        this.narguileRepository = narguileRepository;
        this.narguileMapper = narguileMapper;
    }

    @Override
    @Transactional
    public NarguileDTO criarNarguile(NarguileDTO narguileDTO) {
        NarguileEntity narguileEntity = narguileRepository.save(narguileMapper.toEntity(narguileDTO));

        return narguileMapper.toDto(narguileEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public NarguileDTO procuraNarguilePorId(Long idNarguile) {
        NarguileEntity narguileResultado = narguileRepository.findById(idNarguile)
                .orElseThrow(EntidadeNaoEncontrada::new);

        return narguileMapper.toDto(narguileResultado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileDTO> listarNarguiles() {
        List<NarguileEntity> listaNarguileEntity = narguileRepository.findAll();

        return listaNarguileEntity.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileDTO> procuraNarguilePorNomeNarguile(String nomeNarguile) {
        List<NarguileEntity> listaNarguilePorNome =
                narguileRepository.findByNomeNarguileOrderByNomeNarguileDesc(nomeNarguile);

        return listaNarguilePorNome.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileDTO> procuraNarguilePorMarcaNarguile(MarcasNarguile marcaNarguile) {
        List<NarguileEntity> listaNarguilePorMarca =
                narguileRepository.findByMarcasNarguileOrderByMarcasNarguileDesc(marcaNarguile);

        return listaNarguilePorMarca.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileDTO> procuraNarguilePorQuantidadeMangueirasNarguile(Integer quantidadeMangueirasNarguile) {
        List<NarguileEntity> listaNarguilePorQuantidadeMangueiras =
                narguileRepository.findByQuantidadeMangueirasNarguileOrderByQuantidadeMangueirasNarguileDesc(quantidadeMangueirasNarguile);

        return listaNarguilePorQuantidadeMangueiras.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileDTO> procuraNarguilePorMaterialNarguile(MaterialNarguile materialNarguile) {
        List<NarguileEntity> listaNarguilePorMaterial =
                narguileRepository.findByMaterialNarguileOrderByMaterialNarguileDesc(materialNarguile);

        return listaNarguilePorMaterial.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileDTO> procuraNarguilePorNomeNarguileComMetodoLike(String nomeNarguile) {
        List<NarguileEntity> listaNarguilePorMaterial =
                narguileRepository.procuraNomeNarguileComMetodoLike(nomeNarguile);

        return listaNarguilePorMaterial.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileDTO> procuraNarguilePorMarcasNarguileComMetodoLike(String marcaNarguile) {
        List<NarguileEntity> listaNarguilePorMarca =
                narguileRepository.procuraMarcasNarguileComMetodoLike(marcaNarguile);

        return listaNarguilePorMarca.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileDTO> procuraNarguilePorMaterialNarguileComMetodoLike(String materialNarguile) {
        List<NarguileEntity> listaNarguilePorMaterial =
                narguileRepository.procuraMaterialNarguileComMetodoLike(materialNarguile);

        return listaNarguilePorMaterial.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileDTO> procuraNarguileEntreQuantidadeMangueirasNarguile(Integer quantidadeMangueirasMinimo, Integer quantidadeMangueirasMaximo) {
        List<NarguileEntity> listaNarguilePorQuantidadeMangueiras =
                narguileRepository.findByQuantidadeMangueirasNarguileBetween(quantidadeMangueirasMinimo, quantidadeMangueirasMaximo);

        return listaNarguilePorQuantidadeMangueiras.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NarguileDTO> procuraNarguilePorQuantidadeEstoqueNarguile(Integer quantidadeEstoqueNarguile) {
        List<NarguileEntity> listaNarguilePorQuantidadeEstoque =
                narguileRepository.findByQuantidadeEstoqueNarguileOrderByQuantidadeEstoqueNarguileDesc(quantidadeEstoqueNarguile);

        return listaNarguilePorQuantidadeEstoque.stream().map(narguileMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public NarguileDTO atualizaNarguilePorId(Long idNarguile, NarguileDTO narguileDTO) {
        NarguileEntity narguileEntity = narguileRepository.findById(idNarguile).orElseThrow(() ->
                new EntidadeNaoEncontrada());

        narguileEntity.setMarcasNarguile(narguileDTO.getMarcasNarguile());
        narguileEntity.setMaterialNarguile(narguileDTO.getMaterialNarguile());
        narguileEntity.setNomeNarguile(narguileDTO.getNomeNarguile());
        narguileEntity.setQuantidadeMangueirasNarguile(narguileDTO.getQuantidadeMangueirasNarguile());
        narguileEntity.setQuantidadeEstoqueNarguile(narguileDTO.getQuantidadeEstoqueNarguile());

        return narguileMapper.toDto(narguileRepository.save(narguileEntity));
    }

    @Override
    @Transactional
    public void consomeNarguileDoEstoqueQuandoAlugado(Long idNarguile, Integer quantidadeNarguileUsada) {
        NarguileEntity narguileResultado = narguileRepository.findById(idNarguile)
                .orElseThrow(EntidadeNaoEncontrada::new);

        if(narguileResultado.getQuantidadeEstoqueNarguile() < quantidadeNarguileUsada){
            throw new InsumoInsuficienteException(narguileResultado.getNomeNarguile());
        }

        narguileResultado.setQuantidadeEstoqueNarguile(
                narguileResultado.getQuantidadeEstoqueNarguile() - quantidadeNarguileUsada);

        narguileRepository.save(narguileResultado);
    }

    @Override
    @Transactional
    public void retornaConsumoAluguelParaEstoque(Long idNarguile, Integer quantidadeNarguileUsadoAluguel) {
        NarguileEntity narguileResultado = narguileRepository.findById(idNarguile)
                .orElseThrow(EntidadeNaoEncontrada::new);

        narguileResultado.setQuantidadeEstoqueNarguile(narguileResultado.getQuantidadeEstoqueNarguile() + quantidadeNarguileUsadoAluguel);

        narguileRepository.save(narguileResultado);
    }

    @Override
    @Transactional
    public void apagaNarguilePorMarcasNarguile(MarcasNarguile marcasNarguile) {
        narguileRepository.deleteByMarcasNarguile(marcasNarguile);
    }

    @Override
    @Transactional
    public void apagaNarguilePorId(Long idNarguile) {
        NarguileEntity narguileEntity = narguileRepository.findById(idNarguile).orElseThrow( () ->
                new EntidadeNaoEncontrada());

        narguileRepository.delete(narguileEntity);
    }

    @Override
    @Transactional
    public void apagaNarguilePorMaterialNarguile(MaterialNarguile materialNarguile) {
        narguileRepository.deleteByMaterialNarguile(materialNarguile);
    }

    @Override
    @Transactional
    public void apagaNarguilePorQuantidadeMangueirasNarguile(Integer quantidadeMangueirasNarguile) {
        narguileRepository.deleteByQuantidadeMangueirasNarguile(quantidadeMangueirasNarguile);
    }
}
