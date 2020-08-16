package br.com.cemim.analisevendas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemVenda {
    private Long id;
    private Integer quantidade;
    private BigDecimal preco;

    public BigDecimal valorTotal() {
        return preco.multiply(BigDecimal.valueOf(quantidade));
    }
}
