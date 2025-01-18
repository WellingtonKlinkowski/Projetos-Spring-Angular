package com.wklinkowski.manager_lounge.controller;

import com.wklinkowski.manager_lounge.dtos.NarguileDTO;
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
    public ResponseEntity<NarguileDTO> criarNarguile(@Valid @RequestBody NarguileDTO narguileDTO) {
        NarguileDTO narguileResultado = narguileServiceImpl.criarNarguile(narguileDTO);

        return new ResponseEntity<>(narguileResultado, HttpStatus.CREATED);
    }

    @GetMapping("/{idNarguile}")
    public ResponseEntity<NarguileDTO> procuraNarguilePorId(@PathVariable Long idNarguile) {
        NarguileDTO narguileResultado = narguileServiceImpl.procuraNarguilePorId(idNarguile);

        if( narguileResultado == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(narguileResultado, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NarguileDTO>> listarNarguiles() {
        List<NarguileDTO> listaNarguileResultado = narguileServiceImpl.listarNarguiles();

        if( listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("nome-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorNomeNarguile(@RequestParam String nomeNarguile) {
        List<NarguileDTO> listaNarguileResultado = narguileServiceImpl.procuraNarguilePorNomeNarguile(nomeNarguile);

        if(listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("marca-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorMarcaNarguile(@RequestParam MarcasNarguile marcaNarguile) {
        List<NarguileDTO> listaNarguileResultado = narguileServiceImpl.procuraNarguilePorMarcaNarguile(marcaNarguile);

        if(listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("quantidade-mangueiras-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorQuantidadeMangueirasNarguile(@RequestParam Integer quantidadeMangueirasNarguile) {
        List<NarguileDTO> listaNarguileResultado = narguileServiceImpl.procuraNarguilePorQuantidadeMangueirasNarguile(quantidadeMangueirasNarguile);

        if(listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("material-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorMaterialNarguile(@RequestParam MaterialNarguile materialNarguile) {
        List<NarguileDTO> listaNarguileResultado = narguileServiceImpl.procuraNarguilePorMaterialNarguile(materialNarguile);

        if(listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("sugestao-nome-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorNomeNarguileComMetodoLike(@RequestParam String nomeNarguile) {
        List<NarguileDTO> listaNarguileResultado = narguileServiceImpl.procuraNarguilePorNomeNarguileComMetodoLike(nomeNarguile);

        if(listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("sugestao-marcas-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorMarcasNarguileComMetodoLike(@RequestParam String marcaNarguile) {
        List<NarguileDTO> listaNarguileResultado = narguileServiceImpl.procuraNarguilePorMarcasNarguileComMetodoLike(marcaNarguile);

        if(listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("sugestao-material-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorMaterialNarguileComMetodoLike(@RequestParam String materialNarguile) {
        List<NarguileDTO> listaNarguileResultado = narguileServiceImpl.procuraNarguilePorMaterialNarguileComMetodoLike(materialNarguile);

        if(listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("entre-quantidade-mangueiras-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguileEntreQuantidadeMangueirasNarguile(
            @RequestParam Integer quantidadeMangueirasNarguileMinimo, @RequestParam Integer quantidadeMangueirasNarguileMaximo) {

        List<NarguileDTO> listaNarguileResultado =
                narguileServiceImpl.procuraNarguileEntreQuantidadeMangueirasNarguile(quantidadeMangueirasNarguileMinimo, quantidadeMangueirasNarguileMaximo);

        if(listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("/quantidade-estoque")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorQuantidadeEstoque(@RequestParam Integer quantidadeEstoqueNarguile) {
        List<NarguileDTO> listaNarguileResultado = narguileServiceImpl.procuraNarguilePorQuantidadeEstoqueNarguile(quantidadeEstoqueNarguile);

        if(listaNarguileResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @PutMapping("/{idNarguile}")
    public ResponseEntity<NarguileDTO> atualizaNarguilePorId(@PathVariable Long idNarguile, @Valid @RequestBody NarguileDTO narguileDTO) {
        NarguileDTO narguileResultado = narguileServiceImpl.atualizaNarguilePorId(idNarguile, narguileDTO);

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
