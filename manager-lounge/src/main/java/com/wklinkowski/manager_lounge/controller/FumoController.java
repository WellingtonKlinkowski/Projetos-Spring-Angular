package com.wklinkowski.manager_lounge.controller;

import com.wklinkowski.manager_lounge.dtos.FumoDTO;
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

    private FumoService fumoService;

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
}
