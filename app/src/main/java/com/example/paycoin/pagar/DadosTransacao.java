package com.example.paycoin.pagar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.paycoin.R;

public class DadosTransacao extends AppCompatActivity {

    ImageButton clic_dadostransacao_voltartelainicial;
    Button clic_dadostransacao_codbarras;
    ImageView clic_dadostransacao_digital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_transacao);
        getSupportActionBar().hide();

        clic_dadostransacao_codbarras = findViewById(R.id.button_DadosTransacao_AutorizarPagamento);
        clic_dadostransacao_voltartelainicial = findViewById(R.id.imageButton_DadosTransacao_VoltarTelaInicial);
        clic_dadostransacao_digital = findViewById(R.id.imageView_DadosTransacao_Digital);

        clic_dadostransacao_codbarras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent autoriz = new Intent(getApplicationContext(), TransacaoConcluida.class);
                startActivity(autoriz);
            }
        });
        clic_dadostransacao_voltartelainicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent volt3 = new Intent(getApplicationContext(), CodBarras.class);
              startActivity(volt3);
            }
        });

        clic_dadostransacao_digital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent autoriz07 = new Intent(getApplicationContext(), TransacaoConcluida.class);
                startActivity(autoriz07);
            }
        });

    }
}