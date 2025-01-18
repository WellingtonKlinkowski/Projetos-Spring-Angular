package com.wklinkowski.manager_lounge.controller;

import com.wklinkowski.manager_lounge.dtos.CarvaoDTO;
import com.wklinkowski.manager_lounge.enums.MarcaCarvao;
import com.wklinkowski.manager_lounge.services.CarvaoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carvoes")
public class CarvaoController {

    private final CarvaoServiceImpl carvaoServiceImpl;

    public CarvaoController(CarvaoServiceImpl carvaoServiceImpl) {
        this.carvaoServiceImpl = carvaoServiceImpl;
    }

    @PostMapping("/criar")
    public ResponseEntity<CarvaoDTO> criarCarvao(@Valid @RequestBody CarvaoDTO carvaoDTO) {
        CarvaoDTO carvaoResultado = carvaoServiceImpl.criarCarvao(carvaoDTO);

        return new ResponseEntity<>(carvaoResultado, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CarvaoDTO>> listarCarvoes() {
        List<CarvaoDTO> listaCarvaoResultado = carvaoServiceImpl.listarCarvoes();

        if(listaCarvaoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/{idCarvao}")
    public ResponseEntity<CarvaoDTO> procurarCarvaoPorId(@PathVariable Long idCarvao) {
        CarvaoDTO carvaoResultado = carvaoServiceImpl.procurarCarvaoPorId(idCarvao);

        if(carvaoResultado == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(carvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/marca-carvao")
    public ResponseEntity<List<CarvaoDTO>> procuraCarvaoPorMarca(@RequestParam MarcaCarvao marcaCarvao) {
        List<CarvaoDTO> listaCarvaoResultado = carvaoServiceImpl.procuraCarvaoPorMarcaCarvao(marcaCarvao);

        if(listaCarvaoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/peso-carvao")
    public ResponseEntity<List<CarvaoDTO>> procuraCarvaoPorPeso(@RequestParam Integer pesoCarvao) {
        List<CarvaoDTO> listaCarvaoResultado = carvaoServiceImpl.procuraCarvaoPorPesoCarvao(pesoCarvao);

        if(listaCarvaoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/quantidade-carvao")
    public ResponseEntity<List<CarvaoDTO>> procuraCarvaoPorQuantidade(@RequestParam Integer quantidadeCarvao) {
        List<CarvaoDTO> listaCarvaoResultado = carvaoServiceImpl.procuraCarvaoPorQuantidadeCarvao(quantidadeCarvao);

        if(listaCarvaoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/marca-peso-carvao")
    public ResponseEntity<List<CarvaoDTO>> procuraCarvaoPorMarcaEPeso(@RequestParam MarcaCarvao marcaCarvao, @RequestParam Integer pesoCarvao) {
        List<CarvaoDTO> listaCarvaoResultado = carvaoServiceImpl.procuraCarvaoPorMarcaEPeso(marcaCarvao, pesoCarvao);

        if(listaCarvaoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/sugestao-marca-carvao")
    public ResponseEntity<List<CarvaoDTO>> procuraMarcaCarvaoUsandoLike(@RequestParam String marcaCarvao) {
        List<CarvaoDTO> listaCarvaoResultado = carvaoServiceImpl.procuraMarcaCarvaoUsandoLike(marcaCarvao);

        if(listaCarvaoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/entre-peso-carvao")
    public ResponseEntity<List<CarvaoDTO>> procuraCarvaoComPesoEntreDoisValores(@RequestParam Integer pesoMinimo, @RequestParam Integer pesoMaximo) {
        List<CarvaoDTO> listaCarvaoResultado = carvaoServiceImpl.procuraCarvaoComPesoEntreDoisValores(pesoMinimo, pesoMaximo);

        if(listaCarvaoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/quantidade-estoque")
    public ResponseEntity<List<CarvaoDTO>> procuraCarvaoPorQuantidadeEstoque(@RequestParam Integer quantidadeEstoqueCarvao) {
        List<CarvaoDTO> listaCarvaoResultado = carvaoServiceImpl.procuraCarvaoPorQuantidadeEmEstoque(quantidadeEstoqueCarvao);

        if(listaCarvaoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @PutMapping("/{idCarvao}")
    public ResponseEntity<CarvaoDTO> atualizaCarvaoPorId(@PathVariable Long idCarvao, @Valid @RequestBody CarvaoDTO carvaoDTO) {
        CarvaoDTO carvaoResultado = carvaoServiceImpl.atualizarCarvaoPorId(idCarvao, carvaoDTO);

        return new ResponseEntity<>(carvaoResultado, HttpStatus.OK);
    }

    @DeleteMapping("/{idCarvao}")
    public ResponseEntity<Void> deletaCarvaoPorId(@PathVariable Long idCarvao) {
        carvaoServiceImpl.deletaCarvaoPorId(idCarvao);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/apagar-marca-carvao")
    public ResponseEntity<Void> deletarCarvaoPorMarca(@RequestParam MarcaCarvao marcaCarvao) {
        carvaoServiceImpl.deletarCarvaoPorMarcaCarvao(marcaCarvao);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
