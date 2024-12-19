package com.wklinkowski.manager_lounge.controller;

import com.wklinkowski.manager_lounge.dtos.CarvaoDTO;
import com.wklinkowski.manager_lounge.enums.MarcaCarvao;
import com.wklinkowski.manager_lounge.services.CarvaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carvoes")
public class CarvaoController {

    private final CarvaoService carvaoService;

    @Autowired
    public CarvaoController (CarvaoService carvaoService){
        this.carvaoService = carvaoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<CarvaoDTO> criarCarvao (@Valid @RequestBody CarvaoDTO carvaoDTO){
        CarvaoDTO carvaoResult = carvaoService.criarCarvao(carvaoDTO);

        return new ResponseEntity<>(carvaoResult, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CarvaoDTO>> listarCarvoes (){
        List<CarvaoDTO> listaCarvao = carvaoService.listarCarvoes();

        if(listaCarvao.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvao, HttpStatus.OK);
    }

    @GetMapping("/{idCarvao}")
    public ResponseEntity<CarvaoDTO> procurarCarvaoPorId (@PathVariable Long idCarvao) {
        CarvaoDTO carvaoResult = carvaoService.procurarCarvaoPorId(idCarvao);

        if(carvaoResult == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(carvaoResult, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{idCarvao}")
    public ResponseEntity<CarvaoDTO> atualizaCarvaoPorId (@PathVariable Long idCarvao, @Valid @RequestBody CarvaoDTO carvaoDTO){
        CarvaoDTO carvaoResult = carvaoService.atualizarCarvaoPorId(idCarvao, carvaoDTO);

        return new ResponseEntity<>(carvaoResult, HttpStatus.OK);
    }

    @DeleteMapping("/{idCarvao}")
    public ResponseEntity<Void> deletaCarvaoPorId (@PathVariable Long idCarvao){
        carvaoService.deletaCarvaoPorId(idCarvao);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/marca-carvao")
    public ResponseEntity<List<CarvaoDTO>> procuraCarvaoPorMarca (@RequestParam MarcaCarvao marcaCarvao){
        List<CarvaoDTO> listaCarvaoPorMarcaResult = carvaoService.procuraCarvaoPorMarcaCarvao(marcaCarvao);

        if(listaCarvaoPorMarcaResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoPorMarcaResult, HttpStatus.OK);
    }

    @GetMapping("/peso-carvao")
    public ResponseEntity<List<CarvaoDTO>> procuraCarvaoPorPeso (@RequestParam Integer pesoCarvao) {
        List<CarvaoDTO> listaCarvaoResult = carvaoService.procuraCarvaoPorPesoCarvao(pesoCarvao);

        if(listaCarvaoResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResult, HttpStatus.OK);
    }

    @GetMapping("/quantidade-carvao")
    public ResponseEntity<List<CarvaoDTO>> procuraCarvaoPorQuantidade (@RequestParam Integer quantidadeCarvao) {
        List<CarvaoDTO> listaCarvaoResult = carvaoService.procuraCarvaoPorQuantidadeCarvao(quantidadeCarvao);

        if(listaCarvaoResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResult, HttpStatus.OK);
    }

    @GetMapping("/marca-peso-carvao")
    public ResponseEntity<List<CarvaoDTO>> procuraCarvaoPorMarcaEPeso (@RequestParam MarcaCarvao marcaCarvao, @RequestParam Integer pesoCarvao) {
        List<CarvaoDTO> listaCarvaoResult = carvaoService.procuraCarvaoPorMarcaEPeso(marcaCarvao, pesoCarvao);

        if(listaCarvaoResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResult, HttpStatus.OK);
    }

    @GetMapping("/sugestao-marca-carvao")
    public ResponseEntity<List<CarvaoDTO>> procuraMarcaCarvaoUsandoLike (@RequestParam String marcaCarvao) {
        List<CarvaoDTO> listaCarvaoResult = carvaoService.procuraMarcaCarvaoUsandoLike(marcaCarvao);

        if(listaCarvaoResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResult, HttpStatus.OK);
    }

    @GetMapping("/entre-peso-carvao")
    public ResponseEntity<List<CarvaoDTO>> procuraCarvaoComPesoEntreDoisValores (@RequestParam Integer pesoMinimo, @RequestParam Integer pesoMaximo) {
        List<CarvaoDTO> listaCarvaoResult = carvaoService.procuraCarvaoComPesoEntreDoisValores(pesoMinimo, pesoMaximo);

        if(listaCarvaoResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResult, HttpStatus.OK);
    }

    @DeleteMapping("/apagar-marca-carvao")
    public ResponseEntity<Void> apagarCarvaoPorMarca (@RequestParam MarcaCarvao marcaCarvao){
        carvaoService.deletarCarvaoPorMarcaCarvao(marcaCarvao);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
