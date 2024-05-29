package com.example.mudafacil.pagamentos;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mudafacil.R;
import com.example.mudafacil.tela_principal.TelaPrincipal;


public class Pagamentos extends AppCompatActivity {
    private RecyclerView paymentsRecyclerView;
    private PagamantosAdapter pagamantosAdapter;
    private boolean isMenuVisible = false;


    private TextView btnStartDate;
    private TextView btnEndDate;

    private Calendar startDateCalendar;
    private Calendar endDateCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.pagamentos);



        //calendario
        btnStartDate = findViewById(R.id.btnStartDate);
        btnEndDate = findViewById(R.id.btnEndDate);

        startDateCalendar = Calendar.getInstance();
        endDateCalendar = Calendar.getInstance();

        btnStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(true);
            }
        });

        btnEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(false);
            }
        });
        //calendario



        //combobox
        Spinner spinner = findViewById(R.id.spinner);

        // Lista de itens que serão exibidos no ComboBox
        List<String> items = new ArrayList<>();
        items.add("Selecione");
        items.add("Item 2");
        items.add("Item 3");
        items.add("Item 4");

        // Criar um ArrayAdapter usando a lista de itens
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);

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


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Faz algo caso nada seja selecionado
            }
        });
        //combobox




        //hunburquer
        final ConstraintLayout bottomMenu = findViewById(R.id.hp);
        ImageView menuButton = findViewById(R.id.filtro);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMenuVisible) {
                    Animation hideAnim = AnimationUtils.loadAnimation(Pagamentos.this, R.anim.baixo);
                    bottomMenu.startAnimation(hideAnim);
                    bottomMenu.setVisibility(View.INVISIBLE); // Alterado para invisível
                } else {
                    Animation showAnim = AnimationUtils.loadAnimation(Pagamentos.this, R.anim.cima);
                    bottomMenu.startAnimation(showAnim);
                    bottomMenu.setVisibility(View.VISIBLE);
                }
                isMenuVisible = !isMenuVisible;
            }
        });

        //hunburquer

        //voltar
        ImageView voltar = (ImageView) findViewById(R.id.voltar_do_pagamento);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Pagamentos.this, TelaPrincipal.class);
                startActivity(main);
            }
        });
        //voltar

        //lista
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
        //lista

    }




    //calendario
    private void showDatePickerDialog(final boolean isStartDate) {
        final Calendar calendar = isStartDate ? startDateCalendar : endDateCalendar;
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(Pagamentos.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(year, month, dayOfMonth);

                        if (isStartDate) {
                            startDateCalendar = selectedDate;
                            if (endDateCalendar != null && startDateCalendar.after(endDateCalendar)) {
                                endDateCalendar = (Calendar) startDateCalendar.clone();
                                updateButtonText(false, endDateCalendar);
                            }
                        } else {
                            endDateCalendar = selectedDate;
                            if (startDateCalendar != null && endDateCalendar.before(startDateCalendar)) {
                                endDateCalendar = (Calendar) startDateCalendar.clone();
                            }
                        }
                        updateButtonText(isStartDate, selectedDate);
                    }
                }, year, month, dayOfMonth);

        datePickerDialog.show();
    }

    private void updateButtonText(boolean isStartDate, Calendar calendar) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String dateString = dateFormat.format(calendar.getTime());

        if (isStartDate) {
            btnStartDate.setText(dateString);
        } else {
            btnEndDate.setText(dateString);
        }
    }

    //calendario
    // btnStartDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
    // btnEndDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
}
