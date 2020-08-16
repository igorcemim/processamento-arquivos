package br.com.cemim.analisevendas.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Arquivo {
    private List<Cliente> clientes;
    private List<Venda> vendas;
    private List<Vendedor> vendedores;
}
