package com.wklinkowski.manager_lounge.controller;

import com.wklinkowski.manager_lounge.dtos.FumoDTO;
import com.wklinkowski.manager_lounge.enums.MarcasFumo;
import com.wklinkowski.manager_lounge.services.FumoService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fumos")
public class FumoController {

    private final FumoService fumoService;

    @Autowired
    public FumoController (FumoService fumoService){
        this.fumoService = fumoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<FumoDTO> criarFumo (@Valid @RequestBody FumoDTO fumoDTO){
        FumoDTO fumoResultado = fumoService.criarFumo(fumoDTO);

        return new ResponseEntity<>(fumoResultado, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FumoDTO>> listarFumos (){
        List<FumoDTO> listaFumoResultado = fumoService.listarFumos();

        if(listaFumoResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("/{idFumo}")
    public ResponseEntity<FumoDTO> procuraFumoPorId (@PathVariable Long idFumo){
        FumoDTO fumoResultado = fumoService.procurarFumoPorId(idFumo);

        if(fumoResultado == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(fumoResultado, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{idFumo}")
    public ResponseEntity<FumoDTO> atualizaFumoPorId (@PathVariable Long idFumo, @Valid @RequestBody FumoDTO fumoDTO){
        FumoDTO fumoResultado = fumoService.atualizaFumoPorId(idFumo, fumoDTO);

        return new ResponseEntity<>(fumoResultado, HttpStatus.OK);
    }

    @DeleteMapping("/{idFumo}")
    public ResponseEntity<Void> deletaFumoPorId (@PathVariable Long idFumo){
        fumoService.deletaFumoPorId(idFumo);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("marcas-fumo")
    public ResponseEntity<List<FumoDTO>> procuraFumoPorMarcasFumo (@RequestParam MarcasFumo marcasFumo){
        List<FumoDTO> listaFumoResultado = fumoService.procuraFumoPorMarcasFumo(marcasFumo);

        if(listaFumoResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("sabor-fumo")
    public ResponseEntity<List<FumoDTO>> procuraFumoPorSaborFumo (@RequestParam String saborFumo){
        List<FumoDTO> listaFumoResultado = fumoService.procuraFumoPorSaborFumo(saborFumo);

        if(listaFumoResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("peso-fumo")
    public ResponseEntity<List<FumoDTO>> procuraFumoPorPesoFumo (@RequestParam Integer pesoFumo){
        List<FumoDTO> listaFumoResultado = fumoService.procuraFumoPorPesoFumo(pesoFumo);

        if(listaFumoResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("sugestao-marca-fumo")
    public ResponseEntity<List<FumoDTO>> procuraFumoPorMarcaFumoUsandoLike (@RequestParam String marcaFumo){
        List<FumoDTO> listaFumoResultado = fumoService.procuraFumoPorMarcasFumoUsandoLike(marcaFumo);

        if(listaFumoResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("sugestao-sabor-fumo")
    public ResponseEntity<List<FumoDTO>> procuraFumoPorSaborFumoUsandoLike (@RequestParam String saborFumo){
        List<FumoDTO> listaFumoResultado = fumoService.procuraFumoPorSaborFumoUsandoLike(saborFumo);

        if(listaFumoResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("entre-peso-fumo")
    public ResponseEntity<List<FumoDTO>> procuraFumoEntrePesos (@RequestParam Integer pesoMinimoFumo, @RequestParam Integer pesoMaximoFumo){
        List<FumoDTO> listaFumoResultado = fumoService.procuraFumoEntrePesos(pesoMinimoFumo, pesoMaximoFumo);

        if(listaFumoResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @GetMapping("/quantidade-estoque")
    public ResponseEntity<List<FumoDTO>> buscaFumoPorQuantidadeEstoque (@RequestParam Integer quantidadeFumoEstoque){
        List<FumoDTO> listaFumoResultado = fumoService.procuraFumoPorQuantidadeEmEstoque(quantidadeFumoEstoque);

        if(listaFumoResultado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResultado, HttpStatus.OK);
    }

    @DeleteMapping("/apaga-marca-fumo")
    public ResponseEntity<Void> deletaFumoPorMarcaFumo (@RequestParam MarcasFumo marcaFumo){
        fumoService.apagaFumoPorMarcasFumo(marcaFumo);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
