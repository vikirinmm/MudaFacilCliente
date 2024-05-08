package com.example.mudafacil;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Opcao_Veiculos extends AppCompatActivity {
    private boolean isMenuVisible = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.opcao_veiculos);

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

    }
}
