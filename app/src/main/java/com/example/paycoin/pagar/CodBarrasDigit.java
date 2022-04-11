package com.example.paycoin.pagar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paycoin.R;

public class CodBarrasDigit extends AppCompatActivity {

    Button button_codbarradigit_confirmarcodbarras,button_codbarradigit_confirmardados;
    ImageButton imagebutton_codbarradigitavel_metodopagamento;
    TextView txtv_codbarrasdigitavel_vencimento,
             txtv_codbarrasdigitavel_valor,
             txtv_codbarrasdigitavel_favorecido,
             txtv_codbarrasdigitavel_datapagamento;
    EditText edittext_codbarradigitavel_codbarrasd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod_barras_digit);
        getSupportActionBar().hide();

        ids_CodBarras();

        button_codbarradigit_confirmarcodbarras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              codbarras();
                            }
        });
        imagebutton_codbarradigitavel_metodopagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volt6 = new Intent(getApplicationContext(), Pagar.class);
                startActivity(volt6);
            }
        });

    }
    public void codbarras(){
        String codbarraum = "123456789101";
        String codbarradois = "123456789102";
        String CodigoBarras = edittext_codbarradigitavel_codbarrasd.getText().toString();

        if (CodigoBarras.equals(codbarraum)){
            Toast.makeText(this, " Confirme o Valor do Pagamento e Digite sua senha", Toast.LENGTH_LONG).show();
            txtv_codbarrasdigitavel_favorecido.setText("Favorecido: Fast Shop");
            txtv_codbarrasdigitavel_vencimento.setText("Data Vencimento: 11/04/2022");
            txtv_codbarrasdigitavel_valor.setText("Valor: R$ 500,00");
            txtv_codbarrasdigitavel_datapagamento.setText("Data Pagamento: 11/04/2020");


        }else if (CodigoBarras.equals(codbarradois)){
            Toast.makeText(this, " Confirme o Valor do Pagamento e Digite sua senha", Toast.LENGTH_LONG).show();
            txtv_codbarrasdigitavel_favorecido.setText("Favorecido: Casas Bahia");
            txtv_codbarrasdigitavel_vencimento.setText("Data Vencimento: 11/04/2022");
            txtv_codbarrasdigitavel_valor.setText("Valor: 180,00");
            txtv_codbarrasdigitavel_datapagamento.setText("Data Pagamento: 11/04/2020");

        }else{
            Toast.makeText(this, " Código de Barras Inválido", Toast.LENGTH_LONG).show();
        }
        button_codbarradigit_confirmardados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dadostransacao = new Intent(getApplicationContext(), TransacaoConcluida.class);
                startActivity(dadostransacao);

            }
        });

    }

    public void ids_CodBarras(){
        imagebutton_codbarradigitavel_metodopagamento = findViewById(R.id.imageButton_CodBarrasDigitavel_MetodoPagamento);
        button_codbarradigit_confirmardados = findViewById(R.id.button_CodBarraDigitavel_ConfirmarDadosPagamentos);
        button_codbarradigit_confirmarcodbarras = findViewById(R.id.button_CodBarraDigit_ConfirmarCodBarras);
        txtv_codbarrasdigitavel_vencimento = findViewById(R.id.textView_CodBarraDigitar_Vencimento);
        txtv_codbarrasdigitavel_valor = findViewById(R.id.textView_CodBarraDigitar_ValorPagamento);
        txtv_codbarrasdigitavel_favorecido = findViewById(R.id.textView_CodBarraDigitar_Favorecido);
        txtv_codbarrasdigitavel_datapagamento = findViewById(R.id.textView_CodBarraDigitar_DataPagamento);
        edittext_codbarradigitavel_codbarrasd = findViewById(R.id.editText_CodBarraDigit_CampoD);


    }

}