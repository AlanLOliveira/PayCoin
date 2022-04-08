package com.example.paycoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

public class PerfilUser extends AppCompatActivity {
    Button clic_perfil_salvar, clic_perfil_sair, clic_perfil_editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_user);
        getSupportActionBar().hide();

        clic_perfil_salvar = findViewById(R.id.button_perfil_Salvar);
        clic_perfil_editar = findViewById(R.id.button_perfil_Editar);
        clic_perfil_sair = findViewById(R.id.button_perfil_Sair);

        clic_perfil_sair.setOnClickListener(evt->proxima_tela(TelaInicial.class));


    }
    public void proxima_tela(Class x){
        Intent proxima = new Intent(getApplicationContext(), x);
        startActivity(proxima);


    }
}