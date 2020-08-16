package br.com.cemim.analisevendas.messaging.consumer;

import br.com.cemim.analisevendas.config.JmsConfig;
import br.com.cemim.analisevendas.messaging.message.ArquivoMessage;
import br.com.cemim.analisevendas.service.ArquivoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ArquivoConsumer {

    private final ArquivoService arquivoService;

    @JmsListener(destination = JmsConfig.ARQUIVO_QUEUE, containerFactory = "defaultContainerFactory")
    public void receiveMessage(@Payload ArquivoMessage arquivo) {
        log.info("Mensagem recebida: {}", arquivo);
        arquivoService.processar(arquivo.getCaminho());
        arquivoService.marcarProcessado(arquivo.getCaminho());
    }
}
