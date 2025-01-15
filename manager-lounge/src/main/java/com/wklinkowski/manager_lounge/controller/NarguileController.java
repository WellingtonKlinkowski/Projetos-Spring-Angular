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
        NarguileDTO narguileResultado = narguileService.criarNarguile(narguileDTO);

        return new ResponseEntity<>(narguileResultado, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NarguileDTO>> listarNarguiles (){
        List<NarguileDTO> listaNarguileResultado = narguileService.listarNarguiles();

        if( listaNarguileResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("/{idNarguile}")
    public ResponseEntity<NarguileDTO> procuraNarguilePorId (@PathVariable Long idNarguile) {
        NarguileDTO narguileResultado = narguileService.procuraNarguilePorId(idNarguile);

        if( narguileResultado == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(narguileResultado, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{idNarguile}")
    public ResponseEntity<NarguileDTO> atualizaNarguilePorId (@PathVariable Long idNarguile, @Valid @RequestBody NarguileDTO narguileDTO){
        NarguileDTO narguileResultado = narguileService.atualizaNarguilePorId(idNarguile, narguileDTO);

        return new ResponseEntity<>(narguileResultado, HttpStatus.OK);
    }

    @DeleteMapping("/{idNarguile}")
    public ResponseEntity<Void> deletaNarguilePorId (@PathVariable Long idNarguile) {
        narguileService.deletaNarguilePorId(idNarguile);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("nome-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorNomeNarguile (@RequestParam String nomeNarguile){
        List<NarguileDTO> listaNarguileResultado = narguileService.procuraNarguilePorNomeNarguile(nomeNarguile);

        if(listaNarguileResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("marca-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorMarcaNarguile (@RequestParam MarcasNarguile marcaNarguile){
        List<NarguileDTO> listaNarguileResultado = narguileService.procuraNarguilePorMarcaNarguile(marcaNarguile);

        if(listaNarguileResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("quantidade-mangueiras-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorQuantidadeMangueirasNarguile (@RequestParam Integer quantidadeMangueirasNarguile){
        List<NarguileDTO> listaNarguileResultado = narguileService.procuraNarguilePorQuantidadeMangueirasNarguile(quantidadeMangueirasNarguile);

        if(listaNarguileResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("material-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorMaterialNarguile (@RequestParam MaterialNarguile materialNarguile){
        List<NarguileDTO> listaNarguileResultado = narguileService.procuraNarguilePorMaterialNarguile(materialNarguile);

        if(listaNarguileResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("sugestao-nome-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorNomeNarguileComMetodoLike (@RequestParam String nomeNarguile){
        List<NarguileDTO> listaNarguileResultado = narguileService.procuraNarguilePorNomeNarguileComMetodoLike(nomeNarguile);

        if(listaNarguileResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("sugestao-marcas-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorMarcasNarguileComMetodoLike (@RequestParam String marcaNarguile){
        List<NarguileDTO> listaNarguileResultado = narguileService.procuraNarguilePorMarcasNarguileComMetodoLike(marcaNarguile);

        if(listaNarguileResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("sugestao-material-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguilePorMaterialNarguileComMetodoLike (@RequestParam String materialNarguile){
        List<NarguileDTO> listaNarguileResultado = narguileService.procuraNarguilePorMaterialNarguileComMetodoLike(materialNarguile);

        if(listaNarguileResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("entre-quantidade-mangueiras-narguile")
    public ResponseEntity<List<NarguileDTO>> procuraNarguileEntreQuantidadeMangueirasNarguile (
            @RequestParam Integer quantidadeMangueirasNarguileMinimo, @RequestParam Integer quantidadeMangueirasNarguileMaximo){

        List<NarguileDTO> listaNarguileResultado =
                narguileService.procuraNarguileEntreQuantidadeMangueirasNarguile(quantidadeMangueirasNarguileMinimo, quantidadeMangueirasNarguileMaximo);

        if(listaNarguileResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
    }

    @GetMapping("/quantidade-estoque")
    public ResponseEntity<List<NarguileDTO>> buscaNarguilePorQuantidadeEstoque (@RequestParam Integer quantidadeEstoqueNarguile) {
        List<NarguileDTO> listaNarguileResultado = narguileService.procuraNarguilePorQuantidadeEstoqueNarguile(quantidadeEstoqueNarguile);

        if(listaNarguileResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaNarguileResultado, HttpStatus.OK);
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
