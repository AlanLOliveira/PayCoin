package com.example.paycoin.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paycoin.R;
import com.example.paycoin.RecuperaSenha;
import com.example.paycoin.TelaInicial;
import com.example.paycoin.cadastro.CadastroUser;
import com.example.paycoin.database.BancoSQLite;
import com.example.paycoin.deposito.Depositar;
import com.example.paycoin.models.Usuario;

public class MainActivity extends AppCompatActivity {

    Button button_login_login, button_login_cadastrar;
    EditText edittext_login_senha, edittext_login_email;
    TextView textview_login_recuperarsenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //Esconder action bar
        getSupportActionBar().hide();

        ids_login();

        textview_login_recuperarsenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recuperar = new Intent(getApplicationContext(), RecuperaSenha.class);
                startActivity(recuperar);
            }
        });

        button_login_cadastrar.setOnClickListener(view->{
                    Intent it = new Intent(getApplicationContext(), CadastroUser.class );
                    startActivity(it);
                });

        button_login_login.setOnClickListener(view -> {
            BancoSQLite db = new BancoSQLite(this);

            try{
                Usuario usuario = db.selecionarUsuario(edittext_login_email.getText().toString());

                    if (usuario.getSenha().equals(edittext_login_senha.getText().toString())){
                        Intent intent = new Intent(getApplicationContext(), TelaInicial.class);
                        startActivity(intent);

                    }else
                        Toast.makeText(this, "Usuario não cadastrado", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Toast.makeText(this, "Usuario não cadastrado", Toast.LENGTH_SHORT).show();
            }
        });

   }

       public void ids_login(){
        button_login_login = findViewById(R.id.button_Login_Login);
        button_login_cadastrar = findViewById(R.id.button_Login_Cadastrar);
        edittext_login_senha = findViewById(R.id.editText_Login_Senha);
        edittext_login_email = findViewById(R.id.editText_Login_Email);
        textview_login_recuperarsenha = findViewById(R.id.textView_Login_RecuperarSenha);
    }
    

    
}