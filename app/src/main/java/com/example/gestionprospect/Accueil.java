package com.example.gestionprospect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Accueil extends AppCompatActivity {

    private Button nouveau;
    private Spinner spinner_evenement;
    private Spinner spinner_entreprise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        //Liens entre graphique/variable
        spinner_evenement = (Spinner) findViewById(R.id.spinner_evenement);
        spinner_entreprise = (Spinner) findViewById(R.id.spinner_entreprise);
        nouveau = (Button) findViewById(R.id.btn_nouveau);

/*
        //Ajout ds une arrayList les éléments que l'on va mettre ds la ListView
        ArrayList<String> items = new ArrayList<>();
        items.add("Conduent");
        items.add("Cari Electronic");
        items.add("Banque de France");

        //Blabla pr ajouter dans la ListView
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, items);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_evenement.setAdapter(arrayAdapter);
*/
        //Au click du bouton --> on ouvre l'activité Nouveau
        nouveau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Accueil.this, Nouveau.class);
                startActivity(intent);
            }
        });
/*
        //Quand on clique sur un item de la listView
        spinner_evenement.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + tutorialsName,          Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
         */
    }
}
