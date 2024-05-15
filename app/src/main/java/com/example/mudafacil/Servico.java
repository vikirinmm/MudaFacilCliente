package com.example.mudafacil;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Servico extends AppCompatActivity {
    private RecyclerView listaservico;
    private ServicoAdapter servicoAdapter;
    private ArrayList<Servicomodel> allServicoModels;
    private ArrayList<Servicomodel> filteredServicoModels;
    private TextView ativo;
    private TextView nao_ativo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.servico);

        ImageView voltar = (ImageView) findViewById(R.id.voltar_do_servico);
        voltar.setOnClickListener(v -> {
            Intent main = new Intent(Servico.this, TelaPrincipal.class);
            startActivity(main);
        });

        listaservico = findViewById(R.id.lista_servico);
        listaservico.setLayoutManager(new LinearLayoutManager(this));

        // Exemplo de dados
        allServicoModels = new ArrayList<>();
        allServicoModels.add(new Servicomodel("ativo", "puc area 2", "R$1200,00","22/10/2023","ativo"));
        allServicoModels.add(new Servicomodel("não_ativo", "puc area 2", "R$1200,00","22/10/2023","nao_ativo"));

        ativo = findViewById(R.id.ativos);
        nao_ativo = findViewById(R.id.inativos);

        ativo.setOnClickListener(v -> {
            updateList("ativo");
            changeTextViewBackgrounds(ativo, nao_ativo);
        });

        nao_ativo.setOnClickListener(v -> {
            updateList("nao_ativo");
            changeTextViewBackgrounds(nao_ativo, ativo);
        });

        filteredServicoModels = new ArrayList<>(allServicoModels); // Start with all items visible
        servicoAdapter = new ServicoAdapter(filteredServicoModels);
        listaservico.setAdapter(servicoAdapter);
    }

    private void updateList(String status) {
        filteredServicoModels.clear();
        if (status.equals("ativo")) {
            filteredServicoModels.addAll(allServicoModels.stream()
                    .filter(servico -> "ativo".equals(servico.getStatus()))
                    .collect(Collectors.toList()));
        } else if (status.equals("nao_ativo")) {
            filteredServicoModels.addAll(allServicoModels.stream()
                    .filter(servico -> "nao_ativo".equals(servico.getStatus()))
                    .collect(Collectors.toList()));
        }
        servicoAdapter.notifyDataSetChanged(); // Notify the adapter to update the view
    }

    private void changeTextViewBackgrounds(TextView selectedTextView, TextView unselectedTextView) {
        selectedTextView.setBackgroundResource(R.drawable.botao_azul); // Change to selected background
        unselectedTextView.setBackgroundResource(R.drawable.recentes); // Change to unselected background

        selectedTextView.setTextColor(getResources().getColor(R.color.white)); // Change to selected text color
        unselectedTextView.setTextColor(getResources().getColor(R.color.azul)); // Change to unselected text color
    }
}
