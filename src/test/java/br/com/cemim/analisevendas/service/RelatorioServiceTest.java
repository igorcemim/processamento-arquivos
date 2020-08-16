package br.com.cemim.analisevendas.service;

import br.com.cemim.analisevendas.config.AppConfig;
import br.com.cemim.analisevendas.domain.Arquivo;
import br.com.cemim.analisevendas.domain.ItemVenda;
import br.com.cemim.analisevendas.domain.Venda;
import br.com.cemim.analisevendas.util.FileWriter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RelatorioServiceTest {

    @InjectMocks
    private RelatorioService relatorioService;
    @Mock
    private AppConfig appConfig;
    @Mock
    private FileWriter fileWriter;

    @Test
    public void deveGerarRelatorioNoCaminhoEsperado() throws IOException {
        when(appConfig.getHomePath())
                .thenReturn("/home/john");

        relatorioService.emitir(mockArquivo(), "/home/john/data/in/teste.dat");

        verify(fileWriter).write(eq(Path.of("/home/john/data/out/teste.done.dat")), any());
    }

    private Arquivo mockArquivo() {
        var venda1 = new Venda();
        venda1.setId(111L);
        venda1.setNomeVendedor("Maria");
        venda1.setItens(Arrays.asList(new ItemVenda(1L, 1, new BigDecimal("5.00"))));

        var venda2 = new Venda();
        venda2.setId(222L);
        venda2.setNomeVendedor("Maria");
        venda2.setItens(Arrays.asList(new ItemVenda(1L, 4, new BigDecimal("5.00"))));

        var venda3 = new Venda();
        venda3.setId(333L);
        venda3.setNomeVendedor("Joao");
        venda3.setItens(Arrays.asList(new ItemVenda(1L, 1, new BigDecimal("4.00"))));

        var vendas = Arrays.asList(venda1, venda2, venda3);

        var arquivo = new Arquivo();
        arquivo.setVendas(vendas);
        arquivo.setClientes(new ArrayList<>());
        arquivo.setVendedores(new ArrayList<>());
        return arquivo;
    }

}
