package br.com.cemim.analisevendas.integration;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class FileProcessor implements Processor {

    private final FileLockResolver fileLockResolver;

    @Override
    public void process(Exchange exchange) throws Exception {
        var caminhoAbsoluto = exchange.getMessage()
                .getHeader("CamelFileAbsolutePath")
                .toString();

        log.info("Novo arquivo detectado {}", caminhoAbsoluto);
        fileLockResolver.resolve(caminhoAbsoluto);
    }
}
