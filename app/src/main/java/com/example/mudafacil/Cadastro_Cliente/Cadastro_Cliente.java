package com.example.mudafacil.Cadastro_Cliente;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mudafacil.R;
import com.example.mudafacil.api.ApiClient;
import com.example.mudafacil.api.ApiService;
import com.example.mudafacil.api.User;
import com.example.mudafacil.login.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        cadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(nome.getText().toString(), telefone.getText().toString(), email.getText().toString(), senha.getText().toString());
                ApiService apiService = ApiClient.getClient().create(ApiService.class);
                Call<User> call = apiService.registerUser(user);

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(Cadastro_Cliente.this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                            Intent main = new Intent(Cadastro_Cliente.this, Login.class);
                            startActivity(main);
                        } else {
                            Toast.makeText(Cadastro_Cliente.this, "Erro ao cadastrar usuário!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(Cadastro_Cliente.this, "Falha na comunicação com o servidor!", Toast.LENGTH_SHORT).show();
                    }
                });
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
}
