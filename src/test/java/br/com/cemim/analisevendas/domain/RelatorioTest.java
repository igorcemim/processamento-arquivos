package br.com.cemim.analisevendas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class RelatorioTest {

    @Test
    public void relatorioDeveTrazerPiorVendedorEsperado() {
        var arquivo = mockArquivo();

        var relatorio = new Relatorio(arquivo);

        var piorVendedorEsperado = "Joao";

        Assertions.assertEquals(piorVendedorEsperado, relatorio.getPiorVendedor());
    }

    @Test
    public void relatorioDeveTrazerVendaMaisCaraEsperada() {
        var arquivo = mockArquivo();

        var relatorio = new Relatorio(arquivo);

        var idVendaMaisCaraEsperada = 222L;

        Assertions.assertEquals(idVendaMaisCaraEsperada, relatorio.getIdVendaMaisCara());
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
