package com.example.sprint4_projeto_integrador_eniac;

import static java.lang.Float.parseFloat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroProduto extends AppCompatActivity implements View.OnClickListener {
    EditText txtCodigo, txtDescricao, txtQuantidade, txtPreco;
    Button btCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_produto);

        txtCodigo = findViewById(R.id.InputCadastroProdutoCodigo);
        txtDescricao = findViewById(R.id.InputCadastroProdutoDescricao);
        txtQuantidade = findViewById(R.id.InputCadastroProdutoQuantidade);
        txtPreco = findViewById(R.id.InputCadastroProdutoPreco);
        btCadastrar = findViewById(R.id.ButtonCadastrarProduto);

        btCadastrar.setOnClickListener(this);
    }

    public void onClick(View v){
        String codigo = txtCodigo.getText().toString();
        String descricao = txtDescricao.getText().toString();
        String quantidade = txtQuantidade.getText().toString();
        float preco = parseFloat(txtPreco.getText().toString());

        BancoController bd = new BancoController(getBaseContext());
        String resultado = bd.insereDadosProduto(codigo, descricao, quantidade, preco);

        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        Intent tela = new Intent(this, Estoque.class);
        startActivity(tela);
    }
}