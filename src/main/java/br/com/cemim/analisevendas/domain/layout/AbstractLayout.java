package br.com.cemim.analisevendas.domain.layout;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractLayout<T> implements Layout<T> {

    private static final int CODIGO_LAYOUT_INICIO = 0;
    private static final int CODIGO_LAYOUT_FIM = 3;

    protected final String DELIMITADOR_CAMPOS = "ç";

    protected abstract T processarLinha(String linha);

    private String getCodigoLayout(String linha) {
        return linha.substring(CODIGO_LAYOUT_INICIO, CODIGO_LAYOUT_FIM);
    }

    public List<T> processar(List<String> linhas) {
        return linhas.stream()
                .filter(linha -> getCode().equals(getCodigoLayout(linha)))
                .map(this::processarLinha)
                .collect(Collectors.toList());
    }

}
