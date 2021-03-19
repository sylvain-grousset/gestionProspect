package com.example.gestionprospect;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionprospect.Model.Entreprise;
import com.example.gestionprospect.Model.GestionProspect;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Accueil extends AppCompatActivity {

    private Button nouveau;
    private Spinner spinner_evenement;
    private MaterialSpinner spinner_entreprise;

    private GestionProspect application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        spinner_evenement = (Spinner) findViewById(R.id.spinner_evenement);
        spinner_entreprise = (MaterialSpinner) findViewById(R.id.spinner_entreprise);
        nouveau = (Button) findViewById(R.id.btn_nouveau);

        //On récupère l'objet GestionProspect à partir de l'Intent que l'on met dans l'attribut "application".
        Intent intent = getIntent();
        this.application = (GestionProspect) intent.getSerializableExtra("gestionProspect");


        ArrayList<String> lesEntreprises = application.getNomsEntreprises();
        spinner_entreprise.setItems(lesEntreprises);

        nouveau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Accueil.this, Nouveau.class);
                intent.putExtra("gestionProspect", application);
                startActivity(intent);
            }
        });
    }
}
