package com.example.paycoin.pagar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.paycoin.R;
import com.example.paycoin.TelaInicial;

public class TransacaoConcluida extends AppCompatActivity {

    Button button_transacaoconcluida_telainicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transacao_concluida);
        getSupportActionBar().hide();

        button_transacaoconcluida_telainicial = findViewById(R.id.button_TransacaoConcluida_TelaPrincipal);
        button_transacaoconcluida_telainicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeinicial = new Intent(getApplicationContext(), TelaInicial.class);
                startActivity(homeinicial);
            }
        });



    }
}