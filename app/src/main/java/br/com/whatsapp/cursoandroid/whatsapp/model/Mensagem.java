package br.com.whatsapp.cursoandroid.whatsapp.model;

/**
 * Created by Kildare Silveira on 05/11/2017.
 */

public class Mensagem {

    private String idUsuario;
    private String mensagem;


    public Mensagem() {
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}

