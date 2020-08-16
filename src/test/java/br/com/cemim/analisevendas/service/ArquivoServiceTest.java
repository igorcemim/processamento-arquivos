package br.com.cemim.analisevendas.service;

import br.com.cemim.analisevendas.domain.enumeration.StatusEnum;
import br.com.cemim.analisevendas.entity.ArquivoEntity;
import br.com.cemim.analisevendas.repository.ArquivoRepository;
import br.com.cemim.analisevendas.util.FileReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ArquivoServiceTest {

    @InjectMocks
    private ArquivoService arquivoService;
    @Mock
    private LayoutArquivoService layoutArquivoService;
    @Mock
    private RelatorioService relatorioService;
    @Mock
    private ArquivoRepository arquivoRepository;
    @Mock
    private FileReader fileReader;

    @Test
    public void deveMarcarArquivoComoProcessado() {
        when(arquivoRepository.findByCaminho("teste.dat"))
                .thenReturn(new ArquivoEntity());

        arquivoService.marcarProcessado("teste.dat");

        ArquivoEntity arquivoEsperado = new ArquivoEntity();
        arquivoEsperado.setStatus(StatusEnum.PROCESSADO.getStatus());

        verify(arquivoRepository).save(arquivoEsperado);
    }

    @Test
    public void deveProcessarUmaListaDeLinhas() throws IOException {
        when(fileReader.readFrom("teste.dat"))
                .thenReturn("teste1\nteste2");

        arquivoService.processar("teste.dat");

        List<String> linhasEsperadas = Arrays.asList("teste1", "teste2");
        verify(layoutArquivoService).processar(linhasEsperadas);
    }

}
