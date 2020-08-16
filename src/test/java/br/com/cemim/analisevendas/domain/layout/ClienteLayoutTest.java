package br.com.cemim.analisevendas.domain.layout;

import br.com.cemim.analisevendas.domain.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ClienteLayoutTest {

    @Test
    public void deveRetornarClienteComOsDadosDaLinha() {
        Cliente clienteEsperado = new Cliente();
        clienteEsperado.setCnpj("2345675434544345");
        clienteEsperado.setNome("Jose da Silva");
        clienteEsperado.setArea("Rural");

        List<Cliente> clientes = new ClienteLayout().processar(Arrays.asList("002ç2345675434544345çJose da SilvaçRural"));

        Assertions.assertEquals(Arrays.asList(clienteEsperado), clientes);
    }

}
