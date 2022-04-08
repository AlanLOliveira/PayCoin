package com.example.paycoin.deposito;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paycoin.DadosTransferencia;
import com.example.paycoin.R;
import com.example.paycoin.TelaInicial;
import com.example.paycoin.pagar.DadosTransacao;

import java.lang.reflect.Array;

public class Depositar extends AppCompatActivity {

    ImageButton clic_deposito_voltartelainicial, clic_deposito_convertermoeda;
    Button clic_deposito_finalizartransacao;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depositar);
        getSupportActionBar().hide();

        clic_deposito_finalizartransacao = findViewById(R.id.button_Deposito_ConcluirTransação);
        clic_deposito_voltartelainicial = findViewById(R.id.imageButton_Deposito_VoltarInicial);
        clic_deposito_convertermoeda = findViewById(R.id.imageButton_Deposito_ConverterMoeda);

        clic_deposito_voltartelainicial.setOnClickListener(evt -> proximaTela(TelaInicial.class));
        clic_deposito_finalizartransacao.setOnClickListener(evt-> proximaTela(DadosTransferencia.class));


        Spinner tipo_moedainicial = (Spinner) findViewById(R.id.spinner_Deposito_MoedaIncial);
        ArrayAdapter adapter_moedainicial = ArrayAdapter.createFromResource(this, R.array.moedas,
                R.layout.spinner_estilo);
        adapter_moedainicial.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo_moedainicial.setAdapter(adapter_moedainicial);

        Spinner tipo_moedafinal = (Spinner) findViewById(R.id.spinner_Deposito_MoedaFinal);
        ArrayAdapter adapter_moedafinal = ArrayAdapter.createFromResource(this, R.array.moedas,
                R.layout.spinner_estilo);
        adapter_moedafinal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo_moedafinal.setAdapter(adapter_moedafinal);


        Spinner selecao_bancoinicial = (Spinner) findViewById(R.id.spinner_Deposito_BancoInicial);
        ArrayAdapter adapter_bancoinicial = ArrayAdapter.createFromResource(this, R.array.Bancos, R.layout.spinner_estilo);
        adapter_bancoinicial.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selecao_bancoinicial.setAdapter(adapter_bancoinicial);


        Spinner selecao_tipodeposito = (Spinner) findViewById(R.id.spinner_Deposito_TipoDeposito);
        ArrayAdapter adapter_depositoinicial = ArrayAdapter.createFromResource(this, R.array.Formas_de_depositos, R.layout.spinner_estilo);
        adapter_depositoinicial.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selecao_tipodeposito.setAdapter(adapter_depositoinicial);


    }
    public void proximaTela(Class x) {
        Intent proximatela = new Intent(getApplicationContext(), x);
        startActivity(proximatela);
    }

}
//ImageButton clic_result;
//TextView exibir;
// clic_result = findViewById(R.id.imageBtnConvert);
//        exibir = findViewById(R.id.textView4);
//        digit_valor = findViewById(R.id.digitValor);
//
//        clic_result.setOnClickListener(view -> {
//            //String texto = tipoMoeda.getSelectedItem().toString();
//            String texto = digit_valor.getText().toString();
//            exibir.setText(texto);
//            //exibir.setText(digit_valor.getText().toString());
//        });//