package com.example.paycoin.pagar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.paycoin.R;

public class CodBarrasDigit extends AppCompatActivity {

    Button clic_codbarradigit_confirmar;
    ImageButton clic_codbarradigit_metodoescolha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod_barras_digit);
        getSupportActionBar().hide();

       clic_codbarradigit_confirmar = findViewById(R.id.button_CodBarraDigit_Confirmar);
       clic_codbarradigit_metodoescolha = findViewById(R.id.imageButton_CodBarraDigit_MetodoEscolha);


        clic_codbarradigit_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirma = new Intent(getApplicationContext(), DadosTransacao.class);
                startActivity(confirma);

            }
        });
        clic_codbarradigit_metodoescolha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volt6 = new Intent(getApplicationContext(), Pagar.class);
                startActivity(volt6);
            }
        });

    }
}