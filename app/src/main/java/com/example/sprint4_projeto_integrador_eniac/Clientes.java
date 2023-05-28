package com.example.sprint4_projeto_integrador_eniac;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class Clientes extends Activity implements View.OnClickListener {
    ListView lista;
    Button adicionar, deletar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clientes_lista);

        List<ClienteModelo> listaClientes = null;
        listaClientes = consultarClientes();
        adicionar = findViewById(R.id.adicionar);
        deletar = findViewById(R.id.deletarCliente);
        adicionar.setOnClickListener(this);
        deletar.setOnClickListener(this);

        if (listaClientes != null) {
            ClienteAdapter adaptador = new ClienteAdapter(this, listaClientes);
            lista = (ListView) findViewById(R.id.ClientesLista);
            lista.setAdapter(adaptador);
        } else {
            mensagem("Nenhum cliente cadastrado no sistema");
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.adicionar) {
            Intent intencao = new Intent(this, CadastroClientes.class);
            startActivity(intencao);
        } else if(v.getId()==R.id.deletarCliente){
            Intent intencao = new Intent(this, DeletarCliente.class);
            startActivity(intencao);
        }
    }

    public List<ClienteModelo> consultarClientes() {
        List<ClienteModelo> lista = new LinkedList<ClienteModelo>();
        BancoController bd = new BancoController(getBaseContext());
        Cursor dados = bd.consultarClientes();

        if(dados != null) {
            if (dados.moveToFirst()) {
                do {ClienteModelo item = new ClienteModelo();
                    item.setNome(dados.getString(0));
                    item.setCpf(dados.getString(1));
                    item.setEndereco(dados.getString(2));
                    item.setTelefone(dados.getString(3));
                    lista.add(item);
                } while (dados.moveToNext());
            } else {
                mensagem("Nenhum cliente cadastrado no sistema");
            }
        } return lista;
    }

    public void mensagem(String msg) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setMessage(msg);
        dialogo.setNeutralButton("OK", null);
        dialogo.setTitle("Atenção");
        dialogo.show();
    }
}
