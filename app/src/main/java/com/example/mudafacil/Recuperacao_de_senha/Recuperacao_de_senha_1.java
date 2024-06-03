package com.example.mudafacil.Recuperacao_de_senha;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mudafacil.R;
import com.example.mudafacil.login.Login;

public class Recuperacao_de_senha_1 extends AppCompatActivity {

    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.recuperacaodesenha1);

        ImageView voltar = findViewById(R.id.voltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Recuperacao_de_senha_1.this, Login.class);
                startActivity(main);
            }
        });

        email = findViewById(R.id.email);
        Button enviarcodigo = findViewById(R.id.enviarcodigo);
        enviarcodigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmailValid(email.getText().toString())) {
                    Intent main = new Intent(Recuperacao_de_senha_1.this, Recuperacao_de_senha_2.class);
                    startActivity(main);
                } else {
                    Toast.makeText(Recuperacao_de_senha_1.this, "E-mail inválido!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
