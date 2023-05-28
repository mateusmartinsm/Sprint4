package com.example.sprint4_projeto_integrador_eniac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;
import java.util.List;

public class Estoque extends AppCompatActivity implements View.OnClickListener {
    ListView lista;
    Button btAddProduto, btDelProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produtos_lista);

        List<ProdutoModelo> listaProdutos = null ;
        listaProdutos = consultarEstoque();
        btAddProduto = findViewById(R.id.AdicionarProduto);
        btDelProduto = findViewById(R.id.deletarProduto);
        btAddProduto.setOnClickListener(this);
        btDelProduto.setOnClickListener(this);

        if (listaProdutos != null) {
            ProdutoAdapter adaptador = new ProdutoAdapter(this, listaProdutos);
            lista = (ListView) findViewById(R.id.ProdutosLista);
            lista.setAdapter(adaptador);
        } else {
            mensagem("Nenhum produto cadastrado no sistema");
        }
    }

    @Override
    public void onClick(View v){
        if(v.getId()==R.id.AdicionarProduto){
            Intent intencao = new Intent(this, CadastroProduto.class);
            startActivity(intencao);
        }
        else if (v.getId() == R.id.deletarProduto){
            Intent intencao = new Intent(this, DeletarProduto.class);
            startActivity(intencao);
        }
    }

    public List<ProdutoModelo> consultarEstoque() {
        List<ProdutoModelo> lista = new LinkedList<ProdutoModelo>();

        BancoController bd = new BancoController(getBaseContext());
        Cursor dados = bd.consultarEstoque() ;

        if(dados != null) {
            if (dados.moveToFirst()) {
                do {ProdutoModelo item = new ProdutoModelo();
                    item.setId(dados.getInt(0));
                    item.setDescricao(dados.getString(1));
                    item.setPreco(dados.getFloat(2));
                    item.setQuantidade(dados.getInt(3));
                    lista.add(item);
                } while (dados.moveToNext());
            } else {
                mensagem("Nenhum produto cadastrado");
            }
        }
        return lista ;
    }

    public void mensagem(String msg) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setMessage(msg) ;
        dialogo.setNeutralButton("OK", null);
        dialogo.setTitle("Atenção");
        dialogo.show();
    }
}
