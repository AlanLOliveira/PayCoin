package com.example.paycoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.paycoin.database.BancoSQLite;
import com.example.paycoin.models.Usuario;

public class PerfilUser extends AppCompatActivity {
    Button clic_perfil_salvar, clic_perfil_sair, clic_perfil_editar;
    TextView txtv_perfil_nome, txtv_perfil_email, txtv_perfil_senha,
            txtv_perfil_cpf, txtv_perfil_contabancaria, txtv_perfil_valorinicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_user);
        getSupportActionBar().hide();
            id_perfil();

        clic_perfil_salvar = findViewById(R.id.button_perfil_Salvar);
        clic_perfil_editar = findViewById(R.id.button_perfil_Editar);
        clic_perfil_sair = findViewById(R.id.button_perfil_Sair);


        clic_perfil_sair.setOnClickListener(evt->proxima_tela(TelaInicial.class));

        BancoSQLite db = new BancoSQLite(this);

        Usuario perfil = db.selecionarId("1");

        txtv_perfil_nome.setText(perfil.getNome());
        txtv_perfil_email.setText(perfil.getLogin());
        txtv_perfil_senha.setText(perfil.getSenha());
        txtv_perfil_cpf.setText(perfil.getCpf());
        txtv_perfil_contabancaria.setText(perfil.getContaBancaria());
        txtv_perfil_valorinicial.setText(perfil.getValorInicial());



    }
    public void proxima_tela(Class x){
        Intent proxima = new Intent(getApplicationContext(), x);
        startActivity(proxima);
   }

   public void id_perfil(){
       clic_perfil_salvar = findViewById(R.id.button_perfil_Salvar);
       clic_perfil_editar = findViewById(R.id.button_perfil_Editar);
       clic_perfil_sair = findViewById(R.id.button_perfil_Sair);
       txtv_perfil_nome = findViewById(R.id.textView_perfil_Nome);
       txtv_perfil_email = findViewById(R.id.textView_perfil_Email);
       txtv_perfil_senha = findViewById(R.id.textView_perfil_Senha);
       txtv_perfil_cpf = findViewById(R.id.textView_perfil_CPF);
       txtv_perfil_contabancaria = findViewById(R.id.textView_perfil_DadosBancarios);
       txtv_perfil_valorinicial = findViewById(R.id.textView_perfil_ValorInicial);

   }



}