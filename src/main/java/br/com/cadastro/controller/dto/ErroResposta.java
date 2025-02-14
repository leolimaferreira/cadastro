package br.com.cadastro.controller.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ErroResposta {
    private int status;
    private String mensagem;
    private List<ErroCampo> erros;

    public ErroResposta(int status, String mensagem, List<ErroCampo> erros) {
        this.status = status;
        this.mensagem = mensagem;
        this.erros = erros;
    }

    public static ErroResposta conflito(String mensagem) {
        return new ErroResposta(HttpStatus.CONFLICT.value(), mensagem, List.of());
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<ErroCampo> getErros() {
        return erros;
    }

    public void setErros(List<ErroCampo> erros) {
        this.erros = erros;
    }
}
