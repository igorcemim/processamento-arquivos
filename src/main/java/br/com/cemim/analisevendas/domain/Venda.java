package br.com.cemim.analisevendas.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Venda {
    private Long id;
    private List<ItemVenda> itens;
    private String nomeVendedor;

    public BigDecimal valorTotal() {
        return itens.stream()
                .map(ItemVenda::valorTotal)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
