package com.wklinkowski.manager_lounge.controller;

import com.wklinkowski.manager_lounge.dtos.FumoDTO;
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
    public ResponseEntity<FumoDTO> criarFumo(@Valid @RequestBody FumoDTO fumoDTO) {
        FumoDTO fumoResultado = fumoServiceImpl.criarFumo(fumoDTO);

        return new ResponseEntity<>(fumoResultado, HttpStatus.CREATED);
    }

    @GetMapping("/{idFumo}")
    public ResponseEntity<FumoDTO> procuraFumoPorId(@PathVariable Long idFumo) {
        FumoDTO fumoResultado = fumoServiceImpl.procurarFumoPorId(idFumo);

        if(fumoResultado == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(fumoResultado, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FumoDTO>> listarFumos() {
        List<FumoDTO> listaFumoResultado = fumoServiceImpl.listarFumos();

        if(listaFumoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("marcas-fumo")
    public ResponseEntity<List<FumoDTO>> procuraFumoPorMarcasFumo(@RequestParam MarcasFumo marcasFumo) {
        List<FumoDTO> listaFumoResultado = fumoServiceImpl.procuraFumoPorMarcasFumo(marcasFumo);

        if(listaFumoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("sabor-fumo")
    public ResponseEntity<List<FumoDTO>> procuraFumoPorSaborFumo(@RequestParam String saborFumo) {
        List<FumoDTO> listaFumoResultado = fumoServiceImpl.procuraFumoPorSaborFumo(saborFumo);

        if(listaFumoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("peso-fumo")
    public ResponseEntity<List<FumoDTO>> procuraFumoPorPesoFumo(@RequestParam Integer pesoFumo) {
        List<FumoDTO> listaFumoResultado = fumoServiceImpl.procuraFumoPorPesoFumo(pesoFumo);

        if(listaFumoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("sugestao-marca-fumo")
    public ResponseEntity<List<FumoDTO>> procuraFumoPorMarcaFumoUsandoLike(@RequestParam String marcaFumo) {
        List<FumoDTO> listaFumoResultado = fumoServiceImpl.procuraFumoPorMarcasFumoUsandoLike(marcaFumo);

        if(listaFumoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("sugestao-sabor-fumo")
    public ResponseEntity<List<FumoDTO>> procuraFumoPorSaborFumoUsandoLike(@RequestParam String saborFumo) {
        List<FumoDTO> listaFumoResultado = fumoServiceImpl.procuraFumoPorSaborFumoUsandoLike(saborFumo);

        if(listaFumoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("entre-peso-fumo")
    public ResponseEntity<List<FumoDTO>> procuraFumoEntrePesos(@RequestParam Integer pesoMinimoFumo, @RequestParam Integer pesoMaximoFumo) {
        List<FumoDTO> listaFumoResultado = fumoServiceImpl.procuraFumoEntrePesos(pesoMinimoFumo, pesoMaximoFumo);

        if(listaFumoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("/quantidade-estoque")
    public ResponseEntity<List<FumoDTO>> procuraFumoPorQuantidadeEstoque(@RequestParam Integer quantidadeFumoEstoque) {
        List<FumoDTO> listaFumoResultado = fumoServiceImpl.procuraFumoPorQuantidadeEmEstoque(quantidadeFumoEstoque);

        if(listaFumoResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @PutMapping("/{idFumo}")
    public ResponseEntity<FumoDTO> atualizaFumoPorId(@PathVariable Long idFumo, @Valid @RequestBody FumoDTO fumoDTO) {
        FumoDTO fumoResultado = fumoServiceImpl.atualizaFumoPorId(idFumo, fumoDTO);

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
