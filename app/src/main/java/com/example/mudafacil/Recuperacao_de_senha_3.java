package com.example.mudafacil;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Recuperacao_de_senha_3 extends AppCompatActivity {
    private EditText senha;
    private ImageView visivil1;
    private EditText comfirmarsenha;
    private ImageView visivil2;
    private boolean pontos1 = false;
    private boolean pontos2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.recuperacaodesenha3);


        senha = findViewById(R.id.senha);
        visivil1 = findViewById(R.id.olho1);

        visivil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pontos1) {
                    senha.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    visivil1.setImageResource(R.drawable.visualizar_senha);
                } else {
                    senha.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    visivil1.setImageResource(R.drawable.line);
                }
                pontos1 = !pontos1;
                senha.setSelection(senha.getText().length());
            }
        });

        comfirmarsenha = findViewById(R.id.comfirmarsenha);
        visivil2 = findViewById(R.id.olho2);

        visivil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pontos2) {
                    comfirmarsenha.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    visivil2.setImageResource(R.drawable.visualizar_senha);
                } else {
                    comfirmarsenha.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    visivil2.setImageResource(R.drawable.line);
                }
                pontos2 = !pontos2;
                comfirmarsenha.setSelection(comfirmarsenha.getText().length());
            }
        });



        ImageView voltar = (ImageView) findViewById(R.id.voltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Recuperacao_de_senha_3.this, Recuperacao_de_senha_1.class);
                startActivity(main);
            }
        });

        Button criarsenhanova = (Button) findViewById(R.id.criarsenhanova);
        criarsenhanova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Recuperacao_de_senha_3.this, Login.class);
                startActivity(main);
            }
        });
    }
}
