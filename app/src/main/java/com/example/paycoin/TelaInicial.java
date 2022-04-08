package com.example.paycoin;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.example.paycoin.pagar.Pagar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarView;

public class TelaInicial extends AppCompatActivity {

    Button clic_pagar;
    Button clic_historico;
    Button clic_user;
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


        clic_pagar = findViewById(R.id.pagar);
        clic_historico = findViewById(R.id.button_TelaInicial_Historico);
        clic_user = findViewById(R.id.user);

        clic_pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pag = new Intent(getApplicationContext(), Pagar.class);
                startActivity(pag);
            }
        });

        clic_historico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hist = new Intent(getApplicationContext(), Historico.class);
                startActivity(hist);
            }
        });




    }
}