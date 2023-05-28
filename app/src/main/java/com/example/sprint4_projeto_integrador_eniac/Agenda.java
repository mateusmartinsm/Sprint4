package com.example.sprint4_projeto_integrador_eniac;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class Agenda extends AppCompatActivity implements View.OnClickListener{
    DatePicker txtData;
    EditText txtCliente;
    Spinner spHorario;
    Button btConsultar;
    Button btAgendar;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agenda);

        txtData = (DatePicker) findViewById(R.id.calendario);
        txtCliente = findViewById(R.id.InputAgendaCliente);
        btConsultar = (Button) findViewById( R.id.BtConsultar);
        btAgendar = (Button) findViewById(R.id.BtAgendar);
        spHorario = (Spinner) findViewById(R.id.SpHorario);

        btAgendar.setOnClickListener(this);
        btConsultar.setOnClickListener(this);

        String[] horarios = new String[] {
            "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"
        };

        ArrayAdapter<String> aad = new ArrayAdapter<String>(
                this , android.R.layout.simple_gallery_item , horarios
        ); spHorario.setAdapter(aad);
    }

    public void onClick(View v){
        String data = txtData.getDayOfMonth() +
                "/" + txtData.getDayOfMonth() +
                "/" + txtData.getYear();
        String hora = (String) spHorario.getSelectedItem();
        BancoController bd = new BancoController(getBaseContext());
        Cursor dados = bd.consultaAgendaHorario(data, hora);

        if(v.getId() == R.id.BtAgendar){
            if(dados.moveToFirst()) {
                String msg = "Não foi possível cadastrar, pois não há vaga neste data/hora!!";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            } else {
                String resultado;
                resultado = bd.insereDadosAgendamento(txtCliente.getText().toString(), data, hora);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        } if(v.getId() == R.id.BtConsultar){
            String dataSelecionada = txtData.getDayOfMonth() +
                    "/" + txtData.getDayOfMonth() +
                    "/" + txtData.getYear();
            Intent telaListaAgendamento = new Intent(this, ConsultaLista.class);
            Bundle parametros = new Bundle();
            parametros.putString("data",dataSelecionada);
            telaListaAgendamento.putExtras(parametros);
            startActivity(telaListaAgendamento);
        }
    }
}
