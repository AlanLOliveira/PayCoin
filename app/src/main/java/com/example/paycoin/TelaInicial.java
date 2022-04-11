package com.example.paycoin;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.paycoin.cadastro.CadastroUser;
import com.example.paycoin.cadastro.MainActivity;
import com.example.paycoin.pagar.Pagar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarView;

public class TelaInicial extends AppCompatActivity {

    Button clic_telainicial_pagar;
    Button clic_telainicial_historico;
    Button clic_telainicial_perfil;
    Button clic_telainicial_logoff;
    Button clic_telainicial_suporte;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial2);
        getSupportActionBar().hide();

        clic_telainicial_pagar = findViewById(R.id.button_Telainicial_Pagar);
        clic_telainicial_historico = findViewById(R.id.button_TelaInicial_Historico);
        clic_telainicial_perfil = findViewById(R.id.button_TelaInicial_Perfil);
        clic_telainicial_logoff = findViewById(R.id.button_TelaInicial_Logoff);
        clic_telainicial_suporte = findViewById(R.id.button_TelaInicial_Suporte);

        clic_telainicial_logoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logoff = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(logoff);
                        }
        });

        clic_telainicial_pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pagar = new Intent(getApplicationContext(), Pagar.class);
                startActivity(pagar);
            }
        });

        clic_telainicial_historico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent historico = new Intent(getApplicationContext(), Historico.class);
                startActivity(historico);
            }
        });

        clic_telainicial_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent perfil = new Intent(getApplicationContext(), PerfilUser.class);
                startActivity(perfil);
            }
        });

        clic_telainicial_suporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent suporte = new Intent(getApplicationContext(), Suporte.class);
                startActivity(suporte);
            }
        });



    }
}