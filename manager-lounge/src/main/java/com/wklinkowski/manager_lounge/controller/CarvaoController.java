package com.wklinkowski.manager_lounge.controller;

import com.wklinkowski.manager_lounge.dtos.request.CarvaoRequest;
import com.wklinkowski.manager_lounge.dtos.response.CarvaoResponse;
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
    public ResponseEntity<CarvaoResponse> criarCarvao(@Valid @RequestBody CarvaoRequest carvaoRequest) {
        CarvaoResponse carvaoResultado = carvaoServiceImpl.criarCarvao(carvaoRequest);

        return new ResponseEntity<>(carvaoResultado, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CarvaoResponse>> listarCarvoes() {
        List<CarvaoResponse> listaCarvaoResultado = carvaoServiceImpl.listarCarvoes();

        if(listaCarvaoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/{idCarvao}")
    public ResponseEntity<CarvaoResponse> procurarCarvaoPorId(@PathVariable Long idCarvao) {
        CarvaoResponse carvaoResultado = carvaoServiceImpl.procurarCarvaoPorId(idCarvao);

        if(carvaoResultado == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(carvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/marca-carvao")
    public ResponseEntity<List<CarvaoResponse>> procuraCarvaoPorMarca(@RequestParam MarcaCarvao marcaCarvao) {
        List<CarvaoResponse> listaCarvaoResultado = carvaoServiceImpl.procuraCarvaoPorMarcaCarvao(marcaCarvao);

        if(listaCarvaoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/peso-carvao")
    public ResponseEntity<List<CarvaoResponse>> procuraCarvaoPorPeso(@RequestParam Integer pesoCarvao) {
        List<CarvaoResponse> listaCarvaoResultado = carvaoServiceImpl.procuraCarvaoPorPesoCarvao(pesoCarvao);

        if(listaCarvaoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/quantidade-carvao")
    public ResponseEntity<List<CarvaoResponse>> procuraCarvaoPorQuantidade(@RequestParam Integer quantidadeCarvao) {
        List<CarvaoResponse> listaCarvaoResultado = carvaoServiceImpl.procuraCarvaoPorQuantidadeCarvao(quantidadeCarvao);

        if(listaCarvaoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/marca-peso-carvao")
    public ResponseEntity<List<CarvaoResponse>> procuraCarvaoPorMarcaEPeso(@RequestParam MarcaCarvao marcaCarvao, @RequestParam Integer pesoCarvao) {
        List<CarvaoResponse> listaCarvaoResultado = carvaoServiceImpl.procuraCarvaoPorMarcaEPeso(marcaCarvao, pesoCarvao);

        if(listaCarvaoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/sugestao-marca-carvao")
    public ResponseEntity<List<CarvaoResponse>> procuraMarcaCarvaoUsandoLike(@RequestParam String marcaCarvao) {
        List<CarvaoResponse> listaCarvaoResultado = carvaoServiceImpl.procuraMarcaCarvaoUsandoLike(marcaCarvao);

        if(listaCarvaoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/entre-peso-carvao")
    public ResponseEntity<List<CarvaoResponse>> procuraCarvaoComPesoEntreDoisValores(@RequestParam Integer pesoMinimo, @RequestParam Integer pesoMaximo) {
        List<CarvaoResponse> listaCarvaoResultado = carvaoServiceImpl.procuraCarvaoComPesoEntreDoisValores(pesoMinimo, pesoMaximo);

        if(listaCarvaoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/quantidade-estoque")
    public ResponseEntity<List<CarvaoResponse>> procuraCarvaoPorQuantidadeEstoque(@RequestParam Integer quantidadeEstoqueCarvao) {
        List<CarvaoResponse> listaCarvaoResultado = carvaoServiceImpl.procuraCarvaoPorQuantidadeEmEstoque(quantidadeEstoqueCarvao);

        if(listaCarvaoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @PutMapping("/{idCarvao}")
    public ResponseEntity<CarvaoResponse> atualizaCarvaoPorId(@PathVariable Long idCarvao, @Valid @RequestBody CarvaoRequest carvaoRequest) {
        CarvaoResponse carvaoResultado = carvaoServiceImpl.atualizarCarvaoPorId(idCarvao, carvaoRequest);

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
