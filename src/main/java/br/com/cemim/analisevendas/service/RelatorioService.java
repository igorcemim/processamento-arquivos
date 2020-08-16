package br.com.cemim.analisevendas.service;

import br.com.cemim.analisevendas.domain.Arquivo;
import br.com.cemim.analisevendas.domain.Relatorio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RelatorioService {

    public void emitir(Arquivo arquivo) {
        Relatorio relatorio = new Relatorio(arquivo);
        log.info("Relatório emitido: {}", relatorio);
    }

}
