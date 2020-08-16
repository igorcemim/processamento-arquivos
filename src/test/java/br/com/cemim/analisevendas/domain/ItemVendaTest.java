package br.com.cemim.analisevendas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ItemVendaTest {

    @Test
    public void deveRetornarValorTotalDoItem() {
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setQuantidade(2);
        itemVenda.setPreco(new BigDecimal("10.50"));

        BigDecimal valorEsperado = new BigDecimal("21.00");

        Assertions.assertEquals(valorEsperado, itemVenda.valorTotal());
    }

}
