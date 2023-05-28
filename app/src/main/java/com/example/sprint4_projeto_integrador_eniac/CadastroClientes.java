package com.example.sprint4_projeto_integrador_eniac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroClientes extends AppCompatActivity implements View.OnClickListener {
    EditText txtNome, txtCpf, txtEndereco, txtTelefone;
    Button btCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_clientes);

        txtNome = findViewById(R.id.InputNomeCadastroClientes);
        txtCpf = findViewById(R.id.InputCpfCadastroClientes);
        txtEndereco = findViewById(R.id.InputEnderecoCadastroClientes);
        txtTelefone = findViewById(R.id.InputTelefoneCadastroClientes);
        btCadastrar = findViewById(R.id.ButtonCadastrar);

        btCadastrar.setOnClickListener(this);
    }

    public void onClick(View v){
        String nome = txtNome.getText().toString();
        String cpf = txtCpf.getText().toString();
        String endereco = txtEndereco.getText().toString();
        String telefone = txtTelefone.getText().toString();

        BancoController bd = new BancoController(getBaseContext());
        String resultado = bd.insereDadosCliente(nome, cpf, endereco, telefone);

        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        txtNome.setText("");
        txtCpf.setText("");
        txtEndereco.setText("");
        txtTelefone.setText("");
        txtNome.requestFocus();

        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
    }
}