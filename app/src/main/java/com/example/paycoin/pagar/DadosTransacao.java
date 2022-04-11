package com.example.paycoin.pagar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.paycoin.R;

public class DadosTransacao extends AppCompatActivity {

    ImageButton imagebutton_dadostransacao_voltartelainicial;
    Button button_dadostransacao_codbarras;
    TextView textview_dadostransacao_dadosfavorecido;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_transacao);
        getSupportActionBar().hide();



        textview_dadostransacao_dadosfavorecido = findViewById(R.id.textView_DadosTransacao_DadosFavorecido);
        button_dadostransacao_codbarras = findViewById(R.id.button_DadosTransacao_AutorizarPagamento);
        imagebutton_dadostransacao_voltartelainicial = findViewById(R.id.imageButton_DadosTransacao_VoltarTelaInicial);


        button_dadostransacao_codbarras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent autoriz = new Intent(getApplicationContext(), TransacaoConcluida.class);
                startActivity(autoriz);
            }
        });
        imagebutton_dadostransacao_voltartelainicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent volt3 = new Intent(getApplicationContext(), CodBarras.class);
              startActivity(volt3);
            }
        });


    }
}