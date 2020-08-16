package br.com.cemim.analisevendas;


import br.com.cemim.analisevendas.config.AppConfig;
import br.com.cemim.analisevendas.integration.FileLockResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
@EnableJms
@Slf4j
@AllArgsConstructor
public class AnaliseVendasApplication implements CommandLineRunner {

	private final AppConfig appConfig;
	private final FileLockResolver fileLockResolver;
	private static final String FORMATO_DIRETORIO_ENTRADA = "%s/data/in";

	public static void main(String[] args) {
		SpringApplication.run(AnaliseVendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Files.list(Paths.get(String.format(FORMATO_DIRETORIO_ENTRADA, appConfig.getHomePath())))
				.forEach(e -> fileLockResolver.resolve(e.toString()));
	}
}
