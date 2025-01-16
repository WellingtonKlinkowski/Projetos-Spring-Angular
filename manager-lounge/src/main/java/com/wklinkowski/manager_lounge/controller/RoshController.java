package com.wklinkowski.manager_lounge.controller;

import com.wklinkowski.manager_lounge.dtos.RoshDTO;
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
    public RoshController(RoshService roshService) {
        this.roshService = roshService;
    }

    @PostMapping("/criar")
    public ResponseEntity<RoshDTO> criarRosh(@Valid @RequestBody RoshDTO roshDTO) {
        RoshDTO roshResultado = roshService.criarRosh(roshDTO);

        return new ResponseEntity<>(roshResultado, HttpStatus.CREATED);
    }

    @GetMapping("/{idRosh}")
    public ResponseEntity<RoshDTO> procuraRoshPorId(@PathVariable Long idRosh) {
        RoshDTO roshResultado = roshService.procuraRoshPorId(idRosh);

        if(roshResultado == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(roshResultado, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<RoshDTO>> listarRoshs() {
        List<RoshDTO> listaRoshResultado = roshService.listarRosh();

        if(listaRoshResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaRoshResultado, HttpStatus.OK);
    }

    @GetMapping("/marcas-rosh")
    public ResponseEntity<List<RoshDTO>> procuraRoshPorMarcasRosh(@RequestParam MarcasRosh marcasRosh) {
        List<RoshDTO> listaRoshResultado = roshService.procuraRoshPorMarcasRosh(marcasRosh);

        if(listaRoshResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaRoshResultado, HttpStatus.OK);
    }

    @GetMapping("/material-rosh")
    public ResponseEntity<List<RoshDTO>> procuraRoshPorMaterialRosh(@RequestParam MaterialRosh materialRosh) {
        List<RoshDTO> listaRoshResultado = roshService.procuraRoshPorMaterialRosh(materialRosh);

        if(listaRoshResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaRoshResultado, HttpStatus.ACCEPTED);
    }

    @GetMapping("/sugestao-marcas-rosh")
    public ResponseEntity<List<RoshDTO>> procuraMarcasRoshComMetodoLike(@RequestParam String marcaRosh) {
        List<RoshDTO> listaRoshResultado = roshService.procuraMarcasRoshComMetodoLike(marcaRosh);

        if(listaRoshResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaRoshResultado, HttpStatus.OK);
    }

    @GetMapping("/sugestao-material-rosh")
    public ResponseEntity<List<RoshDTO>> procuraMaterialRoshComMetodoLike(@RequestParam String materialRosh) {
        List<RoshDTO> listaRoshResultado = roshService.procuraMaterialRoshComMetodoLike(materialRosh);

        if(listaRoshResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaRoshResultado, HttpStatus.OK);
    }

    @GetMapping("/quantidade-estoque")
    public ResponseEntity<List<RoshDTO>> procuraRoshPorQuantidadeEstoque(@RequestParam Integer quantidadeEstoqueRosh) {
        List<RoshDTO> listaRoshResultado = roshService.procuraRoshPorQuantidadeEstoqueRosh(quantidadeEstoqueRosh);

        if(listaRoshResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaRoshResultado, HttpStatus.OK);
    }

    @PutMapping("/{idRosh}")
    public ResponseEntity<RoshDTO> atualizaRoshPorId(@PathVariable Long idRosh, @Valid @RequestBody RoshDTO roshDTO) {
        RoshDTO roshResultado = roshService.atualizaRoshPorId(idRosh, roshDTO);

        return new ResponseEntity<>(roshResultado, HttpStatus.OK);
    }

    @DeleteMapping("/{idRosh}")
    public ResponseEntity<Void> apagaRoshPorId(@PathVariable Long idRosh) {
        roshService.deletaRoshPorId(idRosh);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/apagar-marca-rosh")
    public ResponseEntity<Void> apagaRoshPorMarcasRosh(@RequestParam MarcasRosh marcaRosh) {
        roshService.apagaRoshPorMarcasRosh(marcaRosh);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/apagar-material-rosh")
    public ResponseEntity<Void> apagaRoshPorMaterialRosh(@RequestParam MaterialRosh materialRosh) {
        roshService.apagaRoshPorMaterialRosh(materialRosh);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
