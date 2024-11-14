package com.example.pt5_bertomeusayed_jaume;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.preference.PreferenceManager;

import java.util.HashSet;
import java.util.Set;

public class MostrarOpcionesActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mostrar_opciones);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String nombreCognoms = sharedPreferences.getString("name", "No definido");
        Set<String> racesPreferides = sharedPreferences.getStringSet("star_wars_races", new HashSet<>());
        boolean notificacionNoticias = sharedPreferences.getBoolean("star_wars_notifications", false);
        String peliculaPreferida = sharedPreferences.getString("favorite_star_wars_movie", "No seleccionada");

        TextView nombreCognomsTextView = findViewById(R.id.nombreCognomsTextView);
        TextView racesPreferidesTextView = findViewById(R.id.racesPreferidesTextView);
        TextView notificacionNoticiasTextView = findViewById(R.id.notificacionNoticiasTextView);
        TextView peliculaPreferidaTextView = findViewById(R.id.peliculaPreferidaTextView);

        nombreCognomsTextView.setText("Nombre y Apellidos: " + nombreCognoms);
        racesPreferidesTextView.setText("Razas Preferidas: " + racesPreferides.toString());
        notificacionNoticiasTextView.setText("Notificación de Noticias: " + (notificacionNoticias ? "Activado" : "Desactivado"));
        peliculaPreferidaTextView.setText("Película Favorita: " + peliculaPreferida);
    }
}