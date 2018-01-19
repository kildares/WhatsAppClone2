package br.com.whatsapp.cursoandroid.whatsapp.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.database.DatabaseReference;

import br.com.whatsapp.cursoandroid.whatsapp.R;
import br.com.whatsapp.cursoandroid.whatsapp.config.ConfiguracaoFirebase;
import br.com.whatsapp.cursoandroid.whatsapp.helper.Base64Custom;
import br.com.whatsapp.cursoandroid.whatsapp.helper.Preferencias;
import br.com.whatsapp.cursoandroid.whatsapp.model.Usuario;

public class CadastroUsuarioActivity extends AppCompatActivity {

    private EditText nome;
    private EditText email;
    private EditText senha;
    private Button botaoCadastrar;
    private Usuario usuario;

    private FirebaseAuth autenticacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        nome = (EditText)findViewById(R.id.edit_cadastro_nome);
        email = (EditText)findViewById(R.id.edit_cadastro_email);
        senha = (EditText)findViewById(R.id.edit_cadastro_senha);
        botaoCadastrar = (Button) findViewById(R.id.bt_cadastrar);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario = new Usuario();
                usuario.setNome(nome.getText().toString());
                usuario.setEmail(email.getText().toString());
                usuario.setSenha(senha.getText().toString());
                cadastrarUsuario();
            }
        });

    }

    private void cadastrarUsuario()
    {
        autenticacao = ConfiguracaoFirebase.getFirebaseAuth();
        System.out.println("usuario :"+ usuario.getEmail().toString()+"senha: "+usuario.getSenha().toString());
        autenticacao. createUserWithEmailAndPassword(
                usuario.getEmail().toString(),
                usuario.getSenha().toString()

        ).addOnCompleteListener(CadastroUsuarioActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Preferencias preferencias = new Preferencias(CadastroUsuarioActivity.this);
                    String identificadorUsuarioLogado = Base64Custom.codificarBase64(usuario.getEmail());
                    preferencias.salvarDados(identificadorUsuarioLogado,usuario.getNome());

                    Toast.makeText(CadastroUsuarioActivity.this,"SUCESSO AO CADASTRAR USUARIO", Toast.LENGTH_LONG).show();

                    String idUsuario = Base64Custom.codificarBase64(usuario.getEmail());

                    usuario.setId(idUsuario);
                    usuario.Salvar();


                    abrirLoginUsuario();
                }
                else{
                    String erro;
                    try{
                        throw task.getException();
                    }catch(FirebaseAuthWeakPasswordException e){
                        erro = "SENHA FRAC";
                    }catch(FirebaseAuthInvalidCredentialsException e){
                        erro = "email em formato invalido";
                    }catch(FirebaseAuthUserCollisionException e){
                        erro = "email ja cadastrado";
                    }catch(Exception e){
                        erro = "erro";
                    }

                    Toast.makeText(CadastroUsuarioActivity.this,erro, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void abrirLoginUsuario(){
        Intent intent = new Intent(CadastroUsuarioActivity.this,loginActivity.class);
        startActivity(intent);
        finish();
    }


}
