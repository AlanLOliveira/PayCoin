package com.example.paycoin.deposito;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import com.example.paycoin.pagar.Pagar;
import com.example.paycoin.pagar.TransacaoConcluida;

public class Depositar extends AppCompatActivity {

    ImageButton imagebutton_depositar_convertermoeda,imagebutton_deposito_voltarpagar;
    Button button_deposito_concluirtransacao, button_depositar_confirmardados;
    EditText edittxt_depositar_digitarrecebedor, edittxt_depositar_digitarvalor, edittxt_depositar_confirmarvalor;
    Spinner spinner_bancoorigem, spinner_tipodeposito, spinner_moedainicial, spinner_moedafinal;
    TextView txtv_depositar_valorfinal, txtv_depositar_recebedor,txtv_depositar_banco,
            txtv_depositar_agenciaconta,
            txtv_depositar_datatransacao, txtv_depositar_tipodeposito;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depositar);
        getSupportActionBar().hide();

        deposito_id();


       imagebutton_depositar_convertermoeda.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Resultado();
           }
       });

       button_depositar_confirmardados.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dadosTransacoes();
           }
       });


        imagebutton_deposito_voltarpagar.setOnClickListener(evt -> proximaTela(Pagar.class));

        Spinner tipo_moedainicial = (Spinner) findViewById(R.id.spinner_Deposito_MoedaIncial);
        ArrayAdapter<CharSequence> adapter_moedainicial = ArrayAdapter.createFromResource(this, R.array.moedas,
                R.layout.spinner_estilo);
        adapter_moedainicial.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo_moedainicial.setAdapter(adapter_moedainicial);

        Spinner tipo_moedafinal = (Spinner) findViewById(R.id.spinner_Deposito_MoedaFinal);
        ArrayAdapter<CharSequence> adapter_moedafinal = ArrayAdapter.createFromResource(this, R.array.moedas,
                R.layout.spinner_estilo);
        adapter_moedafinal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo_moedafinal.setAdapter(adapter_moedafinal);


        Spinner selecao_bancoinicial = (Spinner) findViewById(R.id.spinner_Deposito_BancoOrigem);
        ArrayAdapter<CharSequence> adapter_bancoinicial = ArrayAdapter.createFromResource(this, R.array.Bancos, R.layout.spinner_estilo);
        adapter_bancoinicial.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selecao_bancoinicial.setAdapter(adapter_bancoinicial);


        Spinner selecao_tipodeposito = (Spinner) findViewById(R.id.spinner_Depositar_TipoDeposito);
        ArrayAdapter<CharSequence> adapter_depositoinicial = ArrayAdapter.createFromResource(this, R.array.Formas_de_depositos, R.layout.spinner_estilo);
        adapter_depositoinicial.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selecao_tipodeposito.setAdapter(adapter_depositoinicial);


    }
    public void proximaTela(Class x) {
        Intent proximatela = new Intent(getApplicationContext(), x);
        startActivity(proximatela);
        }
        public void deposito_id(){
            button_deposito_concluirtransacao = findViewById(R.id.button_Deposito_ConcluirTransacao);
            button_depositar_confirmardados = findViewById(R.id.button_Depositar_ConfirmarDados);
            imagebutton_deposito_voltarpagar = findViewById(R.id.imageButton_Depositar_VoltarPagar);
            imagebutton_depositar_convertermoeda = findViewById(R.id.imageButton_Depositar_ConverterMoeda);
            edittxt_depositar_digitarvalor = findViewById(R.id.editText_Depositar_DigitarValor);
            edittxt_depositar_digitarrecebedor = findViewById(R.id.editText_Depositar_DigitarRecebedor);
            spinner_bancoorigem = findViewById(R.id.spinner_Deposito_BancoOrigem);
            spinner_moedainicial = findViewById(R.id.spinner_Deposito_MoedaIncial);
            spinner_moedafinal = findViewById(R.id.spinner_Deposito_MoedaFinal);
            spinner_tipodeposito = findViewById(R.id.spinner_Depositar_TipoDeposito);
            txtv_depositar_valorfinal = findViewById(R.id.textView_Depositar_ValolFinal);
            edittxt_depositar_confirmarvalor = findViewById(R.id.editText_Depositar_ConfirmarValor);
            txtv_depositar_datatransacao = findViewById(R.id.textView_Depositar_DataTransacao);
            txtv_depositar_banco = findViewById(R.id.textView_Depositar_Banco);
            txtv_depositar_agenciaconta = findViewById(R.id.textView_Depositar_AgenciaConta);
            txtv_depositar_recebedor = findViewById(R.id.textView_Depositar_Recebedor);
            txtv_depositar_tipodeposito = findViewById(R.id.textView_Depositar_TipoDeposito);


        }
    public void Resultado () {


        String selecionar_moedainicial = spinner_moedainicial.getSelectedItem().toString();
        String selecionar_moedafinal = spinner_moedafinal.getSelectedItem().toString();
        double Dolar = 4.5;
        double Euros = 5.5;
        double Bitcoin = 203730.00;
        double DolarEuros = 0.92;
        double DolarBitcoin = 43356.70;
        double EurosBitcoin = 39661.41;
        double EurosDolar = 1.09;

    String valordigitado = edittxt_depositar_digitarvalor.getText().toString();
        if (selecionar_moedainicial.equals("Real") && selecionar_moedafinal.equals("Dolar")) {
            double valor_digitado = Double.parseDouble(valordigitado);
            double valorfinal = (valor_digitado / Dolar);
            txtv_depositar_valorfinal.setText(String.valueOf(valorfinal));

        } else if (selecionar_moedainicial.equals("Real") && selecionar_moedafinal.equals("Euros")) {
            double valor_digitado = Double.parseDouble(valordigitado);
            double valorfinal = ( valor_digitado / Euros);
            txtv_depositar_valorfinal.setText(String.valueOf(valorfinal));

        }else if (selecionar_moedainicial.equals("Real") && selecionar_moedafinal.equals("Bitcoin")) {
            double valor_digitado = Double.parseDouble(valordigitado);
            double valorfinal = (valor_digitado / Bitcoin);
            txtv_depositar_valorfinal.setText(String.valueOf(valorfinal));

        }else if (selecionar_moedainicial.equals("Dolar") && selecionar_moedafinal.equals("Real")) {
            double valor_digitado = Double.parseDouble(valordigitado);
            double valorfinal = (valor_digitado * Dolar);
            txtv_depositar_valorfinal.setText(String.valueOf(valorfinal));

        }else if (selecionar_moedainicial.equals("Dolar") && selecionar_moedafinal.equals("Euros")) {
            double valor_digitado = Double.parseDouble(valordigitado);
            double valorfinal = ( DolarEuros * valor_digitado );
            txtv_depositar_valorfinal.setText(String.valueOf(valorfinal));

        }else if (selecionar_moedainicial.equals("Dolar") && selecionar_moedafinal.equals("Bitcoin")) {
            double valor_digitado = Double.parseDouble(valordigitado);
            double valorfinal = ( valor_digitado * DolarBitcoin);
            txtv_depositar_valorfinal.setText(String.valueOf(valorfinal));

        }else if (selecionar_moedainicial.equals("Bitcoin") && selecionar_moedafinal.equals("Real")) {
            double valor_digitado = Double.parseDouble(valordigitado);
            double valorfinal = (valor_digitado * Bitcoin);
            txtv_depositar_valorfinal.setText(String.valueOf(valorfinal));

        }else if (selecionar_moedainicial.equals("Bitcoin") && selecionar_moedafinal.equals("Euros")) {
            double valor_digitado = Double.parseDouble(valordigitado);
            double valorfinal = (valor_digitado * Euros);
            txtv_depositar_valorfinal.setText(String.valueOf(valorfinal));

        }else if (selecionar_moedainicial.equals("Bitcoin") && selecionar_moedafinal.equals("Dolar")) {
            double valor_digitado = Double.parseDouble(valordigitado);
            double valorfinal = (DolarBitcoin * valor_digitado );
            txtv_depositar_valorfinal.setText(String.valueOf(valorfinal));

        }else if (selecionar_moedainicial.equals("Dolar") && selecionar_moedafinal.equals("Dolar")) {
            double valor_digitado = Double.parseDouble(valordigitado);
            double valorfinal = valor_digitado;
            txtv_depositar_valorfinal.setText(String.valueOf(valorfinal));

        }else if (selecionar_moedainicial.equals("Bitcoin") && selecionar_moedafinal.equals("Bitcoin")) {
            double valor_digitado = Double.parseDouble(valordigitado);
            double valorfinal = valor_digitado;
            txtv_depositar_valorfinal.setText(String.valueOf(valorfinal));

        }else if (selecionar_moedainicial.equals("Euros") && selecionar_moedafinal.equals("Euros")) {
            double valor_digitado = Double.parseDouble(valordigitado);
            double valorfinal = valor_digitado;
            txtv_depositar_valorfinal.setText(String.valueOf(valorfinal));

        }else if (selecionar_moedainicial.equals("Euros") && selecionar_moedafinal.equals("Dolar")) {
            double valor_digitado = Double.parseDouble(valordigitado);
            double valorfinal = ( EurosDolar * valor_digitado);
            txtv_depositar_valorfinal.setText(String.valueOf(valorfinal));

        }else if (selecionar_moedainicial.equals("Euros") && selecionar_moedafinal.equals("Bitcoin")) {
            double valor_digitado = Double.parseDouble(valordigitado);
            double valorfinal = ( EurosBitcoin * valor_digitado);
            txtv_depositar_valorfinal.setText(String.valueOf(valorfinal));

        }else if (selecionar_moedainicial.equals("Euros") && selecionar_moedafinal.equals("Real")) {
            double valor_digitado = Double.parseDouble(valordigitado);
            double valorfinal = ( valor_digitado * Euros);
            txtv_depositar_valorfinal.setText(String.valueOf(valorfinal));

        }else if (selecionar_moedainicial.equals("Real") && selecionar_moedafinal.equals("Real")) {
            double valor_digitado = Double.parseDouble(valordigitado);
            double valorfinal = valor_digitado;
            txtv_depositar_valorfinal.setText(String.valueOf(valorfinal));
        }
        else {
            Toast.makeText(this, " Selecione novamente", Toast.LENGTH_LONG).show();
        }
        button_deposito_concluirtransacao.setOnClickListener(evt -> proximaTela(TransacaoConcluida.class));

    }
    public void dadosTransacoes(){
        String selecionar_tipodepositoa = spinner_tipodeposito.getSelectedItem().toString();


        if (selecionar_tipodepositoa.equals("Pix")){

            txtv_depositar_recebedor.setText("Kelly");
            txtv_depositar_banco.setText("Banco Itaú S.A");
            txtv_depositar_agenciaconta.setText("1001/1234-5");
            txtv_depositar_tipodeposito.setText(selecionar_tipodepositoa);
            txtv_depositar_datatransacao.setText("11/04/2022");
            Toast.makeText(this, " Confirme osdados para pagamento e Digite sua senha", Toast.LENGTH_LONG).show();


        }else if (selecionar_tipodepositoa.equals("Ted")) {
            txtv_depositar_tipodeposito.setText(selecionar_tipodepositoa);
            txtv_depositar_recebedor.setText("Alexssander");
            txtv_depositar_banco.setText("Banco Bradesco S.A");
            txtv_depositar_agenciaconta.setText("1234/1234-5");
            txtv_depositar_datatransacao.setText("11/04/2022");
            Toast.makeText(this, " Confirme osdados para pagamento e Digite sua senha", Toast.LENGTH_LONG).show();

        }else if (selecionar_tipodepositoa.equals("Doc")){
            txtv_depositar_tipodeposito.setText(selecionar_tipodepositoa);
            txtv_depositar_recebedor.setText("Andre");
            txtv_depositar_banco.setText("Banco Santander S.A");
            txtv_depositar_agenciaconta.setText("1235/1234-5");
            txtv_depositar_datatransacao.setText("11/04/2022");
            Toast.makeText(this, " Confirme osdados para pagamento e Digite sua senha", Toast.LENGTH_LONG).show();

        }else
        {
            Toast.makeText(this, " Código de Barras Inválido", Toast.LENGTH_LONG).show();
        }


    }

}










//ImageButton clic_result;
//TextView exibir;
// clic_result = findViewById(R.id.imageBtnConvert);
//     exibir = findViewById(R.id.textView4);
//        digit_valor = findViewById(R.id.digitValor);
//
//        clic_result.setOnClickListener(view -> {
//            //String texto = tipoMoeda.getSelectedItem().toString();
//            String texto = digit_valor.getText().toString();
//            exibir.setText(texto);
//            //exibir.setText(digit_valor.getText().toString());
//        });//