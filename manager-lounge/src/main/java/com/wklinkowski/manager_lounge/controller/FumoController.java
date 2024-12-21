package com.wklinkowski.manager_lounge.controller;

import com.wklinkowski.manager_lounge.dtos.FumoDTO;
import com.wklinkowski.manager_lounge.enums.MarcasFumo;
import com.wklinkowski.manager_lounge.services.FumoService;
import jakarta.validation.Valid;
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
        FumoDTO respostaCreate = fumoService.criarFumo(fumoDTO);

        return new ResponseEntity<>(respostaCreate, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FumoDTO>> listarFumos (){
        List<FumoDTO> listaFumo = fumoService.listarFumos();

        if(listaFumo.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumo, HttpStatus.OK);
    }

    @GetMapping("/{idFumo}")
    public ResponseEntity<FumoDTO> procuraFumoPorId (@PathVariable Long idFumo){
        FumoDTO fumoResult = fumoService.procurarFumoPorId(idFumo);

        if(fumoResult == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(fumoResult, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{idFumo}")
    public ResponseEntity<FumoDTO> atualizaFumoPorId (@PathVariable Long idFumo, @Valid @RequestBody FumoDTO fumoDTO){
        FumoDTO fumoResult = fumoService.atualizaFumoPorId(idFumo, fumoDTO);

        return new ResponseEntity<>(fumoResult, HttpStatus.OK);
    }

    @DeleteMapping("/{idFumo}")
    public ResponseEntity<Void> deletaFumoPorId (@PathVariable Long idFumo){
        fumoService.deletaFumoPorId(idFumo);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("marcas-fumo")
    public ResponseEntity<List<FumoDTO>> procuraFumoPorMarcasFumo (@RequestParam MarcasFumo marcasFumo){
        List<FumoDTO> listaFumoResult = fumoService.procuraFumoPorMarcasFumo(marcasFumo);

        if(listaFumoResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResult, HttpStatus.OK);
    }

    @GetMapping("sabor-fumo")
    public ResponseEntity<List<FumoDTO>> procuraFumoPorSaborFumo (@RequestParam String saborFumo){
        List<FumoDTO> listaFumoResult = fumoService.procuraFumoPorSaborFumo(saborFumo);

        if(listaFumoResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResult, HttpStatus.OK);
    }

    @GetMapping("peso-fumo")
    public ResponseEntity<List<FumoDTO>> procuraFumoPorPesoFumo (@RequestParam Integer pesoFumo){
        List<FumoDTO> listaFumoResult = fumoService.procuraFumoPorPesoFumo(pesoFumo);

        if(listaFumoResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResult, HttpStatus.OK);
    }

    @GetMapping("sugestao-marca-fumo")
    public ResponseEntity<List<FumoDTO>> procuraFumoPorMarcaFumoUsandoLike (@RequestParam String marcaFumo){
        List<FumoDTO> listaFumoResult = fumoService.procuraFumoPorMarcasFumoUsandoLike(marcaFumo);

        if(listaFumoResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResult, HttpStatus.OK);
    }

    @GetMapping("sugestao-sabor-fumo")
    public ResponseEntity<List<FumoDTO>> procuraFumoPorSaborFumoUsandoLike (@RequestParam String saborFumo){
        List<FumoDTO> listaFumoResult = fumoService.procuraFumoPorSaborFumoUsandoLike(saborFumo);

        if(listaFumoResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResult, HttpStatus.OK);
    }

    @GetMapping("entre-peso-fumo")
    public ResponseEntity<List<FumoDTO>> procuraFumoEntrePesos (@RequestParam Integer pesoMinimoFumo, @RequestParam Integer pesoMaximoFumo){
        List<FumoDTO> listaFumoResult = fumoService.procuraFumoEntrePesos(pesoMinimoFumo, pesoMaximoFumo);

        if(listaFumoResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaFumoResult, HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deletaFumoPorMarcaFumo (@RequestParam MarcasFumo marcaFumo){
        fumoService.apagaFumoPorMarcasFumo(marcaFumo);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
