package br.com.cemim.analisevendas.domain.layout;

import br.com.cemim.analisevendas.domain.ItemVenda;
import br.com.cemim.analisevendas.domain.Venda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class VendaLayoutTest {

    @Test
    public void deveRetornarVendaComOsDadosDaLinha() {
        ItemVenda item1 = new ItemVenda();
        item1.setPreco(new BigDecimal("100"));
        item1.setQuantidade(10);
        item1.setId(1L);

        ItemVenda item2 = new ItemVenda();
        item2.setPreco(new BigDecimal("2.50"));
        item2.setQuantidade(30);
        item2.setId(2L);

        ItemVenda item3 = new ItemVenda();
        item3.setPreco(new BigDecimal("3.10"));
        item3.setQuantidade(40);
        item3.setId(3L);

        Venda vendaEsperada = new Venda();
        vendaEsperada.setNomeVendedor("Pedro");
        vendaEsperada.setId(10L);
        vendaEsperada.setItens(Arrays.asList(item1, item2, item3));

        List<Venda> vendas = new VendaLayout().processar(Arrays.asList("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro"));

        Assertions.assertEquals(Arrays.asList(vendaEsperada), vendas);
    }

}
