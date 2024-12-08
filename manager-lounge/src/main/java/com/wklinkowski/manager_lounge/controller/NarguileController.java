package com.wklinkowski.manager_lounge.controller;

import com.wklinkowski.manager_lounge.dtos.NarguileDTO;
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

    private NarguileService narguileService;

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
}
