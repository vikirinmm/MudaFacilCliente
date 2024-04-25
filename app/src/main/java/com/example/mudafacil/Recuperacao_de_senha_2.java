package com.example.mudafacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Recuperacao_de_senha_2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.recuperacaodesenha2);
        ImageView voltar = (ImageView) findViewById(R.id.voltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Recuperacao_de_senha_2.this, Recuperacao_de_senha_1.class);
                startActivity(main);
            }
        });
        Button confirmar = (Button) findViewById(R.id.Confirmar);
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Recuperacao_de_senha_2.this, Recuperacao_de_senha_3.class);
                startActivity(main);
            }
        });
    }
}
