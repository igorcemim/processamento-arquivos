package br.com.cemim.analisevendas.domain.layout;

import br.com.cemim.analisevendas.domain.Vendedor;

import java.math.BigDecimal;

public class VendedorLayout extends AbstractLayout<Vendedor> {

    private static final int CAMPO_CPF = 1;
    private static final int CAMPO_NOME = 2;
    private static final int CAMPO_SALARIO = 3;

    @Override
    protected Vendedor processarLinha(String linha) {
        String[] campos = linha.split(DELIMITADOR_CAMPOS);
        Vendedor vendedor = new Vendedor();
        vendedor.setCpf(campos[CAMPO_CPF]);
        vendedor.setNome(campos[CAMPO_NOME]);
        vendedor.setSalario(new BigDecimal(campos[CAMPO_SALARIO]));
        return vendedor;
    }

    @Override
    public String getCode() {
        return "001";
    }
}
