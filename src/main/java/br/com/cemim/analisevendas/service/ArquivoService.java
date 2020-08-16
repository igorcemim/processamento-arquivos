package br.com.cemim.analisevendas.service;

import br.com.cemim.analisevendas.domain.enumeration.StatusEnum;
import br.com.cemim.analisevendas.domain.exception.UnexpectedException;
import br.com.cemim.analisevendas.repository.ArquivoRepository;
import br.com.cemim.analisevendas.util.FileReader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
@AllArgsConstructor
public class ArquivoService {

    private final LayoutArquivoService layoutArquivoService;
    private final RelatorioService relatorioService;
    private final ArquivoRepository arquivoRepository;
    private final FileReader fileReader;
    private static final String DELIMITADOR_LINHA = "\n";

    public void processar(String caminho) {
        try {
            var conteudo = fileReader.readFrom(caminho);
            var linhas = Arrays.asList(conteudo.split(DELIMITADOR_LINHA));
            var arquivo = layoutArquivoService.processar(linhas);
            relatorioService.emitir(arquivo);
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
