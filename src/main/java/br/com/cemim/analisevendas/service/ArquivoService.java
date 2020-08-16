package br.com.cemim.analisevendas.service;

import br.com.cemim.analisevendas.domain.enumeration.StatusEnum;
import br.com.cemim.analisevendas.domain.exception.UnexpectedException;
import br.com.cemim.analisevendas.repository.ArquivoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
@AllArgsConstructor
public class ArquivoService {

    private final LayoutArquivoService layoutArquivoService;
    private final RelatorioService relatorioService;
    private final ArquivoRepository arquivoRepository;
    private static final String DELIMITADOR_LINHA = "\n";

    public void processar(String caminho) {
        try {
            var bytes = Files.readAllBytes(Path.of(caminho));
            var conteudo = new String(bytes);
            var linhas = Arrays.asList(conteudo.split(DELIMITADOR_LINHA));
            var arquivoDto = layoutArquivoService.processar(linhas);
            relatorioService.emitir(arquivoDto);
        } catch (IOException e) {
            throw new UnexpectedException(e);
        }
    }

    public void marcarProcessado(String caminho) {
        var arquivo = arquivoRepository.findByCaminho(caminho);
        arquivo.setStatus(StatusEnum.PROCESSADO.getStatus());
        arquivoRepository.save(arquivo);
    }

}
