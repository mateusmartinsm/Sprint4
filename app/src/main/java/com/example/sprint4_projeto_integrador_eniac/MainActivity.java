package com.example.sprint4_projeto_integrador_eniac;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btClientes, btProdutos, btOrcamento, btAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btClientes = findViewById(R.id.BtClientes);
        btClientes.setOnClickListener(this);

        btProdutos = findViewById(R.id.BtProdutos);
        btProdutos.setOnClickListener(this);

        btAgenda = findViewById(R.id.BtAgenda);
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

        if (v.getId()==R.id.BtClientes)
            intencao = new Intent(this, Clientes.class);
        else if (v.getId()==R.id.BtProdutos)
            intencao = new Intent(this, Estoque.class);
        else if (v.getId()==R.id.BtAgenda)
            intencao = new Intent(this, Agenda.class);
        else
            return;
        startActivity(intencao);
    }
}