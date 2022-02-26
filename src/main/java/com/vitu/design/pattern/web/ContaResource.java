package com.vitu.design.pattern.web;

import com.vitu.design.pattern.domain.Conta;
import com.vitu.design.pattern.services.ContaService;
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
    public ResponseEntity<Conta> getById(@PathVariable Long id) {
        log.info("Request to get conta by id: {}", id);
        Conta byId = contaService.findById(id);
        return ResponseEntity.ok(byId);
    }

    @PostMapping
    public ResponseEntity<Conta> create(@RequestBody Conta conta) {
        log.info("Request to create new conta: {}", conta);
        Conta save = contaService.save(conta);
        log.info("{}", save);
        return ResponseEntity.status(CREATED).body(save);
    }

}
