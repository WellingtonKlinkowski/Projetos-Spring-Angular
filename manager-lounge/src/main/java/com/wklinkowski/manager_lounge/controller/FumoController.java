package com.wklinkowski.manager_lounge.controller;

import com.wklinkowski.manager_lounge.dtos.request.FumoRequest;
import com.wklinkowski.manager_lounge.dtos.response.FumoResponse;
import com.wklinkowski.manager_lounge.enums.MarcasFumo;
import com.wklinkowski.manager_lounge.services.FumoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fumos")
public class FumoController {

    private final FumoServiceImpl fumoServiceImpl;

    public FumoController(FumoServiceImpl fumoServiceImpl) {
        this.fumoServiceImpl = fumoServiceImpl;
    }

    @PostMapping("/criar")
    public ResponseEntity<FumoResponse> criarFumo(@Valid @RequestBody FumoRequest fumoRequest) {
        FumoResponse fumoResultado = fumoServiceImpl.criarFumo(fumoRequest);

        return new ResponseEntity<>(fumoResultado, HttpStatus.CREATED);
    }

    @GetMapping("/{idFumo}")
    public ResponseEntity<FumoResponse> procuraFumoPorId(@PathVariable Long idFumo) {
        FumoResponse fumoResultado = fumoServiceImpl.procurarFumoPorId(idFumo);

        if(fumoResultado == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(fumoResultado, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FumoResponse>> listarFumos() {
        List<FumoResponse> listaFumoResultado = fumoServiceImpl.listarFumos();

        if(listaFumoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("marcas-fumo")
    public ResponseEntity<List<FumoResponse>> procuraFumoPorMarcasFumo(@RequestParam MarcasFumo marcasFumo) {
        List<FumoResponse> listaFumoResultado = fumoServiceImpl.procuraFumoPorMarcasFumo(marcasFumo);

        if(listaFumoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("sabor-fumo")
    public ResponseEntity<List<FumoResponse>> procuraFumoPorSaborFumo(@RequestParam String saborFumo) {
        List<FumoResponse> listaFumoResultado = fumoServiceImpl.procuraFumoPorSaborFumo(saborFumo);

        if(listaFumoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("peso-fumo")
    public ResponseEntity<List<FumoResponse>> procuraFumoPorPesoFumo(@RequestParam Integer pesoFumo) {
        List<FumoResponse> listaFumoResultado = fumoServiceImpl.procuraFumoPorPesoFumo(pesoFumo);

        if(listaFumoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("sugestao-marca-fumo")
    public ResponseEntity<List<FumoResponse>> procuraFumoPorMarcaFumoUsandoLike(@RequestParam String marcaFumo) {
        List<FumoResponse> listaFumoResultado = fumoServiceImpl.procuraFumoPorMarcasFumoUsandoLike(marcaFumo);

        if(listaFumoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("sugestao-sabor-fumo")
    public ResponseEntity<List<FumoResponse>> procuraFumoPorSaborFumoUsandoLike(@RequestParam String saborFumo) {
        List<FumoResponse> listaFumoResultado = fumoServiceImpl.procuraFumoPorSaborFumoUsandoLike(saborFumo);

        if(listaFumoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("entre-peso-fumo")
    public ResponseEntity<List<FumoResponse>> procuraFumoEntrePesos(@RequestParam Integer pesoMinimoFumo, @RequestParam Integer pesoMaximoFumo) {
        List<FumoResponse> listaFumoResultado = fumoServiceImpl.procuraFumoEntrePesos(pesoMinimoFumo, pesoMaximoFumo);

        if(listaFumoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("/quantidade-estoque")
    public ResponseEntity<List<FumoResponse>> procuraFumoPorQuantidadeEstoque(@RequestParam Integer quantidadeFumoEstoque) {
        List<FumoResponse> listaFumoResultado = fumoServiceImpl.procuraFumoPorQuantidadeEmEstoque(quantidadeFumoEstoque);

        if(listaFumoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @PutMapping("/{idFumo}")
    public ResponseEntity<FumoResponse> atualizaFumoPorId(@PathVariable Long idFumo, @Valid @RequestBody FumoRequest fumoRequest) {
        FumoResponse fumoResultado = fumoServiceImpl.atualizaFumoPorId(idFumo, fumoRequest);

        return new ResponseEntity<>(fumoResultado, HttpStatus.OK);
    }

    @DeleteMapping("/{idFumo}")
    public ResponseEntity<Void> deletaFumoPorId(@PathVariable Long idFumo) {
        fumoServiceImpl.deletaFumoPorId(idFumo);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/apaga-marca-fumo")
    public ResponseEntity<Void> deletaFumoPorMarcaFumo(@RequestParam MarcasFumo marcaFumo) {
        fumoServiceImpl.apagaFumoPorMarcasFumo(marcaFumo);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
