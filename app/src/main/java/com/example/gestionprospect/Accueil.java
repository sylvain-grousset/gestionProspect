package com.example.gestionprospect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionprospect.Database.DatabaseHelper;
import com.example.gestionprospect.Model.GestionProspect;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.io.Serializable;
import java.util.ArrayList;

public class Accueil extends AppCompatActivity implements Serializable {

    private Button nouvelleEntreprise;
    private Button nouveauProspect;
    private MaterialSpinner spinner_entreprise;

    DatabaseHelper db = new DatabaseHelper(this);

    private GestionProspect application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        spinner_entreprise = (MaterialSpinner) findViewById(R.id.spinner_entreprise);
        nouveauProspect = (Button) findViewById(R.id.btn_new_prospect);
        nouvelleEntreprise = (Button) findViewById(R.id.btn_new_entreprise);

        //On récupère l'objet GestionProspect à partir de l'Intent que l'on met dans l'attribut "application".
        Intent intent = getIntent();
        this.application = (GestionProspect) intent.getSerializableExtra("gestionProspect");
        //this.db = (DatabaseHelper) intent.getSerializableExtra("BDD");


        ArrayList<String> lesEntreprises = db.getNameEntreprise();
        spinner_entreprise.setItems(lesEntreprises);

        nouveauProspect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Accueil.this, CreateProspect.class);
                intent.putExtra("gestionProspect", application);
                startActivity(intent);
                finish();
            }
        });

        nouvelleEntreprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Accueil.this, CreateEntreprise.class);
                intent.putExtra("gestionProspect", application);
                startActivity(intent);
                finish();
            }
        });
    }

}
