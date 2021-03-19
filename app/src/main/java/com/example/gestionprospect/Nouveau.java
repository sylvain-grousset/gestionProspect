package com.example.gestionprospect;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionprospect.Database.DatabaseHelper;
import com.example.gestionprospect.Model.GestionProspect;
import com.example.gestionprospect.Model.Prospect;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;

public class Nouveau extends AppCompatActivity {

    private TextView nom;
    private TextView prenom;
    private TextView phone;
    private TextView email;
    private TextView notes;
    private Button enregistrer;
    private MaterialSpinner spinner_entreprise;

    private GestionProspect application;
    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau);

        nom = (TextView) findViewById(R.id.editTextName);
        prenom = (TextView) findViewById(R.id.editTextPrenom);
        phone = (TextView) findViewById(R.id.editTextPhone);
        email = (TextView) findViewById(R.id.editTextEmail);
        notes = (TextView) findViewById(R.id.editTextNotes);
        enregistrer = (Button) findViewById(R.id.btn_enregistrer);
        spinner_entreprise = (MaterialSpinner) findViewById(R.id.spinner_entreprise);

        //On récupère l'objet GestionProspect à partir de l'Intent que l'on met dans l'attribut "application".
        Intent intent = getIntent();
        this.application = (GestionProspect) intent.getSerializableExtra("gestionProspect");



        ArrayList<String> lesEntreprises = application.getNomsEntreprises();
        spinner_entreprise.setItems(lesEntreprises);

        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ajout du prospect dans la base de données
                db.insertProspect(nom.getText().toString(), prenom.getText().toString(), phone.getText().toString(), email.getText().toString(), spinner_entreprise.getText().toString());

                //Ajout du prospect dans la classe Prospect
                application.addProspect(nom.getText().toString(), prenom.getText().toString(), phone.getText().toString(), email.getText().toString(), spinner_entreprise.getText().toString());
            }
        });

    }
}
