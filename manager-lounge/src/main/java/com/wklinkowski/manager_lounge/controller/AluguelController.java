package com.wklinkowski.manager_lounge.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wklinkowski.manager_lounge.dtos.request.AluguelRequest;
import com.wklinkowski.manager_lounge.dtos.response.AluguelResponse;
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
    public ResponseEntity<AluguelResponse> criarAluguel(@Valid @RequestBody AluguelRequest aluguelRequest) {
        AluguelResponse aluguelResultado = aluguelServiceImpl.criarAluguel(aluguelRequest);

        return new ResponseEntity<>(aluguelResultado, HttpStatus.CREATED);
    }

    @GetMapping("/{idAluguel}")
    public ResponseEntity<AluguelResponse> procuraAluguelPorId(@PathVariable Long idAluguel) {
        AluguelResponse aluguelResultado = aluguelServiceImpl.procuraAluguelPorId(idAluguel);

        if(Objects.isNull(aluguelResultado)) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(aluguelResultado, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AluguelResponse>> procuraTodosAlugueis() {
        List<AluguelResponse> listaAluguelResultado = aluguelServiceImpl.listarAlugueis();

        if(listaAluguelResultado.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listaAluguelResultado, HttpStatus.OK);
    }

    @GetMapping("/mesa-aluguel")
    public ResponseEntity<AluguelResponse> procuraAluguelPorNumeroDaMesa(@RequestParam Integer numeroMesaAluguel) {
        AluguelResponse aluguelResultado = aluguelServiceImpl.procuraAluguelPorNumeroDaMesa(numeroMesaAluguel);

        if(Objects.isNull(aluguelResultado)) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(aluguelResultado, HttpStatus.OK);
    }

    @GetMapping("/fumo-aluguel")
    public ResponseEntity<List<AluguelResponse>> procuraAluguelPorFumo(@RequestParam Long idFumoAluguel) {
        List<AluguelResponse> listaAluguelResultado = aluguelServiceImpl.procuraAluguelPorFumo(idFumoAluguel);

        if(listaAluguelResultado.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listaAluguelResultado, HttpStatus.OK);
    }

    @GetMapping("/carvao-aluguel")
    public ResponseEntity<List<AluguelResponse>> procuraAluguelPorCarvao(@RequestParam Long idCarvaoAluguel) {
        List<AluguelResponse> listaAluguelResultado = aluguelServiceImpl.procuraAluguelPorCarvao(idCarvaoAluguel);

        if(listaAluguelResultado.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listaAluguelResultado, HttpStatus.OK);
    }

    @GetMapping("/rosh-aluguel")
    public ResponseEntity<List<AluguelResponse>> procuraAluguelPorRosh(@RequestParam Long idRoshAluguel) {
        List<AluguelResponse> listaAluguelResultado = aluguelServiceImpl.procuraAluguelPorRosh(idRoshAluguel);

        if(listaAluguelResultado.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listaAluguelResultado, HttpStatus.OK);
    }

    @GetMapping("/narguile-aluguel")
    public ResponseEntity<List<AluguelResponse>> procuraAluguelPorNarguile(@RequestParam Long idNarguileAluguel) {
        List<AluguelResponse> listaAluguelResultado = aluguelServiceImpl.procuraAluguelPorNarguile(idNarguileAluguel);

        if(listaAluguelResultado.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listaAluguelResultado, HttpStatus.OK);
    }

    @GetMapping("/data-aluguel")
    public ResponseEntity<List<AluguelResponse>> procuraAluguelPorData(@RequestParam @JsonFormat(pattern = "dd/MM/yyyy") LocalDate dataAluguel) {
        List<AluguelResponse> listaAluguelResultado = aluguelServiceImpl.procuraAluguelPorData(dataAluguel);

        if(listaAluguelResultado.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listaAluguelResultado, HttpStatus.OK);
    }

    @GetMapping("/hora-aluguel")
    public ResponseEntity<List<AluguelResponse>> procuraAluguelPorDataEHora(@RequestParam @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime dataHoraAluguel) {
        List<AluguelResponse> listaAluguelResultado = aluguelServiceImpl.procuraAluguelPorDataHora(dataHoraAluguel);

        if(listaAluguelResultado.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listaAluguelResultado, HttpStatus.OK);
    }

    @GetMapping("/duracao-aluguel")
    public ResponseEntity<List<AluguelResponse>> procuraAluguelPorDucacao(@RequestParam Duration duracaoMinimaAluguel, @RequestParam Duration duracaoMaximaAluguel) {
        List<AluguelResponse> listaAluguelResultado = aluguelServiceImpl.procuraAluguelPorDuracao(duracaoMinimaAluguel, duracaoMaximaAluguel);

        if(listaAluguelResultado.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listaAluguelResultado, HttpStatus.OK);
    }

    @PutMapping("/{idAluguel}")
    public ResponseEntity<AluguelResponse> atualizaAluguelPorId(@PathVariable Long idAluguel, @RequestBody AluguelRequest aluguelRequest) {
        AluguelResponse aluguelResultado = aluguelServiceImpl.atualizaAluguelPorId(idAluguel, aluguelRequest);

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
