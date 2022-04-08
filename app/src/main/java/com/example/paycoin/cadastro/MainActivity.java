package com.example.paycoin.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
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

    Button clic_login_login, clic_login_cadastrar;
    TextView edit_login_senha, edit_login_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //Esconder action bar
        getSupportActionBar().hide();

        ids_login();

        clic_login_cadastrar.setOnClickListener(view->{
                    Intent it = new Intent(getApplicationContext(), CadastroUser.class );
                    startActivity(it);
                });

        clic_login_login.setOnClickListener(view -> {
            BancoSQLite db = new BancoSQLite(this);

            try{
                Usuario usuario = db.selecionarUsuario(edit_login_email.getText().toString());

                    if (usuario.getSenha().equals(edit_login_senha.getText().toString())){
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
        clic_login_login = findViewById(R.id.button_Login_Login);
        clic_login_cadastrar = findViewById(R.id.button_Login_Cadastrar);
        edit_login_senha = findViewById(R.id.editText_Login_Senha);
        edit_login_email = findViewById(R.id.editText_Login_Email);
    }
    

    
}