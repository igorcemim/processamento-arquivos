package br.com.cemim.analisevendas.service;

import br.com.cemim.analisevendas.domain.Arquivo;
import br.com.cemim.analisevendas.domain.layout.ClienteLayout;
import br.com.cemim.analisevendas.domain.layout.VendaLayout;
import br.com.cemim.analisevendas.domain.layout.VendedorLayout;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LayoutArquivoService {

    private ClienteLayout clienteLayout;
    private VendaLayout vendaLayout;
    private VendedorLayout vendedorLayout;

    public LayoutArquivoService() {
        clienteLayout = new ClienteLayout();
        vendaLayout = new VendaLayout();
        vendedorLayout = new VendedorLayout();
    }

    public Arquivo processar(List<String> linhas) {
        var vendedores = vendedorLayout.processar(linhas);
        var vendas = vendaLayout.processar(linhas);
        var clientes = clienteLayout.processar(linhas);

        return Arquivo.builder()
                .vendas(vendas)
                .vendedores(vendedores)
                .clientes(clientes)
                .build();
    }

}
