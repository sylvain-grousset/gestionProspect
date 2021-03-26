package com.example.gestionprospect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BlendMode;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

import com.example.gestionprospect.Database.DatabaseHelper;
import com.example.gestionprospect.Model.Entreprise;
import com.example.gestionprospect.Model.GestionProspect;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable {

    DatabaseHelper db;

    private TextView login;
    private TextView password;
    private Button validate;
    private GestionProspect application = new GestionProspect();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        db.createUsers();


        login = (TextView) findViewById(R.id.editTextLogin);
        password = (TextView) findViewById(R.id.editTextPassword);
        validate = (Button) findViewById(R.id.btn_Validate);

        //A SUPPRIMER QUAND TERMINE
        password.setText("bpsen");
        login.setText("SGROUSSET");


        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    connection(login.getText().toString(), password.getText().toString(), application);
            }
        });


    }

    /**
     * <p>Vérifie la connexion</p>
     * @param loginUtilisateur
     * @param mdp
     * @param application
     */
    public void connection(String loginUtilisateur, String mdp, GestionProspect application){

        if (db.getPassword(loginUtilisateur).compareTo(mdp) == 0) {
            Intent intent = new Intent(this, Accueil.class);
            intent.putExtra("gestionProspect", (Serializable) application);
            //intent.putExtra("BDD", (Serializable) db);
            startActivity(intent);
        } else {
            password.setText("");
            login.setText("");
            Toast.makeText(getApplicationContext(), "Login/MDP INCORRECT", Toast.LENGTH_SHORT).show();

        }
    }



}
