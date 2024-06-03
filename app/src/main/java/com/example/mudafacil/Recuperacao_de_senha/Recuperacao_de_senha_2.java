package com.example.mudafacil.Recuperacao_de_senha;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mudafacil.R;

public class Recuperacao_de_senha_2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.recuperacaodesenha2);

        ImageView voltar = findViewById(R.id.voltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Recuperacao_de_senha_2.this, Recuperacao_de_senha_1.class);
                startActivity(main);
            }
        });

        Button confirmar = findViewById(R.id.Confirmar);
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Recuperacao_de_senha_2.this, Recuperacao_de_senha_3.class);
                startActivity(main);
            }
        });

        final EditText numero1 = findViewById(R.id.numero1);
        final EditText numero2 = findViewById(R.id.numero2);
        final EditText numero3 = findViewById(R.id.numero3);
        final EditText numero4 = findViewById(R.id.numero4);
        final EditText numero5 = findViewById(R.id.numero5);
        final EditText numero6 = findViewById(R.id.numero6);

        setUpEditText(numero1, null, numero2);
        setUpEditText(numero2, numero1, numero3);
        setUpEditText(numero3, numero2, numero4);
        setUpEditText(numero4, numero3, numero5);
        setUpEditText(numero5, numero4, numero6);
        setUpEditText(numero6, numero5, null);
    }

    private void setUpEditText(final EditText currentEditText, final EditText previousEditText, final EditText nextEditText) {
        currentEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1 && nextEditText != null) {
                    nextEditText.requestFocus();
                } else if (s.length() == 0 && previousEditText != null) {
                    previousEditText.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}
