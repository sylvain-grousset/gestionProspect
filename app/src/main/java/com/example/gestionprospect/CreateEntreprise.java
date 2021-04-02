package com.example.gestionprospect;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionprospect.Database.DatabaseHelper;
import com.example.gestionprospect.Model.Entreprise;
import com.example.gestionprospect.Model.GestionProspect;

import java.io.Serializable;
import java.util.ArrayList;

public class CreateEntreprise extends AppCompatActivity{

    private Button enregistrer;
    private TextView siren;
    private TextView raisonSociale;

    DatabaseHelper db = new DatabaseHelper(this);
    //DatabaseHelper db;

    private GestionProspect application;

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(CreateEntreprise.this, Accueil.class);
        intent.putExtra("gestionProspect", (Serializable) application);
        startActivity(intent);
        super.onBackPressed();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createntreprise);

        enregistrer = (Button) findViewById(R.id.btn_enregistrerEntreprise);
        siren = (TextView) findViewById(R.id.editTextSiren);
        raisonSociale = (TextView) findViewById(R.id.editTextEntreprise);

        //On récupère l'objet GestionProspect à partir de l'Intent que l'on met dans l'attribut "application".
        Intent intent = getIntent();
        this.application = (GestionProspect) intent.getSerializableExtra("gestionProspect");
        //this.db = (DatabaseHelper) intent.getSerializableExtra("BDD");

        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean verif = db.insertEntreprise(raisonSociale.getText().toString(), siren.getText().toString());
                if(verif == true){
                    application.addEntreprise(raisonSociale.getText().toString(), siren.getText().toString());
                    Toast.makeText(CreateEntreprise.this, "Entreprise ajoutée avec succès !", Toast.LENGTH_SHORT).show();
                    siren.setText("");
                    raisonSociale.setText("");
                }else{
                    Toast.makeText(CreateEntreprise.this, "Impossible d'ajouter une entreprise déjà existante !", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
