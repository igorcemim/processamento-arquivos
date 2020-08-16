package br.com.cemim.analisevendas.domain.layout;

import br.com.cemim.analisevendas.domain.ItemVenda;
import br.com.cemim.analisevendas.domain.Venda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VendaLayout extends AbstractLayout<Venda> {

    private static final int CAMPO_VENDA_ID = 1;
    private static final int CAMPO_ITENS = 2;
    private static final int CAMPO_NOME_VENDEDOR = 3;

    private static final int CAMPO_ITEM_ID = 0;
    private static final int CAMPO_ITEM_QUANTIDADE = 1;
    private static final int CAMPO_ITEM_PRECO = 2;

    private static final String SEPARADOR_ITEM_VENDA = ",";
    private static final String SEPARADOR_CAMPO_ITEM_VENDA = "-";

    @Override
    protected Venda processarLinha(String linha) {
        var campos = linha.split(DELIMITADOR_CAMPOS);

        var rawItensVenda = campos[CAMPO_ITENS].substring(1, campos[CAMPO_ITENS].length() - 1);

        var itensVenda = Arrays.stream(rawItensVenda.split(SEPARADOR_ITEM_VENDA))
                .map(rawItem -> rawItem.split(SEPARADOR_CAMPO_ITEM_VENDA))
                .map(this::criarItemVenda)
                .collect(Collectors.toList());

        return criarVenda(campos, itensVenda);
    }

    private Venda criarVenda(String[] campos, List<ItemVenda> itens) {
        var venda = new Venda();
        venda.setId(Long.parseLong(campos[CAMPO_VENDA_ID]));
        venda.setNomeVendedor(campos[CAMPO_NOME_VENDEDOR]);
        venda.setItens(itens);
        return venda;
    }

    private ItemVenda criarItemVenda(String[] campos) {
        var item = new ItemVenda();
        item.setId(Long.parseLong(campos[CAMPO_ITEM_ID]));
        item.setQuantidade(Integer.parseInt(campos[CAMPO_ITEM_QUANTIDADE]));
        item.setPreco(new BigDecimal(campos[CAMPO_ITEM_PRECO]));
        return item;
    }

    @Override
    public String getCode() {
        return "003";
    }
}
