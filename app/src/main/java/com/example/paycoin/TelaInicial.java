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
import com.example.paycoin.pagar.Pagar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarView;

public class TelaInicial extends AppCompatActivity {

    Button clic_telainicial_pagar;
    Button clic_telainicial_historico;
    Button clic_telainicial_perfil;
    Button clic_telainicial_receber;
    BottomNavigationView botaonavegacao;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial2);
        getSupportActionBar().hide();


        botaonavegacao = findViewById(R.id.bottom_Botao_Navegacao);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_Caixa_Navegacao, new Logoff()).commit();

        botaonavegacao.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                    switch (item.getItemId()){
                        case R.id.nav_Suporte:
                            fragment = new Suporte();
                            break;
                        case R.id.nav_Logoff:Logoff:
                            fragment = new Logoff();
                            break;
                        }
                       getSupportFragmentManager().beginTransaction().replace(R.id.nav_Caixa_Navegacao, fragment).commit();
                return true;
            }
        });


        clic_telainicial_pagar = findViewById(R.id.button_Telainicial_Pagar);
        clic_telainicial_historico = findViewById(R.id.button_TelaInicial_Historico);
        clic_telainicial_perfil = findViewById(R.id.button_TelaInicial_Perfil);

        clic_telainicial_pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pag = new Intent(getApplicationContext(), Pagar.class);
                startActivity(pag);
            }
        });

        clic_telainicial_historico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hist = new Intent(getApplicationContext(), Historico.class);
                startActivity(hist);
            }
        });

        clic_telainicial_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pag = new Intent(getApplicationContext(), PerfilUser.class);
                startActivity(pag);
            }
        });



    }
}