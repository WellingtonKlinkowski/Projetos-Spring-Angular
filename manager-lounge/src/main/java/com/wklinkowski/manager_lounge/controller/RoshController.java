package com.wklinkowski.manager_lounge.controller;

import com.wklinkowski.manager_lounge.dtos.RoshDTO;
import com.wklinkowski.manager_lounge.enums.MarcaCarvao;
import com.wklinkowski.manager_lounge.enums.MarcasRosh;
import com.wklinkowski.manager_lounge.enums.MaterialRosh;
import com.wklinkowski.manager_lounge.services.RoshService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roshs")
public class RoshController {

    private final RoshService roshService;

    @Autowired
    public RoshController (RoshService roshService){
        this.roshService = roshService;
    }

    @PostMapping("/criar")
    public ResponseEntity<RoshDTO> criarRosh (@Valid @RequestBody RoshDTO roshDTO){
        RoshDTO roshResponse = roshService.criarRosh(roshDTO);

        return new ResponseEntity<>(roshResponse, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<RoshDTO>> listarRoshs(){
        List<RoshDTO> listaRosh = roshService.listarRosh();

        if(listaRosh.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaRosh, HttpStatus.OK);
    }

    @GetMapping("/{idRosh}")
    public ResponseEntity<RoshDTO> procuraRoshPorId (@PathVariable Long idRosh){
        RoshDTO roshResult = roshService.procuraRoshPorId(idRosh);

        if(roshResult == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(roshResult, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{idRosh}")
    public ResponseEntity<RoshDTO> atualizaRoshPorId (@PathVariable Long idRosh, @Valid @RequestBody RoshDTO roshDTO){
        RoshDTO roshResult = roshService.atualizaRoshPorId(idRosh, roshDTO);

        return new ResponseEntity<>(roshResult, HttpStatus.OK);
    }

    @DeleteMapping("/{idRosh}")
    public ResponseEntity<Void> deletaRoshPorId (@PathVariable Long idRosh){
        roshService.deletaRoshPorId(idRosh);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/marcas-rosh")
    public ResponseEntity<List<RoshDTO>> procuraRoshPorMarcasRosh (@RequestParam MarcasRosh marcasRosh){
        List<RoshDTO> listaRoshResult = roshService.procuraRoshPorMarcasRosh(marcasRosh);

        if(listaRoshResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaRoshResult, HttpStatus.ACCEPTED);
    }

    @GetMapping("/material-rosh")
    public ResponseEntity<List<RoshDTO>> procuraRoshPorMaterialRosh (@RequestParam MaterialRosh materialRosh){
        List<RoshDTO> listaRoshResult = roshService.procuraRoshPorMaterialRosh(materialRosh);

        if(listaRoshResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaRoshResult, HttpStatus.ACCEPTED);
    }

    @GetMapping("/sugestao-marcas-rosh")
    public ResponseEntity<List<RoshDTO>> procuraMarcasRoshComMetodoLike (@RequestParam String marcaRosh){
        List<RoshDTO> listaRoshResult = roshService.procuraMarcasRoshComMetodoLike(marcaRosh);

        if(listaRoshResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaRoshResult, HttpStatus.ACCEPTED);
    }

    @GetMapping("/sugestao-material-rosh")
    public ResponseEntity<List<RoshDTO>> procuraMaterialRoshComMetodoLike (@RequestParam String materialRosh){
        List<RoshDTO> listaRoshResult = roshService.procuraMaterialRoshComMetodoLike(materialRosh);

        if(listaRoshResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaRoshResult, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/apagar-marca-rosh")
    public ResponseEntity<Void> apagaRoshPorMarcasRosh (@RequestParam MarcasRosh marcaRosh){
        roshService.apagaRoshPorMarcasRosh(marcaRosh);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/apagar-material-rosh")
    public ResponseEntity<Void> apagaRoshPorMaterialRosh (@RequestParam MaterialRosh materialRosh){
        roshService.apagaRoshPorMaterialRosh(materialRosh);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
