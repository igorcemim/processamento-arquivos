package br.com.cemim.analisevendas.integration;

import br.com.cemim.analisevendas.domain.enumeration.StatusEnum;
import br.com.cemim.analisevendas.entity.ArquivoEntity;
import br.com.cemim.analisevendas.messaging.message.ArquivoMessage;
import br.com.cemim.analisevendas.messaging.producer.ArquivoProducer;
import br.com.cemim.analisevendas.repository.ArquivoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class FileLockResolver {

    private final ArquivoRepository arquivoRepository;
    private final ArquivoProducer arquivoProducer;

    public void resolve(String caminhoAbsoluto) {
        try {
            log.info("Criando lock para o arquivo {}", caminhoAbsoluto);

            var arquivo = new ArquivoEntity();
            arquivo.setCaminho(caminhoAbsoluto);
            arquivo.setStatus(StatusEnum.AGUARDANDO.getStatus());
            arquivoRepository.save(arquivo);

            var arquivoMessage = new ArquivoMessage();
            arquivoMessage.setCaminho(caminhoAbsoluto);
            arquivoProducer.enviar(arquivoMessage);
        } catch (DataIntegrityViolationException e) {
            log.info("Um lock já foi criado para o arquivo {}. Ignorando.", caminhoAbsoluto);
        }
    }
}
