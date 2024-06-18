package com.example.mudafacil.Cadastro_Cliente;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mudafacil.R;
import com.example.mudafacil.api.connectionFactory;
import com.example.mudafacil.api.model.Usuario;
import com.example.mudafacil.login.Login;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

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
        cadastra.setOnClickListener(v ->  {
            String nome = ((EditText) findViewById(R.id.Nome)).getText().toString();
            String telefone = ((EditText) findViewById(R.id.telefone)).getText().toString();
            String email = ((EditText) findViewById(R.id.email)).getText().toString();
            String senha = ((EditText) findViewById(R.id.senha)).getText().toString();
            Usuario user=new Usuario(nome,email,telefone,senha);
            connectionFactory connectionFactory =new connectionFactory();
            connectionFactory.post(user, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.getStackTrace();
                    Log.e("Erro","ao solicitar o serviço solicitado");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String responseBody=response.body().string();
                    if(response.isSuccessful()){
                        Log.i("Sucesso","Usuario Criado com sucesso");
                        Intent intent=new Intent(Cadastro_Cliente.this, Login.class);
                        startActivity(intent);
                    }else {
                        Log.i("Erro","Erro na reposta"+responseBody);
                    }

                }
            });

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
