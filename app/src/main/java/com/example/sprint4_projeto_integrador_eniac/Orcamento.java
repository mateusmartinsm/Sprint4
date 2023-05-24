package com.example.sprint4_projeto_integrador_eniac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Orcamento extends AppCompatActivity implements View.OnClickListener {
    Button btCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orcamento);

        btCadastrar = findViewById(R.id.ButtonOrcamentoCadastrar);
        btCadastrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent tela = new Intent(this, CadastroOrcamento.class);
        startActivity(tela);
    }
}
