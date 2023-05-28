package com.example.sprint4_projeto_integrador_eniac;

public class ProdutoModelo {
    int id, quantidade;
    float preco;
    String descricao;

    public ProdutoModelo(){}

    public ProdutoModelo(int id, int quantidade, float preco, String descricao){
        this.id = id;
        this.quantidade = quantidade;
        this.preco = preco;
        this. descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
