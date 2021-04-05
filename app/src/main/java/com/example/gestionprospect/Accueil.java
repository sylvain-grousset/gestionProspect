package com.example.gestionprospect;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionprospect.Database.DatabaseHelper;
import com.example.gestionprospect.Model.GestionProspect;
import com.example.gestionprospect.Model.Prospect;
import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import ir.androidexception.datatable.DataTable;
import ir.androidexception.datatable.model.DataTableHeader;
import ir.androidexception.datatable.model.DataTableRow;

public class Accueil extends AppCompatActivity implements Serializable {

    private Button nouvelleEntreprise;
    private Button nouveauProspect;
    private MaterialSpinner spinner_entreprise;
    private DataTable table;

    DatabaseHelper db = new DatabaseHelper(this);

    private GestionProspect application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        table = (DataTable) findViewById(R.id.data_table);
        spinner_entreprise = (MaterialSpinner) findViewById(R.id.spinner_entreprise);
        nouveauProspect = (Button) findViewById(R.id.btn_new_prospect);
        nouvelleEntreprise = (Button) findViewById(R.id.btn_new_entreprise);

        //On récupère l'objet GestionProspect à partir de l'Intent que l'on met dans l'attribut "application".
        Intent intent = getIntent();
        this.application = (GestionProspect) intent.getSerializableExtra("gestionProspect");


        setTable();

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


        spinner_entreprise.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String itemSelected) {
                setTableByEntreprise(itemSelected);
            }
        });

    }

    /**
     * <p>Initialise la table avec tous les prospects trié par ordre alphabétique</p>
     */
    private void setTable(){
        ArrayList <Prospect> a = db.getProspectForTable();

        DataTableHeader header = new DataTableHeader.Builder()
                .item("Nom", 10)
                .item("Prénom", 10)
                .item("Entreprise", 10)
                .build();

        ArrayList<DataTableRow> rows = new ArrayList<>();
        // define 200 fake rows for table

        for(int j=0 ; j<a.size() ; j++){
            DataTableRow row = new DataTableRow.Builder()
                    .value(a.get(j).getNom())
                    .value(a.get(j).getPrenom())
                    .value(a.get(j).getEntreprise())
                    .build();
            rows.add(row);
        }

        Typeface typeface = Typeface.SERIF;
        table.setTypeface(typeface);
        table.setHeader(header);
        table.setRows(rows);
        table.inflate(this);

    }

    /**
     * <p>Reconstrui la table avec les prospects trié par entreprise</p>
     * @param entreprise
     */
    private void setTableByEntreprise(String entreprise){
        ArrayList <Prospect> a = db.getProspectForTableSortedByEntreprise(entreprise);

        DataTableHeader header = new DataTableHeader.Builder()
                .item("Nom", 10)
                .item("Prénom", 10)
                .item("Entreprise", 10)
                .build();

        ArrayList<DataTableRow> rows = new ArrayList<>();
        // define 200 fake rows for table

        for(int j=0 ; j<a.size() ; j++){
            DataTableRow row = new DataTableRow.Builder()
                    .value(a.get(j).getNom())
                    .value(a.get(j).getPrenom())
                    .value(a.get(j).getEntreprise())
                    .build();
            rows.add(row);
        }

        Typeface typeface = Typeface.SERIF;
        table.setTypeface(typeface);
        table.setHeader(header);
        table.setRows(rows);
        table.inflate(this);

    }

}
