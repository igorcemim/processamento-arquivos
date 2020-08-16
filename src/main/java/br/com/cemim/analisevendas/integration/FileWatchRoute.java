package br.com.cemim.analisevendas.integration;

import br.com.cemim.analisevendas.config.AppConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class FileWatchRoute extends RouteBuilder {

    private final FileProcessor fileProcessor;
    private final AppConfig appConfig;
    private static final String FORMATO_DIRETORIO_ENTRADA = "%s/data/in";

    @Override
    public void configure() throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append("file-watch:");
        builder.append(String.format(FORMATO_DIRETORIO_ENTRADA, appConfig.getHomePath()));
        builder.append("?");
        builder.append("events=CREATE");
        builder.append("&");
        builder.append("antInclude=**/*.dat");

        from(builder.toString()).process(fileProcessor);
    }

}
