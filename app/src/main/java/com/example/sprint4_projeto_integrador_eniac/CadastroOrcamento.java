package com.example.sprint4_projeto_integrador_eniac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroOrcamento extends AppCompatActivity implements View.OnClickListener {
    Button btCadastrar;
    EditText txtNome, txtCpf, txtEmail, txtTelefone;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_orcamento);

        txtNome = findViewById(R.id.InputNomeCadastroOrcamento);
        txtCpf = findViewById(R.id.InputCpfCadastroOrcamento);
        txtEmail = findViewById(R.id.InputEmailCadastroOrcamento);
        txtTelefone = findViewById(R.id.InputTelefoneCadastroOrcamento);
        btCadastrar = findViewById(R.id.ButtonOrcamentoCadastrar);

        btCadastrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nome = txtNome.getText().toString();
        String cpf = txtCpf.getText().toString();
        String email = txtEmail.getText().toString();
        String telefone = txtTelefone.getText().toString();

        BancoController bd = new BancoController(getBaseContext());
//        String resultado = bd.insereDadosOrcamento(nome, cpf, email, telefone);

//        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        Intent tela = new Intent(this, Orcamento.class);
        startActivity(tela);
    }
}
