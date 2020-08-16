package br.com.cemim.analisevendas.messaging.producer;

import br.com.cemim.analisevendas.config.JmsConfig;
import br.com.cemim.analisevendas.messaging.message.ArquivoMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class ArquivoProducer {

    private final JmsTemplate jmsTemplate;

    public void enviar(ArquivoMessage arquivo) {
        log.info("Enviando mensagem: {}", arquivo);
        jmsTemplate.convertAndSend(JmsConfig.ARQUIVO_QUEUE, arquivo);
    }
}