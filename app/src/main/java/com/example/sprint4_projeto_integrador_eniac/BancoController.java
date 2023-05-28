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

	public String DeletarProduto(String descricao){
		db = banco.getReadableDatabase();
		int retorno = db.delete("produtos", null, null);
		if(retorno == -1)
			return "Erro ao deletar produto";
		return "Produto deletado";
	}

	public String DeletarCliente(String nome){
		db = banco.getReadableDatabase();
		int retorno = db.delete("clientes", null, null);
		if(retorno == -1)
			return "Erro ao deletar cliente";
		return "Cliente deletado";
	}

	public Cursor consultarAgendamentos(String dataselecionada){
		Cursor cursor;
		String[] campos = { "id", "cliente", "data","horario" };
		String filtro = "data = '" + dataselecionada + "'";
		db = banco.getReadableDatabase();
		cursor = db.query("agendamentos", campos, filtro, null, null,
				null, null, null);
		if(cursor != null)
			cursor.moveToFirst();
		db.close();
		return cursor;
	}

	public Cursor consultarClientes(){
		Cursor cursor;
		String[] campos = {"nome", "cpf_cnpj", "endereco", "telefone"};
		db = banco.getReadableDatabase();
		cursor = db.query("clientes", campos, null, null, null,
				null, null, null);
		if(cursor != null)
			cursor.moveToFirst();
		db.close();
		return cursor;
	}

	public Cursor consultarEstoque(){
		Cursor cursor;
		String[] campos = {"id", "descricao", "preco", "quantidade"};
		db = banco.getReadableDatabase();
		cursor = db.query("produtos", campos, null, null, null,
				null, null, null);
		if(cursor != null)
			cursor.moveToFirst();
		db.close();
		return cursor;
	}
	public Cursor consultaAgendaHorario(String data, String horario) {
		Cursor cursor;
		 String[] campos = {"id", "cliente", "data", "horario"};
		 String where = "data = '" + data + "' and horario = '" + horario + "'";
		 db = banco.getReadableDatabase();
		 cursor = db.query("agendamentos", campos, where, null, null, null,
				 null, null);
		 if (cursor != null) {
			 cursor.moveToFirst();
		 }

		 db.close();
		 return cursor;
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
		return "Dados do Usuário cadastrado com sucesso!";
	}

	public String insereDadosCliente(String nome, String cpf, String endereco, String telefone){
		ContentValues valores;
		long resultado;
		db = banco.getWritableDatabase();

		valores = new ContentValues();
		valores.put("nome", nome);
		valores.put("cpf_cnpj", cpf);
		valores.put("endereco", endereco);
		valores.put("telefone", telefone);

		resultado = db.insert("clientes", null, valores);
		db.close();

		if(resultado == -1)
			return "Erro ao cadastrar cliente";
		return "Cliente cadastrado com sucesso";
	}

	public String insereDadosProduto(String codigo, String descricao, String quantidade, float preco){
		ContentValues valores;
		long resultado;
		db = banco.getWritableDatabase();
		valores = new ContentValues();

		valores.put("id", codigo);
		valores.put("descricao", descricao);
		valores.put("quantidade", quantidade);
		valores.put("preco", preco);

		resultado = db.insert("produtos", null, valores);
		db.close();

		if(resultado == -1)
			return "Erro ao cadastrar produto";
		return "Produto cadastrado com sucesso";
	}

	public String insereDadosAgendamento(String cliente, String data, String horario){
     ContentValues valores;
     long resultado;
     db = banco.getWritableDatabase();

     valores = new ContentValues();
     valores.put("cliente", cliente);
     valores.put("data", data);
     valores.put("horario", horario);

     resultado = db.insert("agendamentos", null, valores);
     db.close();

     if (resultado == -1)
         return "Erro ao inserir agendamento!";
	 return "Agendamento cadastrado com sucesso!";
 }

//	public String insereDadosOrcamento(String nome, String cpf, String email, String telefone){
//		ContentValues valores;
//		long resultado;
//		db = banco.getWritableDatabase();
//		valores = new ContentValues();
//
//		valores.put("cliente", nome);
//		valores.put("cpf");
//	}

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

	public String excluirProduto(int id){
		String msg = "Produto excluído";
		db = banco.getReadableDatabase();
		String condicao = "produtos = " + id;
		int linhas = db.delete("produtos", condicao,null);

		if ( linhas < 1)
			msg = "Erro ao Excluir" ;
		db.close();
		return msg;
	}

}
