package br.com.cadastro.exceptions;

public class RegistroDuplicadoException extends RuntimeException{
    public RegistroDuplicadoException(String message) {
        super(message);
    }
}
