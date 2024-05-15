package com.example.mudafacil;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Mapa extends AppCompatActivity implements OnMapReadyCallback {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private MapView mapView;
    private GoogleMap googleMap;
    private FusedLocationProviderClient locationClient;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.mapa);

        locationClient = LocationServices.getFusedLocationProviderClient(this);
        mapView = findViewById(R.id.mapView2);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        EditText textopesquisa = findViewById(R.id.textopesquisa);
        textopesquisa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    showPopupWindow();
                } else {
                    if (popupWindow != null) {
                        popupWindow.dismiss();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Voltar
        ImageView voltar = findViewById(R.id.voltar_mapa);
        voltar.setOnClickListener(v -> {
            Intent main = new Intent(Mapa.this, TelaPrincipal.class);
            startActivity(main);
        });

        // Chamar veículos
        TextView veiculos = findViewById(R.id.chamar);
        veiculos.setOnClickListener(v -> {
            Intent main = new Intent(Mapa.this, Opcao_Veiculos.class);
            startActivity(main);
        });
    }

    private void showPopupWindow() {
        // Inflar o layout personalizado
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.menu_suspenso, null);

        // Criar o PopupWindow
        popupWindow = new PopupWindow(popupView, DrawerLayout.LayoutParams.MATCH_PARENT, DrawerLayout.LayoutParams.WRAP_CONTENT, true);

        // Configurar PopupWindow para não focável e permitir toque fora dela
        popupWindow.setFocusable(false);
        popupWindow.setOutsideTouchable(true);

        // Exibir o PopupWindow abaixo do cabeçalho
        View cabecalho = findViewById(R.id.cabecalho);
        int[] location = new int[2];
        cabecalho.getLocationOnScreen(location);
        int yOffset = location[1] + cabecalho.getHeight() - 20;

        // Adicionar um deslocamento para garantir que o popup apareça abaixo do cabeçalho
        yOffset += 10; // Ajuste este valor conforme necessário para espaçar o popup do cabeçalho

        popupWindow.showAtLocation(cabecalho, Gravity.TOP | Gravity.START, 0, yOffset);

        // Configurar o RecyclerView
        RecyclerView recyclerView = popupView.findViewById(R.id.listapersquisa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Exemplo de dados para a lista
        List<PesquisaItem> pesquisaItems = new ArrayList<>();
        pesquisaItems.add(new PesquisaItem("Item 1"));
        pesquisaItems.add(new PesquisaItem("Item 2"));
        pesquisaItems.add(new PesquisaItem("Item 3"));
        pesquisaItems.add(new PesquisaItem("Item 1"));
        pesquisaItems.add(new PesquisaItem("Item 2"));
        pesquisaItems.add(new PesquisaItem("Item 3"));
        pesquisaItems.add(new PesquisaItem("Item 1"));
        pesquisaItems.add(new PesquisaItem("Item 2"));
        pesquisaItems.add(new PesquisaItem("Item 3"));


        PesquisaAdapter adapter = new PesquisaAdapter(pesquisaItems);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;
        enableMyLocation();
    }

    private void enableMyLocation() {
        if (checkLocationPermission()) {
            googleMap.setMyLocationEnabled(true);
            getLastLocation();
        } else {
            requestLocationPermission();
        }
    }

    private boolean checkLocationPermission() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestLocationPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                LOCATION_PERMISSION_REQUEST_CODE);
    }

    private void getLastLocation() {
        if (checkLocationPermission()) {
            locationClient.getLastLocation()
                    .addOnSuccessListener(this, location -> {
                        if (location != null) {
                            LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());
                            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 15));
                        }
                    });
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                enableMyLocation();
            } else {
                Toast.makeText(this, "Permissão negada.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        mapView.onLowMemory();
    }
}
