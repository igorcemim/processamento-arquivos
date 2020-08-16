package br.com.cemim.analisevendas.domain.layout;

import java.util.List;

public interface Layout<T> {

    List<T> processar(List<String> linhas);

    String getCode();

}
