package com.example.sprint4_projeto_integrador_eniac;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class ConsultaLista extends Activity {
    ListView lista;
    String dataselecionada;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lista);

        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();
        dataselecionada = parametros.getString("data");

        List<AgendaModelo> listaAgendamento = null ;
        listaAgendamento = consultarAgendamentos();

        if (listaAgendamento!=null) {
            AgendaAdapter adaptador = new AgendaAdapter(this, listaAgendamento);

            lista = (ListView) findViewById(R.id.lista);
            lista.setAdapter(adaptador);
        } else {
            String msg= "Não há nenhum agendamento cadastrado para esta data!";
            mensagem(msg);
        }
    }


    public List<AgendaModelo> consultarAgendamentos() {
        List<AgendaModelo> lista = new LinkedList<AgendaModelo>();

        BancoController bd = new BancoController(getBaseContext());
        Cursor dados = bd.consultarAgendamentos(dataselecionada) ;

        if(dados != null) {
            if (dados.moveToFirst()) {
                do {
                    AgendaModelo item = new AgendaModelo();
                    item.setId(dados.getInt(0));
                    item.setCliente(dados.getString(1));
                    item.setData(dados.getString(2));
                    item.setHorario(dados.getString(3));
                    lista.add(item);
                } while (dados.moveToNext());
            } else {
                String msg= "Não há nenhum agendamento cadastrado para esta data!!";
                mensagem(msg);
            }
        }
        return  lista ;
    }

    public void mensagem(String msg) {
        //Context contexto = getApplicationContext();
        //int duracao = Toast.LENGTH_SHORT;
        //Toast toast = Toast.makeText(contexto, msg, duracao);
        //toast.show();
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setMessage(msg) ;
        dialogo.setNeutralButton("OK", null);
        dialogo.setTitle("Atenção");
        dialogo.show();
    }

}
