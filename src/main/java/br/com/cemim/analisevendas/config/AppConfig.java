package br.com.cemim.analisevendas.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class AppConfig {

    @Value("${home-path}")
    private String homePath;

}
