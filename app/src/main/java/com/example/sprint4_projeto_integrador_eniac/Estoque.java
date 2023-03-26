package com.example.sprint4_projeto_integrador_eniac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Estoque extends AppCompatActivity implements View.OnClickListener{
    Button btAddProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estoque);

        btAddProduto = findViewById(R.id.BtAddProduto);
        btAddProduto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId()==R.id.BtAddProduto){
            Intent intencao = new Intent(this, CadastroProduto.class);
            startActivity(intencao);
        }
    }
}
