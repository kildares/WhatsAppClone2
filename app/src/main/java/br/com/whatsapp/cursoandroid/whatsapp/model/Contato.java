package br.com.whatsapp.cursoandroid.whatsapp.model;

/**
 * Created by Kildare Silveira on 16/10/2017.
 */

public class Contato {

    private String Nome;
    private String Email;

    public Contato() {
    }

    private String identificadorUsuario;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getIdentificadorUsuario() {
        return identificadorUsuario;
    }

    public void setIdentificadorUsuario(String identificadorUsuario) {
        this.identificadorUsuario = identificadorUsuario;
    }
}
