package br.com.cemim.analisevendas.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemVenda {
    private Long id;
    private Integer quantidade;
    private BigDecimal preco;

    public BigDecimal valorTotal() {
        return preco.multiply(BigDecimal.valueOf(quantidade));
    }
}
