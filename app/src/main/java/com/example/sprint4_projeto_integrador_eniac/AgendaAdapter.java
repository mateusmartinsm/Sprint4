package com.example.sprint4_projeto_integrador_eniac;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AgendaAdapter extends ArrayAdapter<AgendaModelo> {
    private Context context;
    private List<AgendaModelo> listaAgendamento = null;

    public AgendaAdapter(Context context, List<AgendaModelo> listaAgendamento) {
        super(context,0, listaAgendamento);
        this.listaAgendamento = listaAgendamento;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        AgendaModelo agendamento = listaAgendamento.get(position);

        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.consulta_lista, null);
        TextView textViewCodigo = (TextView) view.findViewById(R.id.codigo);
        textViewCodigo.setText(String.valueOf(agendamento.getId()));

        TextView textViewNome = (TextView) view.findViewById(R.id.nome);
        textViewNome.setText(agendamento.getCliente());

        TextView textViewData = (TextView)view.findViewById(R.id.data);
        textViewData.setText(agendamento.getData());

        TextView textViewHora = (TextView)view.findViewById(R.id.hora);
        textViewHora.setText(agendamento.getHorario());

        return view;
    }
}
