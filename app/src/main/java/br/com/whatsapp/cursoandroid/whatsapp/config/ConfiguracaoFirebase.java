package br.com.whatsapp.cursoandroid.whatsapp.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Kildare Silveira on 04/10/2017.
 */

public final class ConfiguracaoFirebase {

    private static DatabaseReference refenciaFirebase;
    private static FirebaseAuth auth;

    public static DatabaseReference getFirebase(){

        if(refenciaFirebase == null)
            refenciaFirebase = FirebaseDatabase.getInstance().getReference();
        return refenciaFirebase;
    }

    public static FirebaseAuth getFirebaseAuth()
    {
        if(auth == null)
            auth = FirebaseAuth.getInstance();
        return auth;
    }

}
