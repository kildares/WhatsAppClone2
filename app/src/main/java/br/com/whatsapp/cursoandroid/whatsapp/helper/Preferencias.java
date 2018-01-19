package br.com.whatsapp.cursoandroid.whatsapp.helper;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by Kildare Silveira on 28/09/2017.
 */

public class Preferencias {

    private Context contexto;
    private SharedPreferences preferences;
    private static final String NOME_ARQUIVO="whatsapp.preferencias";
    private static final int MODE =0;
    private SharedPreferences.Editor editor;
    private String CHAVE_IDENTIFICADOR = "identificadorUsuarioLogado";
    private String CHAVE_NOME = "nomeUsuarioLogado";

    public Preferencias (Context contextoParametro)
    {
        this.contexto=contextoParametro;
        this.preferences = contexto.getSharedPreferences(NOME_ARQUIVO,MODE);
        this.editor = preferences.edit();
    }

    public void salvarDados(String identificadorUsuario,String nomeUsuario)
    {

        editor.putString(CHAVE_IDENTIFICADOR,identificadorUsuario);
        editor.putString(CHAVE_NOME,nomeUsuario);
        editor.commit();
    }

    public String getIdentificador(){
        return preferences.getString(CHAVE_IDENTIFICADOR,null);
    }
    public String getNome(){
        return preferences.getString(CHAVE_NOME,null);
    }

}
