package br.com.cemim.analisevendas.service;

import br.com.cemim.analisevendas.config.AppConfig;
import br.com.cemim.analisevendas.domain.Arquivo;
import br.com.cemim.analisevendas.domain.Relatorio;
import br.com.cemim.analisevendas.util.FileWriter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;

@Service
@Slf4j
@AllArgsConstructor
public class RelatorioService {

    private final AppConfig appConfig;
    private final FileWriter fileWriter;

    public void emitir(Arquivo arquivo, String caminho) {
        var relatorio = new Relatorio(arquivo);
        var nomeEntrada = Paths.get(caminho).getFileName();
        var nomeSemExtensao = FilenameUtils.removeExtension(nomeEntrada.toString());
        var filePath = String.format("%s/data/out/%s.done.dat", appConfig.getHomePath(), nomeSemExtensao);
        var path = Paths.get(filePath);

        try {
            fileWriter.write(path, relatorio.toString());
            log.info("Relatório emitido: path: {}, relatorio: {}", path, relatorio);
        } catch (IOException e) {
            log.error("Falha ao emitir o relatório.", e);
        }
    }

}
