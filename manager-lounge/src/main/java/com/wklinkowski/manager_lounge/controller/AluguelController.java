package com.wklinkowski.manager_lounge.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wklinkowski.manager_lounge.dtos.AluguelDTO;
import com.wklinkowski.manager_lounge.services.AluguelServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    private final AluguelServiceImpl aluguelServiceImpl;

    public AluguelController(AluguelServiceImpl aluguelServiceImpl) {
        this.aluguelServiceImpl = aluguelServiceImpl;
    }

    @PostMapping("/criar")
    public ResponseEntity<AluguelDTO> criarAluguel(@Valid @RequestBody AluguelDTO aluguelDTO) {
        AluguelDTO aluguelResultado = aluguelServiceImpl.criarAluguel(aluguelDTO);

        return new ResponseEntity<>(aluguelResultado, HttpStatus.CREATED);
    }

    @GetMapping("/{idAluguel}")
    public ResponseEntity<AluguelDTO> procuraAluguelPorId(@PathVariable Long idAluguel) {
        AluguelDTO aluguelResultado = aluguelServiceImpl.procuraAluguelPorId(idAluguel);

        if(Objects.isNull(aluguelResultado)) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(aluguelResultado, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AluguelDTO>> procuraTodosAlugueis() {
        List<AluguelDTO> listaAluguelResultado = aluguelServiceImpl.listarAlugueis();

        if(listaAluguelResultado.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listaAluguelResultado, HttpStatus.OK);
    }

    @GetMapping("/mesa-aluguel")
    public ResponseEntity<AluguelDTO> procuraAluguelPorNumeroDaMesa(@RequestParam Integer numeroMesaAluguel) {
        AluguelDTO aluguelResultado = aluguelServiceImpl.procuraAluguelPorNumeroDaMesa(numeroMesaAluguel);

        if(Objects.isNull(aluguelResultado)) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(aluguelResultado, HttpStatus.OK);
    }

    @GetMapping("/fumo-aluguel")
    public ResponseEntity<List<AluguelDTO>> procuraAluguelPorFumo(@RequestParam Long idFumoAluguel) {
        List<AluguelDTO> listaAluguelResultado = aluguelServiceImpl.procuraAluguelPorFumo(idFumoAluguel);

        if(listaAluguelResultado.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listaAluguelResultado, HttpStatus.OK);
    }

    @GetMapping("/carvao-aluguel")
    public ResponseEntity<List<AluguelDTO>> procuraAluguelPorCarvao(@RequestParam Long idCarvaoAluguel) {
        List<AluguelDTO> listaAluguelResultado = aluguelServiceImpl.procuraAluguelPorCarvao(idCarvaoAluguel);

        if(listaAluguelResultado.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listaAluguelResultado, HttpStatus.OK);
    }

    @GetMapping("/rosh-aluguel")
    public ResponseEntity<List<AluguelDTO>> procuraAluguelPorRosh(@RequestParam Long idRoshAluguel) {
        List<AluguelDTO> listaAluguelResultado = aluguelServiceImpl.procuraAluguelPorRosh(idRoshAluguel);

        if(listaAluguelResultado.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listaAluguelResultado, HttpStatus.OK);
    }

    @GetMapping("/narguile-aluguel")
    public ResponseEntity<List<AluguelDTO>> procuraAluguelPorNarguile(@RequestParam Long idNarguileAluguel) {
        List<AluguelDTO> listaAluguelResultado = aluguelServiceImpl.procuraAluguelPorNarguile(idNarguileAluguel);

        if(listaAluguelResultado.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listaAluguelResultado, HttpStatus.OK);
    }

    @GetMapping("/data-aluguel")
    public ResponseEntity<List<AluguelDTO>> procuraAluguelPorData(@RequestParam @JsonFormat(pattern = "dd/MM/yyyy") LocalDate dataAluguel) {
        List<AluguelDTO> listaAluguelResultado = aluguelServiceImpl.procuraAluguelPorData(dataAluguel);

        if(listaAluguelResultado.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listaAluguelResultado, HttpStatus.OK);
    }

    @GetMapping("/hora-aluguel")
    public ResponseEntity<List<AluguelDTO>> procuraAluguelPorDataEHora(@RequestParam @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime dataHoraAluguel) {
        List<AluguelDTO> listaAluguelResultado = aluguelServiceImpl.procuraAluguelPorDataHora(dataHoraAluguel);

        if(listaAluguelResultado.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listaAluguelResultado, HttpStatus.OK);
    }

    @GetMapping("/duracao-aluguel")
    public ResponseEntity<List<AluguelDTO>> procuraAluguelPorDucacao(@RequestParam Duration duracaoMinimaAluguel, @RequestParam Duration duracaoMaximaAluguel) {
        List<AluguelDTO> listaAluguelResultado = aluguelServiceImpl.procuraAluguelPorDuracao(duracaoMinimaAluguel, duracaoMaximaAluguel);

        if(listaAluguelResultado.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listaAluguelResultado, HttpStatus.OK);
    }

    @PutMapping("/{idAluguel}")
    public ResponseEntity<AluguelDTO> atualizaAluguelPorId(@PathVariable Long idAluguel, @RequestBody AluguelDTO aluguelDTO) {
        AluguelDTO aluguelResultado = aluguelServiceImpl.atualizaAluguelPorId(idAluguel, aluguelDTO);

        return new ResponseEntity<>(aluguelResultado, HttpStatus.OK);
    }

    @PutMapping("/atualiza-alugueis")
    public ResponseEntity<Void> atualizaAlugueisAtivos() {
        aluguelServiceImpl.retornaAoEstoqueSuprimentosNaoConsumiveisAposEncerrarAluguel();

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/desativa-aluguel")
    public ResponseEntity<Void> inativaAluguel(@RequestParam Long idAluguel) {
        aluguelServiceImpl.desativarAluguel(idAluguel);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{idAluguel}")
    public ResponseEntity<Void> deletarAluguel(@PathVariable Long idAluguel) {
        aluguelServiceImpl.deletarAluguelPorId(idAluguel);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
