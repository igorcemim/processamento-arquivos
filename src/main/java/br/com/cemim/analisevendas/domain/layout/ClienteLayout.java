package br.com.cemim.analisevendas.domain.layout;

import br.com.cemim.analisevendas.domain.Cliente;

public class ClienteLayout extends AbstractLayout<Cliente> {

    private static final int CAMPO_CNPJ = 1;
    private static final int FIELD_NAME = 2;
    private static final int CAMPO_AREA = 3;

    @Override
    protected Cliente processarLinha(String linha) {
        var campos = linha.split(DELIMITADOR_CAMPOS);

        var cliente = new Cliente();
        cliente.setCnpj(campos[CAMPO_CNPJ]);
        cliente.setNome(campos[FIELD_NAME]);
        cliente.setArea(campos[CAMPO_AREA]);

        return cliente;
    }

    @Override
    public String getCode() {
        return "002";
    }
}
