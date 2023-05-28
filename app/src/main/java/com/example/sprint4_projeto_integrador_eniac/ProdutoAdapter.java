package com.example.sprint4_projeto_integrador_eniac;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ProdutoAdapter extends ArrayAdapter<ProdutoModelo> {
    private Context context;
    private List<ProdutoModelo> listaProdutos = null;

    public ProdutoAdapter(Context context, List<ProdutoModelo> listaProdutos){
        super(context, 0, listaProdutos);
        this.context = context;
        this.listaProdutos = listaProdutos;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        ProdutoModelo produto = listaProdutos.get(position);

        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.estoque_item, null);
        TextView descricao = view.findViewById(R.id.TxtDescProduto);
        TextView preco = view.findViewById(R.id.TxtPrecoProduto);
        TextView quantidade = view.findViewById(R.id.quantidade);

        descricao.setText(String.valueOf(produto.getDescricao()));
        preco.setText(String.valueOf(produto.getPreco()));
        quantidade.setText(String.valueOf(produto.getQuantidade()));
        return view;
    }
}
