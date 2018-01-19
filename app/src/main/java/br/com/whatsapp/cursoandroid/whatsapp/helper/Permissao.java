package br.com.whatsapp.cursoandroid.whatsapp.helper;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kildare Silveira on 01/10/2017.
 */

public class Permissao {

    public static boolean validaPermissoes(int requestCode, Activity activity, String[] permissoes)
    {
        if(Build.VERSION.SDK_INT >= 23)
        {
            List<String> listaPermssoes = new ArrayList<String>();

            for(String permissao : permissoes){
                Boolean validaPermissao = ContextCompat.checkSelfPermission(activity,permissao) == PackageManager.PERMISSION_GRANTED;
                if(!validaPermissao)
                    listaPermssoes.add(permissao);
            }

            String[] arrayPermissoes = new String[listaPermssoes.size()];
            listaPermssoes.toArray(arrayPermissoes);

            if(listaPermssoes.isEmpty())
                return true;
            ActivityCompat.requestPermissions(activity,arrayPermissoes,1);
        }

        return true;
    }
}
