package com.example.sprint4_projeto_integrador_eniac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class EsqueciSenha extends AppCompatActivity implements View.OnClickListener{
     Button btEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci_senha);

        btEnviar = findViewById(R.id.BtEnviar);
        btEnviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.BtProdutos){
            Intent intencao = new Intent(this, MainActivity.class);
            startActivity(intencao);
        }
    }
}