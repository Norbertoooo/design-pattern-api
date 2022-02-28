package com.vitu.design.pattern.services;

import com.vitu.design.pattern.domain.onetomany.biderecional.Conta;
import com.vitu.design.pattern.domain.onetomany.biderecional.Historico;
import com.vitu.design.pattern.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository contaRepository;

    public Conta save(Conta conta) {

        Historico historico = Historico.builder()
                .nome("criado")
                .conta(conta)
                .build();

        conta.getHistorico().add(historico);
        log.info("Salvando conta: {}", conta);
        return contaRepository.save(conta);
    }

    public Conta findById(Long id) {
        return contaRepository.findById(id).orElseThrow();
    }

}
