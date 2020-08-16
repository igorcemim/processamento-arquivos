package br.com.cemim.analisevendas.integration;

import br.com.cemim.analisevendas.messaging.message.ArquivoMessage;
import br.com.cemim.analisevendas.messaging.producer.ArquivoProducer;
import br.com.cemim.analisevendas.repository.ArquivoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class FileLockResolverTest {

    @InjectMocks
    private FileLockResolver fileLockResolver;

    @Mock
    private ArquivoRepository arquivoRepository;

    @Mock
    private ArquivoProducer arquivoProducer;

    @Test
    public void deveEnviarMensagemParaArquivoNovo() {
        fileLockResolver.resolve("teste.dat");

        var argumentoEsperado = new ArquivoMessage();
        argumentoEsperado.setCaminho("teste.dat");

        verify(arquivoProducer).enviar(argumentoEsperado);
    }

    @Test
    public void naoDeveEnviarMensagemParaArquivoExistente() {
        Mockito.when(arquivoRepository.save(any()))
                .thenThrow(DataIntegrityViolationException.class);

        fileLockResolver.resolve("teste.dat");

        verify(arquivoProducer, never()).enviar(any());
    }


}
