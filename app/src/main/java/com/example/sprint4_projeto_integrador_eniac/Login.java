package com.example.sprint4_projeto_integrador_eniac;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button btAcessar;
    TextView txtLogin, btRegistrar, btEsqueciSenha;
    EditText txtSenhaLogin;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btAcessar = findViewById(R.id.BtAcessar);
        btRegistrar = findViewById(R.id.BtRegistrar);
        txtLogin = (EditText) findViewById(R.id.TxtEmailMain);
        txtSenhaLogin = (EditText) findViewById(R.id.TxtPasswordMain);

        btAcessar.setOnClickListener(this);
        btRegistrar.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        if (v.getId() == R.id.BtRegistrar) {
            Intent telaCadastreSe = new Intent(this, PrimeiroAcesso.class);
            startActivity(telaCadastreSe);
        }
        if (v.getId() == R.id.BtAcessar) {
            consultaUsuarioLogin();
        }
    }

    public void consultaUsuarioLogin()
    {
        String Login = txtLogin.getText().toString();
        String SenhaLogin = txtSenhaLogin.getText().toString();

        BancoController bd = new BancoController(getBaseContext());

        Cursor dados = bd.carregaDadosLogin(Login, SenhaLogin);

        if(dados.moveToFirst()){
            Intent tela = new Intent(this, MainActivity.class);
            startActivity(tela);
        } else {
            String msg= "Dados não encontrados no sistema, digite outro.";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            limpar();
        }
    }
    public void limpar(){
        txtLogin.setText("");
        txtSenhaLogin.setText("");
        txtLogin.requestFocus();
    }
}
