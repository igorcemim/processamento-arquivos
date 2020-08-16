package br.com.cemim.analisevendas.domain.enumeration;

import lombok.Getter;

@Getter
public enum StatusEnum {
    AGUARDANDO("AGUARDANDO"),
    PROCESSADO("PROCESSADO");

    private String status;

    StatusEnum(String status) {
        this.status = status;
    }

}
