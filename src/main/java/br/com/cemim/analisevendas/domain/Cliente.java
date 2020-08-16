package br.com.cemim.analisevendas.domain;

import lombok.Data;

@Data
public class Cliente {
    private String cnpj;
    private String nome;
    private String area;
}
