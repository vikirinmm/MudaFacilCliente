package com.example.mudafacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);

        TextView recuperar = (TextView) findViewById(R.id.recuperarsenha);
        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Login.this, Recuperacao_de_senha_1.class);
                startActivity(main);
            }
        });
        TextView clique = (TextView) findViewById(R.id.cliqueaqui);
        clique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Login.this, Cadastro_Cliente.class);
                startActivity(main);
            }
        });
        Button logar = (Button) findViewById(R.id.logar);
        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Login.this, TelaPrincipal.class);
                startActivity(main);
            }
        });

    }
}