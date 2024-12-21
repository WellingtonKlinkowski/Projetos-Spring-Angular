package com.wklinkowski.manager_lounge.controller;

import com.wklinkowski.manager_lounge.dtos.FumoDTO;
import com.wklinkowski.manager_lounge.dtos.NarguileDTO;
import com.wklinkowski.manager_lounge.enums.MarcasNarguile;
import com.wklinkowski.manager_lounge.enums.MaterialNarguile;
import com.wklinkowski.manager_lounge.services.NarguileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/narguiles")
public class NarguileController {

    private final NarguileService narguileService;

    @Autowired
    public NarguileController (NarguileService narguileService){
        this.narguileService = narguileService;
    }

    @PostMapping("/criar")
    public ResponseEntity<NarguileDTO> criarNarguile (@Valid @RequestBody NarguileDTO narguileDTO){
        NarguileDTO narguileResponse = narguileService.criarNarguile(narguileDTO);

        return new ResponseEntity<>(narguileResponse, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NarguileDTO>> listarNarguiles (){
        List<NarguileDTO> listaNarguile = narguileService.listarNarguiles();

        if( listaNarguile.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguile, HttpStatus.OK);
    }

    @GetMapping("/{idNarguile}")
    public ResponseEntity<NarguileDTO> procuraNarguilePorId (@PathVariable Long idNarguile) {
        NarguileDTO narguileResult = narguileService.procuraNarguilePorId(idNarguile);

        if( narguileResult == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(narguileResult, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{idNarguile}")
    public ResponseEntity<NarguileDTO> atualizaNarguilePorId (@PathVariable Long idNarguile, @Valid @RequestBody NarguileDTO narguileDTO){
        NarguileDTO narguileResult = narguileService.atualizaNarguilePorId(idNarguile, narguileDTO);

        return new ResponseEntity<>(narguileResult, HttpStatus.OK);
    }

    @DeleteMapping("/{idNarguile}")
    public ResponseEntity<Void> deletaNarguilePorId (@PathVariable Long idNarguile) {
        narguileService.deletaNarguilePorId(idNarguile);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("nome-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorNomeNarguile (@RequestParam String nomeNarguile){
        List<NarguileDTO> listaNarguileResult = narguileService.procuraNarguilePorNomeNarguile(nomeNarguile);

        if(listaNarguileResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResult, HttpStatus.OK);
    }

    @GetMapping("marca-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorMarcaNarguile (@RequestParam MarcasNarguile marcaNarguile){
        List<NarguileDTO> listaNarguileResult = narguileService.procuraNarguilePorMarcaNarguile(marcaNarguile);

        if(listaNarguileResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResult, HttpStatus.OK);
    }

    @GetMapping("quantidade-mangueiras-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorQuantidadeMangueirasNarguile (@RequestParam Integer quantidadeMangueirasNarguile){
        List<NarguileDTO> listaNarguileResult = narguileService.procuraNarguilePorQuantidadeMangueirasNarguile(quantidadeMangueirasNarguile);

        if(listaNarguileResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResult, HttpStatus.OK);
    }

    @GetMapping("material-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorMaterialNarguile (@RequestParam MaterialNarguile materialNarguile){
        List<NarguileDTO> listaNarguileResult = narguileService.procuraNarguilePorMaterialNarguile(materialNarguile);

        if(listaNarguileResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResult, HttpStatus.OK);
    }

    @GetMapping("sugestao-nome-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorNomeNarguileComMetodoLike (@RequestParam String nomeNarguile){
        List<NarguileDTO> listaNarguileResult = narguileService.procuraNarguilePorNomeNarguileComMetodoLike(nomeNarguile);

        if(listaNarguileResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResult, HttpStatus.OK);
    }

    @GetMapping("sugestao-marcas-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorMarcasNarguileComMetodoLike (@RequestParam String marcaNarguile){
        List<NarguileDTO> listaNarguileResult = narguileService.procuraNarguilePorMarcasNarguileComMetodoLike(marcaNarguile);

        if(listaNarguileResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResult, HttpStatus.OK);
    }

    @GetMapping("sugestao-material-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorMaterialNarguileComMetodoLike (@RequestParam String materialNarguile){
        List<NarguileDTO> listaNarguileResult = narguileService.procuraNarguilePorMaterialNarguileComMetodoLike(materialNarguile);

        if(listaNarguileResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResult, HttpStatus.OK);
    }

    @GetMapping("entre-quantidade-mangueiras-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguileEntreQuantidadeMangueirasNarguile (
            @RequestParam Integer quantidadeMangueirasNarguileMinimo, @RequestParam Integer quantidadeMangueirasNarguileMaximo){

        List<NarguileDTO> listaNarguileResult =
                narguileService.procuraNarguileEntreQuantidadeMangueirasNarguile(quantidadeMangueirasNarguileMinimo, quantidadeMangueirasNarguileMaximo);

        if(listaNarguileResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResult, HttpStatus.OK);
    }

    @DeleteMapping("/apagar-marca-narguile")
    public ResponseEntity<Void> apagaNarguilePorMarcasNarguile (@RequestParam MarcasNarguile marcaNarguile) {
        narguileService.apagaNarguilePorMarcasNarguile(marcaNarguile);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/apagar-material-narguile")
    public ResponseEntity<Void> apagaNarguilePorMaterialNarguile (@RequestParam MaterialNarguile materialNarguile) {
        narguileService.apagaNarguilePorMaterialNarguile(materialNarguile);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/apagar-quantidade-mangueiras-narguile")
    public ResponseEntity<Void> apagaNarguilePorQuantidadeMangueirasNarguile (@RequestParam Integer quantidadeMangueirasNarguile) {
        narguileService.apagaNarguilePorQuantidadeMangueirasNarguile(quantidadeMangueirasNarguile);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
