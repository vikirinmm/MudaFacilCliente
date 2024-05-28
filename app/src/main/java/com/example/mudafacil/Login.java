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
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginRequest loginRequest = new LoginRequest(email.getText().toString(), senha.getText().toString());
                ApiService apiService = ApiClient.getClient().create(ApiService.class);
                Call<LoginResponse> call = apiService.loginUser(loginRequest);

                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful()) {
                            String token = response.body().getToken();
                            // Salvar o token e navegar
                            Toast.makeText(Login.this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login.this, TelaPrincipal.class);
                            intent.putExtra("token", token);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Login.this, "Email ou senha incorretos!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(Login.this, "Falha na comunicação com o servidor!", Toast.LENGTH_SHORT).show();
                    }
                });
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
