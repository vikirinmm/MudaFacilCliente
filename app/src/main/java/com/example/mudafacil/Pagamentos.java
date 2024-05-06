package com.example.mudafacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


import androidx.recyclerview.widget.LinearLayoutManager;


public class Pagamentos extends AppCompatActivity {
    private RecyclerView paymentsRecyclerView;
    private PagamantosAdapter pagamantosAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.pagamentos);

        ImageView voltar = (ImageView) findViewById(R.id.voltar_do_pagamento);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Pagamentos.this, TelaPrincipal.class);
                startActivity(main);
            }
        });

        paymentsRecyclerView = findViewById(R.id.lista_pagamentos);
        paymentsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Exemplo de dados
        ArrayList<PagamentosModel> pagamentosModels = new ArrayList<>();
        pagamentosModels.add(new PagamentosModel("R$1200,00", "22/10/2023", "Aluguel do escritório"));
        pagamentosModels.add(new PagamentosModel("R$300,00", "15/10/2023", "Internet"));
        pagamentosModels.add(new PagamentosModel("R$150,00", "05/10/2023", "Água"));
        pagamentosModels.add(new PagamentosModel("R$1200,00", "22/10/2023", "Aluguel do escritório"));
        pagamentosModels.add(new PagamentosModel("R$300,00", "15/10/2023", "Internet"));
        pagamentosModels.add(new PagamentosModel("R$150,00", "05/10/2023", "Água"));
        pagamentosModels.add(new PagamentosModel("R$1200,00", "22/10/2023", "Aluguel do escritório"));
        pagamentosModels.add(new PagamentosModel("R$300,00", "15/10/2023", "Internet"));
        pagamentosModels.add(new PagamentosModel("R$150,00", "05/10/2023", "Água"));
        pagamentosModels.add(new PagamentosModel("R$1200,00", "22/10/2023", "Aluguel do escritório"));
        pagamentosModels.add(new PagamentosModel("R$300,00", "15/10/2023", "Internet"));
        pagamentosModels.add(new PagamentosModel("R$150,00", "05/10/2023", "Água"));

        pagamantosAdapter = new PagamantosAdapter(pagamentosModels);
        paymentsRecyclerView.setAdapter(pagamantosAdapter);

    }

}
