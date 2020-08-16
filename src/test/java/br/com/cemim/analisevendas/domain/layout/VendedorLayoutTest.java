package br.com.cemim.analisevendas.domain.layout;

import br.com.cemim.analisevendas.domain.Vendedor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class VendedorLayoutTest {

    @Test
    public void deveRetornarVendedorComOsDadosDaLinha() {
        Vendedor vendedorEsperado = new Vendedor();
        vendedorEsperado.setSalario(new BigDecimal("50000"));
        vendedorEsperado.setCpf("1234567891234");
        vendedorEsperado.setNome("Pedro");

        List<Vendedor> vendedores = new VendedorLayout().processar(Arrays.asList("001ç1234567891234çPedroç50000"));

        Assertions.assertEquals(Arrays.asList(vendedorEsperado), vendedores);
    }

}
