package com.example.sprint4_projeto_integrador_eniac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Agenda extends AppCompatActivity implements View.OnClickListener{
    Button btAgendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        btAgendar = findViewById(R.id.BtAgendar);
        btAgendar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intencao = new Intent(this, AgendarServico.class);
        startActivity(intencao);
    }
}
