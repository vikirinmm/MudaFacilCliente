package com.example.mudafacil;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Opcao_Veiculos extends AppCompatActivity {
    private RecyclerView lista_veiculos;
    private Opcao_VeiculosAdapter opcao_veiculosAdapter;
    private boolean isMenuVisible = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.opcao_veiculos);

        //lista
        lista_veiculos = findViewById(R.id.lista_veiculos);
        lista_veiculos.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Opcao_VeiculosModel> opcao_veiculosModels = new ArrayList<>();
        opcao_veiculosModels.add(new Opcao_VeiculosModel("1 h", "4 pessoas", "R$ 200,00", "Van"));
        opcao_veiculosModels.add(new Opcao_VeiculosModel("2 h", "2 pessoas", "R$ 100,00", "Carro"));

        opcao_veiculosAdapter = new Opcao_VeiculosAdapter(opcao_veiculosModels, this);
        lista_veiculos.setAdapter(opcao_veiculosAdapter);
        //lista

        
        //hunburquer
        final ConstraintLayout bottomMenu = findViewById(R.id.aviso);
        ImageView menuButton = findViewById(R.id.filtro);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMenuVisible) {
                    Animation hideAnim = AnimationUtils.loadAnimation(Opcao_Veiculos.this, R.anim.baixo);
                    bottomMenu.startAnimation(hideAnim);
                    bottomMenu.setVisibility(View.INVISIBLE); // Alterado para invisível
                } else {
                    Animation showAnim = AnimationUtils.loadAnimation(Opcao_Veiculos.this, R.anim.cima);
                    bottomMenu.startAnimation(showAnim);
                    bottomMenu.setVisibility(View.VISIBLE);
                }
                isMenuVisible = !isMenuVisible;
            }
        });
        //hunburquer


        //combobox
        Spinner spinner = findViewById(R.id.spinner);

// Lista de itens que serão exibidos no ComboBox
        List<String> items = new ArrayList<>();
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        items.add("Item 4");

// Criar um ArrayAdapter usando a lista de itens e um layout personalizado
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.BLACK);  // Definindo a cor do texto para preto
                return view;
            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.BLACK);  // Definindo a cor do texto para preto
                return view;
            }
        };

// Especificar o layout a ser usado quando a lista de opções aparecer
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Aplicar o adapter ao spinner
        spinner.setAdapter(adapter);

// Adicionar um listener para capturar a seleção do usuário
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtém o item selecionado
                String selectedItem = parent.getItemAtPosition(position).toString();
                // Ação a ser realizada com o item selecionado
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Faz algo caso nada seja selecionado
            }
        });

        //combobox
    }
}
