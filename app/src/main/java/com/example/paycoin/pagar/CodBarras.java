package com.example.paycoin.pagar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.paycoin.R;

public class CodBarras extends AppCompatActivity {

 Button clic_CodBarras_escanear;
 ImageButton clic_CodBarras_Voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod_barras);
        getSupportActionBar().hide();

        clic_CodBarras_escanear = findViewById(R.id.button_CodBarras_Escanear);
        clic_CodBarras_Voltar = findViewById((R.id.imageButton_CodBarras_Voltar));


        clic_CodBarras_Voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pagar_Home = new Intent(getApplicationContext(), Pagar.class);
                startActivity(pagar_Home);
            }
        });

        clic_CodBarras_escanear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent escanear_CodBarras = new Intent(getApplicationContext(), DadosTransacao.class);
                startActivity(escanear_CodBarras);
            }
        });

    }
}