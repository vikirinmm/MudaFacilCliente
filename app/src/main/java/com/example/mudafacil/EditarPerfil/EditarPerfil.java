package com.example.mudafacil.EditarPerfil;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mudafacil.R;
import com.example.mudafacil.api.connectionFactory;
import com.example.mudafacil.login.Login;
import com.example.mudafacil.tela_principal.TelaPrincipal;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class EditarPerfil extends AppCompatActivity {
    private EditText nomeuser;
    private EditText telefone;
    private EditText emailuser;
    private EditText senhauser;
    private EditText comfirmarsenha;
    private TextView del;
    private ImageView visivil1;
    private ImageView visivil2;
    private boolean pontos1 = false;
    private boolean pontos2 = false;
    private Button editar;

    private String id;  // Armazena o ID do usuário

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.editar_perfil);

        Intent intents = getIntent();
        String userToken = intents.getStringExtra("USER_TOKEN");

        // Supondo que o userToken seja um JSON válido com as informações do usuário
        try {
            JSONObject jsonObj = new JSONObject(userToken);
            id = jsonObj.getString("id");  // Captura o ID do usuário
            String name = jsonObj.getString("name");
            String phone = jsonObj.getString("phone");
            String email = jsonObj.getString("email");

            nomeuser = findViewById(R.id.Nome);
            telefone = findViewById(R.id.telefone);
            emailuser = findViewById(R.id.email);
            senhauser = findViewById(R.id.senha);
            comfirmarsenha = findViewById(R.id.comfirmarsenha);
            visivil1 = findViewById(R.id.olho1);
            visivil2 = findViewById(R.id.olho2);
            editar = findViewById(R.id.editar);

            nomeuser.setHint(name);
            telefone.setHint(phone);
            emailuser.setHint(email);

            visivil1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    togglePasswordVisibility(senhauser, visivil1);
                }
            });

            visivil2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    togglePasswordVisibility(comfirmarsenha, visivil2);
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
                    showConfirmationDialog();
                }
            });

            del = findViewById(R.id.deletar);
            del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDeleteDialog();
                }
            });
        } catch (JSONException e) {
            Log.e("EditarPerfil", "Erro ao parsear JSON: " + e.getMessage());
        }
    }

    private void togglePasswordVisibility(EditText editText, ImageView imageView) {
        boolean isPasswordVisible = editText.getTransformationMethod() instanceof HideReturnsTransformationMethod;
        if (isPasswordVisible) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            imageView.setImageResource(R.drawable.visualizar_senha);
        } else {
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            imageView.setImageResource(R.drawable.line);
        }
        editText.setSelection(editText.getText().length());
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

    private void showDeleteDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View customView = inflater.inflate(R.layout.confirmardeletar, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TransparentDialog);
        builder.setView(customView);

        AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        Button confirmButton = customView.findViewById(R.id.dialog_btn_confirm);
        confirmButton.setOnClickListener(v -> {
            deleteUser();
            dialog.dismiss();
        });

        Button cancelButton = customView.findViewById(R.id.dialog_btn_cancel);
        cancelButton.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }

    private void deleteUser() {
        if (id == null || id.isEmpty()) {
            Toast.makeText(this, "ID do usuário não encontrado", Toast.LENGTH_SHORT).show();
            return;
        }

        connectionFactory.delete(id, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(() -> Toast.makeText(EditarPerfil.this, "Erro ao deletar usuário", Toast.LENGTH_SHORT).show());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                runOnUiThread(() -> {
                    if (response.isSuccessful()) {
                        Toast.makeText(EditarPerfil.this, "Usuário deletado com sucesso", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(EditarPerfil.this, Login.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(EditarPerfil.this, "Falha ao deletar usuário", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
