package com.example.mudafacil.EditarPerfil;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mudafacil.R;
import com.example.mudafacil.api.ApiClient;
import com.example.mudafacil.api.ApiService;
import com.example.mudafacil.api.User;
import com.example.mudafacil.tela_principal.TelaPrincipal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditarPerfil extends AppCompatActivity {
    private EditText nome;
    private EditText telefone;
    private EditText email;
    private EditText senha;
    private EditText comfirmarsenha;
    private ImageView visivil1;
    private ImageView visivil2;
    private boolean pontos1 = false;
    private boolean pontos2 = false;
    private Button editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.editar_perfil);

        nome = findViewById(R.id.Nome);
        telefone = findViewById(R.id.telefone);
        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);
        comfirmarsenha = findViewById(R.id.comfirmarsenha);
        visivil1 = findViewById(R.id.olho1);
        visivil2 = findViewById(R.id.olho2);
        editar = findViewById(R.id.editar);

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

        ImageView voltar = findViewById(R.id.voltar);
        voltar.setOnClickListener(v -> {
            Intent intent = new Intent(EditarPerfil.this, TelaPrincipal.class);
            startActivity(intent);
        });

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUserProfile();
            }
        });
    }

    private void updateUserProfile() {
        User user = new User(nome.getText().toString(), telefone.getText().toString(), email.getText().toString(), senha.getText().toString());
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<User> call = apiService.updateUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(EditarPerfil.this, "Perfil atualizado com sucesso!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditarPerfil.this, "Erro ao atualizar perfil!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(EditarPerfil.this, "Falha na comunicação com o servidor!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showConfirmationDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View customView = inflater.inflate(R.layout.confirmareditar, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TransparentDialog);
        builder.setView(customView);

        AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

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
