package com.example.sprint4_projeto_integrador_eniac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DeletarCliente extends AppCompatActivity implements View.OnClickListener {
    EditText descricao;
    Button deletar;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.deletar_cliente);

            deletar = findViewById(R.id.buttonDeletarCliente);
            descricao = findViewById(R.id.nomeCliente);
            deletar.setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {
        BancoController bd = new BancoController(getBaseContext());
        bd.DeletarCliente(descricao.getText().toString());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
