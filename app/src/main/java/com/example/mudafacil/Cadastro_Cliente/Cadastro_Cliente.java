package com.example.mudafacil.Cadastro_Cliente;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mudafacil.R;
import com.example.mudafacil.login.Login;

public class Cadastro_Cliente extends AppCompatActivity {

    private EditText nome;
    private EditText telefone;
    private EditText email;
    private EditText senha;
    private Button cadastra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.cadastrocliente);

        nome = findViewById(R.id.Nome);
        telefone = findViewById(R.id.telefone);
        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);
        cadastra = findViewById(R.id.cadastra);

        Button cadastra = (Button) findViewById(R.id.cadastra);
        cadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Cadastro_Cliente.this, Login.class);
                startActivity(main);
            }
        });
        ImageView voltar = findViewById(R.id.voltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Cadastro_Cliente.this, Login.class);
                startActivity(main);
            }
        });
    }

    private boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
