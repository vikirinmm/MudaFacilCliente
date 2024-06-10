package com.example.mudafacil.login;

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

import com.example.mudafacil.Cadastro_Cliente.Cadastro_Cliente;
import com.example.mudafacil.R;
import com.example.mudafacil.Recuperacao_de_senha.Recuperacao_de_senha_1;
import com.example.mudafacil.tela_principal.TelaPrincipal;

public class Login extends AppCompatActivity {

    private EditText email;
    private EditText senha;
    private ImageView toggleSenhaImageView;
    private boolean isPasswordVisible = false;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);

        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);
        toggleSenhaImageView = findViewById(R.id.olho);
        btnLogin = findViewById(R.id.logar);

        toggleSenhaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    senha.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    toggleSenhaImageView.setImageResource(R.drawable.visualizar_senha);
                } else {
                    senha.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    toggleSenhaImageView.setImageResource(R.drawable.line);
                }
                isPasswordVisible = !isPasswordVisible;
                senha.setSelection(senha.getText().length());
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
        TextView recuperar = findViewById(R.id.recuperarsenha);
        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Login.this, Recuperacao_de_senha_1.class);
                startActivity(main);
            }
        });

        TextView clique = findViewById(R.id.cliqueaqui);
        clique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Login.this, Cadastro_Cliente.class);
                startActivity(main);
            }
        });
    }
}
