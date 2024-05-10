package com.example.mudafacil;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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
        LayoutInflater inflater = LayoutInflater.from(this);
        View customView = inflater.inflate(R.layout.confirmareditar, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TransparentDialog); // Aplica o estilo transparente
        builder.setView(customView);

        AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT)); // Adicional para garantir transparência

        Button confirmButton = customView.findViewById(R.id.dialog_btn_confirm);
        confirmButton.setOnClickListener(v -> {
            Toast.makeText(EditarPerfil.this, "Ação confirmada!", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        Button cancelButton = customView.findViewById(R.id.dialog_btn_cancel);
        cancelButton.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }



}
