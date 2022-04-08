package com.example.paycoin.pagar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.paycoin.R;

public class QRCode extends AppCompatActivity {

    ImageButton clic_voltarescolhametodo;
    ImageView clic_executarQRCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        getSupportActionBar().hide();

        clic_voltarescolhametodo = findViewById(R.id.imageButton_QRCode_VoltarMetodoEscolha);
        clic_executarQRCode = findViewById(R.id.imageView_QRCode_Codigo);

        clic_voltarescolhametodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volt5 = new Intent(getApplicationContext(), Pagar.class);
                startActivity(volt5);
            }
        });

        clic_executarQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qrcod1 = new Intent(getApplicationContext(), DadosTransacao.class);
                startActivity(qrcod1);
            }
        });
    }
}