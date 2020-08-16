package br.com.cemim.analisevendas.domain;

import br.com.cemim.analisevendas.domain.exception.BusinessException;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@ToString
public class Relatorio {

    private Long idVendaMaisCara;
    private String piorVendedor;
    private Integer quantidadeClientes;
    private Integer quantidadeVendedores;

    public Relatorio(Arquivo arquivo) {
        quantidadeClientes = arquivo.getClientes().size();
        quantidadeVendedores = arquivo.getVendedores().size();
        idVendaMaisCara = getIdVendaMaisCara(arquivo);
        piorVendedor = getPiorVendedor(arquivo);
    }

    private Long getIdVendaMaisCara(Arquivo arquivo) {
        return arquivo.getVendas()
                .stream()
                .max(Comparator.comparing(Venda::valorTotal))
                .map(Venda::getId)
                .orElseThrow(() -> new BusinessException("Nenhuma venda no arquivo."));
    }

    private String getPiorVendedor(Arquivo arquivo) {
        return arquivo.getVendas()
                .stream()
                .collect(Collectors.groupingBy(Venda::getNomeVendedor, Collectors.reducing(
                        BigDecimal.ZERO,
                        Venda::valorTotal,
                        BigDecimal::add)
                ))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new BusinessException("Nenhuma venda no arquivo."));
    }

}
