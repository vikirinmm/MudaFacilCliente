package com.example.mudafacil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class EditarPerfil extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.editar_perfil);

        ImageView voltar = (ImageView) findViewById(R.id.voltar);

        voltar.setOnClickListener(v -> {
            Intent intent= new Intent(EditarPerfil.this,TelaPrincipal.class);
            startActivity(intent);
        });

        Button myButton = findViewById(R.id.editar);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showConfirmationDialog();
            }
        });

    }

    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmar Ação");
        builder.setMessage("Você deseja continuar?");

        // Botão para confirmar
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Código para o que acontecerá quando o usuário confirmar
                Toast.makeText(EditarPerfil.this, "Ação confirmada!", Toast.LENGTH_SHORT).show();
            }
        });

        // Botão para cancelar
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Código para o que acontecerá quando o usuário cancelar
                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
