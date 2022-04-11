package com.example.paycoin.pagar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.paycoin.R;
import com.example.paycoin.TelaInicial;
import com.example.paycoin.deposito.Depositar;

public class Pagar extends AppCompatActivity {

    ImageButton clic_voltar_telaprincipal;
    Button clic_pagar_depositostransferencia;
    Button clic_digitar_codigobarras;
    Button clic_escanear_qrcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar);
        getSupportActionBar().hide();

        clic_pagar_depositostransferencia = findViewById(R.id.button_Pagar_DepositosTransferencia);
        clic_pagar_depositostransferencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scaner = new Intent(getApplicationContext(), Depositar.class);
                startActivity(scaner);
            }
        });

        clic_voltar_telaprincipal = findViewById(R.id.imageButton_Pagar_TelaPrincipal);
        clic_voltar_telaprincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volt1 = new Intent(getApplicationContext(), TelaInicial.class);
                startActivity(volt1);
            }
        });

        clic_digitar_codigobarras = findViewById(R.id.button_Pagar_DigiteCodigoBarras);
        clic_digitar_codigobarras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent digitcod = new Intent(getApplicationContext(), CodBarrasDigit.class);
                startActivity(digitcod);
            }
        });



    }
}