package com.example.gestionprospect;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionprospect.Database.DatabaseHelper;

public class Nouveau extends AppCompatActivity {

    private TextView nom;
    private TextView prenom;
    private TextView phone;
    private TextView email;
    private TextView notes;
    private Button enregistrer;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau);

        db = new DatabaseHelper(this);

        nom = (TextView) findViewById(R.id.editTextName);
        prenom = (TextView) findViewById(R.id.editTextPrenom);
        phone = (TextView) findViewById(R.id.editTextPhone);
        email = (TextView) findViewById(R.id.editTextEmail);
        notes = (TextView) findViewById(R.id.editTextNotes);
        enregistrer = (Button) findViewById(R.id.btn_enregistrer);

       enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insertProspect(nom.getText().toString(), prenom.getText().toString(), phone.getText().toString(), email.getText().toString());
            }
        });

    }
}
