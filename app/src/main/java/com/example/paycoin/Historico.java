package com.example.paycoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class Historico extends AppCompatActivity {

    ImageButton clic_historico_telaprincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);
        getSupportActionBar().hide();

        clic_historico_telaprincipal = findViewById(R.id.imageButton_Historico_TelaPrincipal);
        clic_historico_telaprincipal.setOnClickListener(evt-> home(TelaInicial.class));


    }
    public void home (Class x){
        Intent home2 = new Intent(getApplicationContext(), x);
        startActivity(home2);

    }
}