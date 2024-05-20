package com.example.mudafacil;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private EditText senhaEditText;
    private ImageView toggleSenhaImageView;
    private boolean isPasswordVisible = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);



        senhaEditText = findViewById(R.id.senha);
        toggleSenhaImageView = findViewById(R.id.olho);

        toggleSenhaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    senhaEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    toggleSenhaImageView.setImageResource(R.drawable.visualizar_senha);
                } else {
                    senhaEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    toggleSenhaImageView.setImageResource(R.drawable.line);
                }
                isPasswordVisible = !isPasswordVisible;
                senhaEditText.setSelection(senhaEditText.getText().length());
            }
        });





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