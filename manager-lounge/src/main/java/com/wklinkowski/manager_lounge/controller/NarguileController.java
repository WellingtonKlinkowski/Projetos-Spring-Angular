package com.wklinkowski.manager_lounge.controller;

import com.wklinkowski.manager_lounge.dtos.request.NarguileRequest;
import com.wklinkowski.manager_lounge.dtos.response.NarguileResponse;
import com.wklinkowski.manager_lounge.enums.MarcasNarguile;
import com.wklinkowski.manager_lounge.enums.MaterialNarguile;
import com.wklinkowski.manager_lounge.services.NarguileServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/narguiles")
public class NarguileController {

    private final NarguileServiceImpl narguileServiceImpl;

    public NarguileController(NarguileServiceImpl narguileServiceImpl) {
        this.narguileServiceImpl = narguileServiceImpl;
    }

    @PostMapping("/criar")
    public ResponseEntity<NarguileResponse> criarNarguile(@Valid @RequestBody NarguileRequest narguileRequest) {
        NarguileResponse narguileResultado = narguileServiceImpl.criarNarguile(narguileRequest);

        return new ResponseEntity<>(narguileResultado, HttpStatus.CREATED);
    }

    @GetMapping("/{idNarguile}")
    public ResponseEntity<NarguileResponse> procuraNarguilePorId(@PathVariable Long idNarguile) {
        NarguileResponse narguileResultado = narguileServiceImpl.procuraNarguilePorId(idNarguile);

        if( narguileResultado == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(narguileResultado, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NarguileResponse>> listarNarguiles() {
        List<NarguileResponse> listaNarguileResultado = narguileServiceImpl.listarNarguiles();

        if( listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("nome-narguile")
    public ResponseEntity<List<NarguileResponse>> procuraNarguilePorNomeNarguile(@RequestParam String nomeNarguile) {
        List<NarguileResponse> listaNarguileResultado = narguileServiceImpl.procuraNarguilePorNomeNarguile(nomeNarguile);

        if(listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("marca-narguile")
    public ResponseEntity<List<NarguileResponse>> procuraNarguilePorMarcaNarguile(@RequestParam MarcasNarguile marcaNarguile) {
        List<NarguileResponse> listaNarguileResultado = narguileServiceImpl.procuraNarguilePorMarcaNarguile(marcaNarguile);

        if(listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("quantidade-mangueiras-narguile")
    public ResponseEntity<List<NarguileResponse>> procuraNarguilePorQuantidadeMangueirasNarguile(@RequestParam Integer quantidadeMangueirasNarguile) {
        List<NarguileResponse> listaNarguileResultado = narguileServiceImpl.procuraNarguilePorQuantidadeMangueirasNarguile(quantidadeMangueirasNarguile);

        if(listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("material-narguile")
    public ResponseEntity<List<NarguileResponse>> procuraNarguilePorMaterialNarguile(@RequestParam MaterialNarguile materialNarguile) {
        List<NarguileResponse> listaNarguileResultado = narguileServiceImpl.procuraNarguilePorMaterialNarguile(materialNarguile);

        if(listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("sugestao-nome-narguile")
    public ResponseEntity<List<NarguileResponse>> procuraNarguilePorNomeNarguileComMetodoLike(@RequestParam String nomeNarguile) {
        List<NarguileResponse> listaNarguileResultado = narguileServiceImpl.procuraNarguilePorNomeNarguileComMetodoLike(nomeNarguile);

        if(listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("sugestao-marcas-narguile")
    public ResponseEntity<List<NarguileResponse>> procuraNarguilePorMarcasNarguileComMetodoLike(@RequestParam String marcaNarguile) {
        List<NarguileResponse> listaNarguileResultado = narguileServiceImpl.procuraNarguilePorMarcasNarguileComMetodoLike(marcaNarguile);

        if(listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("sugestao-material-narguile")
    public ResponseEntity<List<NarguileResponse>> procuraNarguilePorMaterialNarguileComMetodoLike(@RequestParam String materialNarguile) {
        List<NarguileResponse> listaNarguileResultado = narguileServiceImpl.procuraNarguilePorMaterialNarguileComMetodoLike(materialNarguile);

        if(listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("entre-quantidade-mangueiras-narguile")
    public ResponseEntity<List<NarguileResponse>> procuraNarguileEntreQuantidadeMangueirasNarguile(
            @RequestParam Integer quantidadeMangueirasNarguileMinimo, @RequestParam Integer quantidadeMangueirasNarguileMaximo) {

        List<NarguileResponse> listaNarguileResultado =
                narguileServiceImpl.procuraNarguileEntreQuantidadeMangueirasNarguile(quantidadeMangueirasNarguileMinimo, quantidadeMangueirasNarguileMaximo);

        if(listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("/quantidade-estoque")
    public ResponseEntity<List<NarguileResponse>> procuraNarguilePorQuantidadeEstoque(@RequestParam Integer quantidadeEstoqueNarguile) {
        List<NarguileResponse> listaNarguileResultado = narguileServiceImpl.procuraNarguilePorQuantidadeEstoqueNarguile(quantidadeEstoqueNarguile);

        if(listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @PutMapping("/{idNarguile}")
    public ResponseEntity<NarguileResponse> atualizaNarguilePorId(@PathVariable Long idNarguile, @Valid @RequestBody NarguileRequest narguileRequest) {
        NarguileResponse narguileResultado = narguileServiceImpl.atualizaNarguilePorId(idNarguile, narguileRequest);

        return new ResponseEntity<>(narguileResultado, HttpStatus.OK);
    }

    @DeleteMapping("/{idNarguile}")
    public ResponseEntity<Void> apagaNarguilePorId(@PathVariable Long idNarguile) {
        narguileServiceImpl.apagaNarguilePorId(idNarguile);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/apagar-marca-narguile")
    public ResponseEntity<Void> apagaNarguilePorMarcasNarguile(@RequestParam MarcasNarguile marcaNarguile) {
        narguileServiceImpl.apagaNarguilePorMarcasNarguile(marcaNarguile);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/apagar-material-narguile")
    public ResponseEntity<Void> apagaNarguilePorMaterialNarguile(@RequestParam MaterialNarguile materialNarguile) {
        narguileServiceImpl.apagaNarguilePorMaterialNarguile(materialNarguile);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/apagar-quantidade-mangueiras-narguile")
    public ResponseEntity<Void> apagaNarguilePorQuantidadeMangueirasNarguile(@RequestParam Integer quantidadeMangueirasNarguile) {
        narguileServiceImpl.apagaNarguilePorQuantidadeMangueirasNarguile(quantidadeMangueirasNarguile);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
