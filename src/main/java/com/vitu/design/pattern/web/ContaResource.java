package com.vitu.design.pattern.web;

import com.vitu.design.pattern.domain.onetomany.biderecional.Conta;
import com.vitu.design.pattern.service.ContaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/conta")
public class ContaResource {

    private final ContaService contaService;

    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarPorId(@PathVariable Long id) {
        log.info("Requisição para buscar conta pelo id: {}", id);
        Conta byId = contaService.findById(id);
        return ResponseEntity.ok(byId);
    }

    @PostMapping
    public ResponseEntity<Conta> criar(@RequestBody Conta conta) {
        log.info("Requisição para criar nova conta: {}", conta);
        Conta save = contaService.save(conta);
        log.info("{}", save);
        return ResponseEntity.status(CREATED).body(save);
    }

}
