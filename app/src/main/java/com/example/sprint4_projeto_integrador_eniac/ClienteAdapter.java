package com.example.sprint4_projeto_integrador_eniac;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ClienteAdapter extends ArrayAdapter<ClienteModelo> {
    private Context context;
    private List<ClienteModelo> listaClientes = null;

    public ClienteAdapter(Context context, List<ClienteModelo> listaClientes) {
        super(context,0, listaClientes);
        this.listaClientes = listaClientes;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ClienteModelo cliente = listaClientes.get(position);

        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.clientes, null);
        TextView nome = (TextView) view.findViewById(R.id.nome);
        TextView cpf = (TextView) view.findViewById(R.id.cpf);
        TextView endereco = (TextView)view.findViewById(R.id.endereco);
        TextView telefone = (TextView)view.findViewById(R.id.telefone);

        nome.setText(String.valueOf(cliente.getNome()));
        cpf.setText(cliente.getCpf());
        endereco.setText(cliente.getEndereco());
        telefone.setText(cliente.getTelefone());

        return view;
    }
}
