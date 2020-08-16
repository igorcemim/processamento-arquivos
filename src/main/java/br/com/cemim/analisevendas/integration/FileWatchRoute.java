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

    @Override
    public void configure() throws Exception {
        from("file-watch:" + appConfig.getHomePath() + "/data/in?events=CREATE&antInclude=**/*.dat")
                .process(fileProcessor);
    }

}
