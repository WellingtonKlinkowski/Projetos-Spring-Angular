package com.wklinkowski.manager_lounge.controller;

import com.wklinkowski.manager_lounge.dtos.CarvaoDTO;
import com.wklinkowski.manager_lounge.entities.CarvaoEntity;
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
        CarvaoDTO carvaoResultado = carvaoService.criarCarvao(carvaoDTO);

        return new ResponseEntity<>(carvaoResultado, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CarvaoDTO>> listarCarvoes (){
        List<CarvaoDTO> listaCarvaoResultado = carvaoService.listarCarvoes();

        if(listaCarvaoResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/{idCarvao}")
    public ResponseEntity<CarvaoDTO> procurarCarvaoPorId (@PathVariable Long idCarvao) {
        CarvaoDTO carvaoResultado = carvaoService.procurarCarvaoPorId(idCarvao);

        if(carvaoResultado == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(carvaoResultado, HttpStatus.ACCEPTED);
    }

    @GetMapping("/marca-carvao")
    public ResponseEntity<List<CarvaoDTO>> procuraCarvaoPorMarca (@RequestParam MarcaCarvao marcaCarvao){
        List<CarvaoDTO> listaCarvaoResultado = carvaoService.procuraCarvaoPorMarcaCarvao(marcaCarvao);

        if(listaCarvaoResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/peso-carvao")
    public ResponseEntity<List<CarvaoDTO>> procuraCarvaoPorPeso (@RequestParam Integer pesoCarvao) {
        List<CarvaoDTO> listaCarvaoResultado = carvaoService.procuraCarvaoPorPesoCarvao(pesoCarvao);

        if(listaCarvaoResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/quantidade-carvao")
    public ResponseEntity<List<CarvaoDTO>> procuraCarvaoPorQuantidade (@RequestParam Integer quantidadeCarvao) {
        List<CarvaoDTO> listaCarvaoResultado = carvaoService.procuraCarvaoPorQuantidadeCarvao(quantidadeCarvao);

        if(listaCarvaoResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/marca-peso-carvao")
    public ResponseEntity<List<CarvaoDTO>> procuraCarvaoPorMarcaEPeso (@RequestParam MarcaCarvao marcaCarvao, @RequestParam Integer pesoCarvao) {
        List<CarvaoDTO> listaCarvaoResultado = carvaoService.procuraCarvaoPorMarcaEPeso(marcaCarvao, pesoCarvao);

        if(listaCarvaoResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/sugestao-marca-carvao")
    public ResponseEntity<List<CarvaoDTO>> procuraMarcaCarvaoUsandoLike (@RequestParam String marcaCarvao) {
        List<CarvaoDTO> listaCarvaoResultado = carvaoService.procuraMarcaCarvaoUsandoLike(marcaCarvao);

        if(listaCarvaoResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/entre-peso-carvao")
    public ResponseEntity<List<CarvaoDTO>> procuraCarvaoComPesoEntreDoisValores (@RequestParam Integer pesoMinimo, @RequestParam Integer pesoMaximo) {
        List<CarvaoDTO> listaCarvaoResultado = carvaoService.procuraCarvaoComPesoEntreDoisValores(pesoMinimo, pesoMaximo);

        if(listaCarvaoResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @GetMapping("/quantidade-estoque")
    public ResponseEntity<List<CarvaoDTO>> procuraCarvaoPorQuantidadeEstoque (@RequestParam Integer quantidadeEstoqueCarvao){
        List<CarvaoDTO> listaCarvaoResultado = carvaoService.procuraCarvaoPorQuantidadeEmEstoque(quantidadeEstoqueCarvao);

        if(listaCarvaoResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaCarvaoResultado, HttpStatus.OK);
    }

    @PutMapping("/{idCarvao}")
    public ResponseEntity<CarvaoDTO> atualizaCarvaoPorId (@PathVariable Long idCarvao, @Valid @RequestBody CarvaoDTO carvaoDTO){
        CarvaoDTO carvaoResultado = carvaoService.atualizarCarvaoPorId(idCarvao, carvaoDTO);

        return new ResponseEntity<>(carvaoResultado, HttpStatus.OK);
    }

    @DeleteMapping("/{idCarvao}")
    public ResponseEntity<Void> deletaCarvaoPorId (@PathVariable Long idCarvao){
        carvaoService.deletaCarvaoPorId(idCarvao);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/apagar-marca-carvao")
    public ResponseEntity<Void> deletarCarvaoPorMarca (@RequestParam MarcaCarvao marcaCarvao){
        carvaoService.deletarCarvaoPorMarcaCarvao(marcaCarvao);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
