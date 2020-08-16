package br.com.cemim.analisevendas.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Vendedor {
    private String nome;
    private String cpf;
    private BigDecimal salario;
}
