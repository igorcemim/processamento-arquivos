package br.com.cemim.analisevendas.domain.exception;

public class UnexpectedException extends RuntimeException {
    public UnexpectedException(Throwable cause) {
        super(cause);
    }
}
