package br.com.cadastro.controller.dto;

public class ErroCampo {
    private String campo;
    private String erro;

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }


}
