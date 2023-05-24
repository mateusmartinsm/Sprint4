package com.example.sprint4_projeto_integrador_eniac;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "banco.db";
    private static final int  VERSAO = 2;

    public CriaBanco(Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }

    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE usuarios("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome TEXT,"
                + "dataNascimento,"
                + "email,"
                + "senha,"
                + "dataCadastro,"
                + "usuarioAtivo,"
                + "usuarioAdmin)";
        String sql1 = "CREATE TABLE clientes("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "usuario INTEGER,"
                + "nome TEXT,"
                + "cpf_cnpj TEXT,"
                + "dataNascimento_fundacao TEXT,"
                + "cep TEXT,"
                + "endereco TEXT,"
                + "bairro TEXT,"
                + "cidade TEXT,"
                + "estado TEXT,"
                + "telefone TEXT,"
                + "email TEXT,"
                + "dataCadastro TEXT)";
        String sql2 = "CREATE TABLE produtos("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "descricao TEXT,"
                + "quantidade INTEGER,"
                + "preco REAL)";
        String sql3 = "CREATE TABLE orcamentos("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "cliente INTEGER,"
                + "usuario INTEGER,"
                + "carrinho INTEGER,"
                + "descricao TEXT,"
                + "dataCriacao TEXT,"
                + "validadeOrcamento TEXT,"
                + "subtotal REAL,"
                + "desconto REAL,"
                + "total REAL,"
                + "status TEXT)";
        String sql4 = "CREATE TABLE carrinho("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "produtos INTEGER,"
                + "quantidade INTEGER)";

        db.execSQL(sql);
        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS clientes");
        db.execSQL("DROP TABLE IF EXISTS produtos");
        db.execSQL("DROP TABLE IF EXISTS orcamentos");
        db.execSQL("DROP TABLE IF EXISTS carrinho");
        onCreate(db);
    }
}
