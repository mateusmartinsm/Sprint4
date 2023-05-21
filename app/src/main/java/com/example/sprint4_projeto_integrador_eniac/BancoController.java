package com.example.sprint4_projeto_integrador_eniac;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {

	private SQLiteDatabase db;
	private CriaBanco banco;

	public BancoController(Context context) {
		banco = new CriaBanco(context);
	}



	public String insereDadosUsuario(String nome, String email, String senha) {
		ContentValues valores;
		long resultado;
		db = banco.getWritableDatabase();

		valores = new ContentValues();
		valores.put("nome", nome);
		valores.put("email", email);
		valores.put("senha", senha);

		resultado = db.insert("usuarios", null, valores);
		db.close();

		if (resultado == -1)
			return "Erro ao inserir registro os dados, tente novamente!";
		else
			return "Dados do Usuário cadastrado com sucesso!";
	}

	public String insereDado(String nome, String email) {
		ContentValues valores;
		long resultado;
		db = banco.getWritableDatabase();

		valores = new ContentValues();
		valores.put("nome", nome);
		valores.put("email", email);

		resultado = db.insert("contatos", null, valores);
		db.close();

		if (resultado == -1)
			return "Erro ao inserir registro";
		else
			return "Registro Inserido com sucesso";
	}


	public Cursor carregaDadosLogin(String Login, String SenhaLogin) {
		Cursor cursor;
		String[] campos = { "id", "nome", "email", "senha" };
		String where = "email = '" + Login + "' and senha = '" + SenhaLogin + "'";
		db = banco.getReadableDatabase();
		cursor = db.query("usuarios", campos, where, null, null, null,
				null, null);
		if (cursor != null) {
			cursor.moveToFirst();
		}

		db.close();
		return cursor;
	}

	public Cursor carregaDadoPeloCodigo(int id) {
		Cursor cursor;
		String[] campos = { "codigo", "nome", "email" };
		String where = "codigo=" + id;
		db = banco.getReadableDatabase();
		cursor = db.query("contatos", campos, where, null, null, null,
				null, null);
		if (cursor != null) {
			cursor.moveToFirst();
		}

		db.close();
		return cursor;
	}

	public String alteraDado(int id, String nome, String email){

		String msg = "Dados alterados com sucesso!!!" ;

		db = banco.getReadableDatabase();

		ContentValues valores = new ContentValues() ;

		valores.put("nome" , nome ) ;
		valores.put("email", email) ;

		String condicao = "codigo = " + id ;

		int linha ;
		linha = db.update("contatos", valores, condicao, null) ;

		if (linha < 1){
			msg = "Erro ao alterar os dados" ;
		}

		db.close() ;
		return msg;
	}


	public String excluirDado(int id){
		String msg = "Registro Excluído" ;

		db = banco.getReadableDatabase();

		String condicao = "codigo = " + id ;

		int linhas ;
		linhas = db.delete("contatos", condicao, null) ;

		if ( linhas < 1) {
			msg = "Erro ao Excluir" ;
		}

		db.close();
		return msg;
	}

}
