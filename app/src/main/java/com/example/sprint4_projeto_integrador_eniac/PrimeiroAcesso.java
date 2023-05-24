package com.example.sprint4_projeto_integrador_eniac;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PrimeiroAcesso extends AppCompatActivity  implements View.OnClickListener {

    Button btnSalvar;
    EditText txtNomeCad, txtEmailCad, txtSenhaCad, txtConfSenhaCad;
    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primeiro_acesso);

        btnSalvar = (Button) findViewById(R.id.BtCadastrar);
        txtNomeCad = (EditText) findViewById(R.id.InputNome);
        txtEmailCad = (EditText) findViewById(R.id.InputEmail);
        txtSenhaCad = (EditText) findViewById(R.id.InputSenha);
        txtConfSenhaCad = (EditText) findViewById(R.id.InputConfirmarSenha);

        btnSalvar.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        String NomeCad = txtNomeCad.getText().toString();
        String EmailCad = txtEmailCad.getText().toString();
        String SenhaCad = txtSenhaCad.getText().toString();
        String ConfSenhaCad = txtConfSenhaCad.getText().toString();

        BancoController bd = new BancoController(getBaseContext());
        String resultado;

        if (SenhaCad.equals(ConfSenhaCad)) {
            resultado = bd.insereDadosUsuario(NomeCad, EmailCad, SenhaCad);

            Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            Intent tela = new Intent(this, MainActivity.class);
            startActivity(tela);
        } else {
            String msg = "As senhas digitadas não são iguais, digite novamente!";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    }
    public void limpar()
    {
        txtNomeCad.setText("");
        txtEmailCad.setText("");
        txtSenhaCad.setText("");
        txtConfSenhaCad.setText("");
        txtNomeCad.requestFocus();
    }
}
