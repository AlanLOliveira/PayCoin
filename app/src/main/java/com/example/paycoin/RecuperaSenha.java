package com.example.paycoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.paycoin.cadastro.MainActivity;

public class RecuperaSenha extends AppCompatActivity {

    Button clic_enviar_emailrecuperacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recupera_senha);
        getSupportActionBar().hide();

        clic_enviar_emailrecuperacao = findViewById(R.id.button_RecuperaSenha_EnviarTelaLogin);
        clic_enviar_emailrecuperacao.setOnClickListener(evt->next(MainActivity.class));

    }

    public void next (Class x){
        Intent login = new Intent(getApplicationContext(), x);
        startActivity(login);
        Toast.makeText(this, "Vá para sua caixa de mensagem", Toast.LENGTH_SHORT).show();

    }
}