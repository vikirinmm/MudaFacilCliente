package com.example.mudafacil;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
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
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class TelaPrincipal extends AppCompatActivity implements OnMapReadyCallback {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private MapView mapView;
    private GoogleMap googleMap;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private FusedLocationProviderClient locationClient;


    private RecyclerView tela_principalRecyclerView;
    private  Tela_Principal_Adapter tela_principal_Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.tela_principal);



        ImageView pesquisar = findViewById(R.id.lupa);

        pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logoutIntent = new Intent(TelaPrincipal.this, Mapa.class); // Supondo que LoginActivity é sua tela de login
                startActivity(logoutIntent);
            }
        });


        //lista
        tela_principalRecyclerView = findViewById(R.id.lista_recentes);
        tela_principalRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Exemplo de dados
        ArrayList<Tela_Principal_Model> tela_principalModel = new ArrayList<>();
        tela_principalModel.add(new Tela_Principal_Model("Lugar", "Endereço detalhado"));
        tela_principalModel.add(new Tela_Principal_Model("Lugar", "Endereço detalhado"));
        tela_principalModel.add(new Tela_Principal_Model("Lugar", "Endereço detalhado"));
        tela_principalModel.add(new Tela_Principal_Model("Lugar", "Endereço detalhado"));
        tela_principalModel.add(new Tela_Principal_Model("Lugar", "Endereço detalhado"));
        tela_principalModel.add(new Tela_Principal_Model("Lugar", "Endereço detalhado"));
        tela_principalModel.add(new Tela_Principal_Model("Lugar", "Endereço detalhado"));
        tela_principalModel.add(new Tela_Principal_Model("Lugar", "Endereço detalhado"));


        tela_principal_Adapter = new Tela_Principal_Adapter(tela_principalModel);
        tela_principalRecyclerView.setAdapter(tela_principal_Adapter);
        //lista











        locationClient = LocationServices.getFusedLocationProviderClient(this);
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        setupNavigationView();
        View mapa = findViewById(R.id.view4);
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implemente o logout ou fechamento da atividade
                Intent logoutIntent = new Intent(TelaPrincipal.this, Mapa.class); // Supondo que LoginActivity é sua tela de login
                startActivity(logoutIntent);
            }
        });

        //hunburquer
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        View headerView = navigationView.getHeaderView(0);
        // Configurando o TextView 'sair'
        TextView sairTextView = headerView.findViewById(R.id.sair);
        sairTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implemente o logout ou fechamento da atividade
                Intent logoutIntent = new Intent(TelaPrincipal.this, Login.class); // Supondo que LoginActivity é sua tela de login
                logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(logoutIntent);
                finish(); // Encerra a atividade atual
            }
        });

        TextView pagamento = headerView.findViewById(R.id.pagamentos);
        pagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implemente o logout ou fechamento da atividade
                Intent logoutIntent = new Intent(TelaPrincipal.this, Pagamentos.class); // Supondo que LoginActivity é sua tela de login
                logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(logoutIntent);
            }
        });

        TextView sevirco = headerView.findViewById(R.id.servico);
        sevirco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implemente o logout ou fechamento da atividade
                Intent logoutIntent = new Intent(TelaPrincipal.this, Servico.class); // Supondo que LoginActivity é sua tela de login
                logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(logoutIntent);
            }
        });
    }

    private void setupNavigationView() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        ImageView menuButton = findViewById(R.id.Barra_de_menu);
        menuButton.setOnClickListener(v -> toggleDrawer());
    }

    private void toggleDrawer() {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.openDrawer(GravityCompat.START);
        } else {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    //hunburquer


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
