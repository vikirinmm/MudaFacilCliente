package com.example.mudafacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Servico extends AppCompatActivity {
    private RecyclerView listaservico;
    private ServicoAdapter servicoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.servico);

        ImageView voltar = (ImageView) findViewById(R.id.voltar_do_servico);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Servico.this, TelaPrincipal.class);
                startActivity(main);
            }
        });


        listaservico = findViewById(R.id.lista_servico);
        listaservico.setLayoutManager(new LinearLayoutManager(this));

        // Exemplo de dados
        ArrayList<Servicomodel> servicomodels = new ArrayList<>();
        servicomodels.add(new Servicomodel("ativo", "puc area 2", "R$1200,00","22/10/2023","ativo"));
        servicomodels.add(new Servicomodel("não_ativo", "puc area 2", "R$1200,00","22/10/2023","nao_ativo"));


        servicoAdapter = new ServicoAdapter(servicomodels);
        listaservico.setAdapter(servicoAdapter);

    }
}
