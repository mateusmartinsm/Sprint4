package com.example.sprint4_projeto_integrador_eniac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    Button btClientes, btProdutos, btAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btClientes = (Button) findViewById(R.id.BtClientes);
        btClientes.setOnClickListener(this);

        btProdutos = (Button) findViewById(R.id.BtProdutos);
        btProdutos.setOnClickListener(this);

        btAgenda = (Button) findViewById(R.id.BtAgenda);
        btAgenda.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {

        getMenuInflater().inflate(R.menu.menu_principal, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onClick(View v) {
        Intent intencao;

        if (v.getId()==R.id.BtClientes){
            intencao = new Intent(this, CadastroClientes.class);
        }
        else if (v.getId()==R.id.BtProdutos){
            intencao = new Intent(this, Estoque.class);
        }
        else if (v.getId()==R.id.BtAgenda){
            intencao = new Intent(this, Agenda.class);
        }
        else return;
        startActivity(intencao);
    }
}