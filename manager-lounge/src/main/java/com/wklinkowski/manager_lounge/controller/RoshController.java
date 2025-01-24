package com.wklinkowski.manager_lounge.controller;

import com.wklinkowski.manager_lounge.dtos.request.RoshRequest;
import com.wklinkowski.manager_lounge.dtos.response.RoshResponse;
import com.wklinkowski.manager_lounge.enums.MarcasRosh;
import com.wklinkowski.manager_lounge.enums.MaterialRosh;
import com.wklinkowski.manager_lounge.services.RoshServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roshs")
public class RoshController {

    private final RoshServiceImpl roshServiceImpl;

    public RoshController(RoshServiceImpl roshServiceImpl) {
        this.roshServiceImpl = roshServiceImpl;
    }

    @PostMapping("/criar")
    public ResponseEntity<RoshResponse> criarRosh(@Valid @RequestBody RoshRequest roshRequest) {
        RoshResponse roshResultado = roshServiceImpl.criarRosh(roshRequest);

        return new ResponseEntity<>(roshResultado, HttpStatus.CREATED);
    }

    @GetMapping("/{idRosh}")
    public ResponseEntity<RoshResponse> procuraRoshPorId(@PathVariable Long idRosh) {
        RoshResponse roshResultado = roshServiceImpl.procuraRoshPorId(idRosh);

        if(roshResultado == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(roshResultado, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<RoshResponse>> listarRoshs() {
        List<RoshResponse> listaRoshResultado = roshServiceImpl.listarRosh();

        if(listaRoshResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaRoshResultado, HttpStatus.OK);
    }

    @GetMapping("/marcas-rosh")
    public ResponseEntity<List<RoshResponse>> procuraRoshPorMarcasRosh(@RequestParam MarcasRosh marcasRosh) {
        List<RoshResponse> listaRoshResultado = roshServiceImpl.procuraRoshPorMarcasRosh(marcasRosh);

        if(listaRoshResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaRoshResultado, HttpStatus.OK);
    }

    @GetMapping("/material-rosh")
    public ResponseEntity<List<RoshResponse>> procuraRoshPorMaterialRosh(@RequestParam MaterialRosh materialRosh) {
        List<RoshResponse> listaRoshResultado = roshServiceImpl.procuraRoshPorMaterialRosh(materialRosh);

        if(listaRoshResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaRoshResultado, HttpStatus.ACCEPTED);
    }

    @GetMapping("/sugestao-marcas-rosh")
    public ResponseEntity<List<RoshResponse>> procuraMarcasRoshComMetodoLike(@RequestParam String marcaRosh) {
        List<RoshResponse> listaRoshResultado = roshServiceImpl.procuraMarcasRoshComMetodoLike(marcaRosh);

        if(listaRoshResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaRoshResultado, HttpStatus.OK);
    }

    @GetMapping("/sugestao-material-rosh")
    public ResponseEntity<List<RoshResponse>> procuraMaterialRoshComMetodoLike(@RequestParam String materialRosh) {
        List<RoshResponse> listaRoshResultado = roshServiceImpl.procuraMaterialRoshComMetodoLike(materialRosh);

        if(listaRoshResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaRoshResultado, HttpStatus.OK);
    }

    @GetMapping("/quantidade-estoque")
    public ResponseEntity<List<RoshResponse>> procuraRoshPorQuantidadeEstoque(@RequestParam Integer quantidadeEstoqueRosh) {
        List<RoshResponse> listaRoshResultado = roshServiceImpl.procuraRoshPorQuantidadeEstoqueRosh(quantidadeEstoqueRosh);

        if(listaRoshResultado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaRoshResultado, HttpStatus.OK);
    }

    @PutMapping("/{idRosh}")
    public ResponseEntity<RoshResponse> atualizaRoshPorId(@PathVariable Long idRosh, @Valid @RequestBody RoshRequest roshRequest) {
        RoshResponse roshResultado = roshServiceImpl.atualizaRoshPorId(idRosh, roshRequest);

        return new ResponseEntity<>(roshResultado, HttpStatus.OK);
    }

    @DeleteMapping("/{idRosh}")
    public ResponseEntity<Void> apagaRoshPorId(@PathVariable Long idRosh) {
        roshServiceImpl.deletaRoshPorId(idRosh);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/apagar-marca-rosh")
    public ResponseEntity<Void> apagaRoshPorMarcasRosh(@RequestParam MarcasRosh marcaRosh) {
        roshServiceImpl.apagaRoshPorMarcasRosh(marcaRosh);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/apagar-material-rosh")
    public ResponseEntity<Void> apagaRoshPorMaterialRosh(@RequestParam MaterialRosh materialRosh) {
        roshServiceImpl.apagaRoshPorMaterialRosh(materialRosh);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
