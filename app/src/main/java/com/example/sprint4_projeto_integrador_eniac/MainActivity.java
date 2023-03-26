package com.example.sprint4_projeto_integrador_eniac;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btAcessar;
    TextView btEsqueciSenha, btRegistrar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAcessar = findViewById(R.id.BtAcesssar);
        btAcessar.setOnClickListener(this);

        btEsqueciSenha = findViewById(R.id.BtEsqueciSenha);
        btEsqueciSenha.setOnClickListener(this);

        btRegistrar = findViewById(R.id.BtRegistrar);
        btRegistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.BtAcesssar) {
            Intent intencao = new Intent(this, Menu.class);
            startActivity(intencao);
        }
        if (v.getId()==R.id.BtEsqueciSenha){
            Intent intencao = new Intent(this, EsqueciSenha.class);
            startActivity(intencao);
        }
        if (v.getId()==R.id.BtRegistrar){
            Intent intencao = new Intent(this,PrimeiroAcesso.class);
            startActivity(intencao);
        }
        if (v.getId()==R.id.BtClientes){
            Intent intencao = new Intent(this,CadastroClientes.class);
            startActivity(intencao);
        }
        if (v.getId()==R.id.BtProdutos){
            Intent intencao = new Intent(this, CadastroProduto.class);
            startActivity(intencao);
        }
    }
}