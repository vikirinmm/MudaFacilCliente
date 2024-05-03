package com.example.mudafacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;


import androidx.recyclerview.widget.LinearLayoutManager;


public class Pagamentos extends AppCompatActivity {
    private RecyclerView paymentsRecyclerView;
    private PaymentsAdapter paymentsAdapter;
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
        ArrayList<Payment> payments = new ArrayList<>();
        payments.add(new Payment("R$1200,00", "22/10/2023", "Aluguel do escritório"));
        payments.add(new Payment("R$300,00", "15/10/2023", "Internet"));
        payments.add(new Payment("R$150,00", "05/10/2023", "Água"));
        payments.add(new Payment("R$1200,00", "22/10/2023", "Aluguel do escritório"));
        payments.add(new Payment("R$300,00", "15/10/2023", "Internet"));
        payments.add(new Payment("R$150,00", "05/10/2023", "Água"));
        payments.add(new Payment("R$1200,00", "22/10/2023", "Aluguel do escritório"));
        payments.add(new Payment("R$300,00", "15/10/2023", "Internet"));
        payments.add(new Payment("R$150,00", "05/10/2023", "Água"));
        payments.add(new Payment("R$1200,00", "22/10/2023", "Aluguel do escritório"));
        payments.add(new Payment("R$300,00", "15/10/2023", "Internet"));
        payments.add(new Payment("R$150,00", "05/10/2023", "Água"));

        paymentsAdapter = new PaymentsAdapter(payments);
        paymentsRecyclerView.setAdapter(paymentsAdapter);

    }

}
