package com.example.paycoin.cadastro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paycoin.R;
import com.example.paycoin.TelaInicial;
import com.example.paycoin.database.BancoSQLite;
import com.example.paycoin.models.Usuario;

public class CadastroUser extends AppCompatActivity {

    Button clic_cadastraruser_salvar, clic_cadastraruser_cancelar;
    EditText edit_cadastraruser_nome, edit_cadastraruser_email, edit_cadastraruser_valorinicial,
            edit_cadastraruser_senha, edit_cadastraruser_contabancaria,
            edit_cadastraruser_cpf;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_user);
        getSupportActionBar().hide();

//        BancoSQLite db2 = new BancoSQLite(this);
//        Usuario perfiluser = db2.selecionarId("1");
//        edit_cadastraruser_nome.setHint(perfiluser.getNome());





        ids_cadastro();


        clic_cadastraruser_cancelar.setOnClickListener(view -> {
            Intent it = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(it);
        });

        clic_cadastraruser_salvar.setOnClickListener(view -> {
           if(edit_cadastraruser_email.getText().toString().isEmpty() ||
                   edit_cadastraruser_senha.getText().toString().isEmpty()){
               Toast.makeText(this, "Inserir dados!", Toast.LENGTH_LONG).show();
            }else {

                BancoSQLite db = new BancoSQLite(this);

                if (db.inserirUsuario(
                        new Usuario(
                                edit_cadastraruser_nome.getText().toString(),
                                edit_cadastraruser_email.getText().toString(),
                                edit_cadastraruser_senha.getText().toString(),
                               edit_cadastraruser_cpf.getText().toString(),
                               edit_cadastraruser_contabancaria.getText().toString(),
                               edit_cadastraruser_valorinicial.getText().toString()))

                ) {
                    Toast.makeText(this, "Usuário Cadastrado com Sucesso!", Toast.LENGTH_LONG).show();
                    Intent it_tela = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(it_tela);

                } else {
                    Toast.makeText(this, " Não foi possível realizar o cadastro!", Toast.LENGTH_LONG).show();
                }
           }
        });


    }
    public void ids_cadastro() {

        clic_cadastraruser_salvar = findViewById(R.id.button_CadastrarUser_Salvar);
        clic_cadastraruser_cancelar = findViewById(R.id.button_CadastrarUser_Cancelar);
        edit_cadastraruser_nome = findViewById(R.id.edittext_CadastrarUser_Nome);
        edit_cadastraruser_email = findViewById(R.id.editText_CadastrarUser_Email);
        edit_cadastraruser_senha = findViewById(R.id.editText_CadastrarUser_Senha);
        edit_cadastraruser_contabancaria = findViewById(R.id.editText_CadastrarUser_ContaBancaria);
        edit_cadastraruser_cpf = findViewById(R.id.editText_CadastrarUser_CPF);
        edit_cadastraruser_valorinicial = findViewById(R.id.editText_CadastrarUser_ValorInicial);

    }



}



