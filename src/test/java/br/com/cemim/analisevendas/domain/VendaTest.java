package br.com.cemim.analisevendas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class VendaTest {

    @Test
    public void deveRetornarValorTotalDaVenda() {
        ItemVenda itemVenda1 = new ItemVenda();
        itemVenda1.setPreco(new BigDecimal("1.00"));
        itemVenda1.setQuantidade(2);
        ItemVenda itemVenda2 = new ItemVenda();
        itemVenda2.setPreco(new BigDecimal("5.00"));
        itemVenda2.setQuantidade(1);

        Venda venda = new Venda();
        venda.setItens(Arrays.asList(itemVenda1, itemVenda2));

        BigDecimal valorTotalEsperado = new BigDecimal("7.00");
        BigDecimal valorTotal = venda.valorTotal();

        Assertions.assertEquals(valorTotalEsperado, valorTotal);
    }
}
