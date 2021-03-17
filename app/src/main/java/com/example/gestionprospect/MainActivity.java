package com.example.gestionprospect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BlendMode;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

import com.example.gestionprospect.Database.DatabaseHelper;
import com.example.gestionprospect.Model.Entreprise;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;

    private TextView login;
    private TextView password;
    private Button validate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        //db.createUsers();

        login = (TextView) findViewById(R.id.editTextLogin);
        password = (TextView) findViewById(R.id.editTextPassword);
        validate = (Button) findViewById(R.id.btn_Validate);

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connection(login.getText().toString(), password.getText().toString());
            }
        });


    }

    //vérifie le login et MDP de l'utilisateur
    public void connection(String loginUtilisateur, String mdp){

        if (db.getPassword(loginUtilisateur).compareTo(mdp) == 0) {
            Intent intent = new Intent(this, Accueil.class);
            startActivity(intent);
        } else {
            password.setText("");
            login.setText("");
            Toast.makeText(getApplicationContext(), "Login/MDP INCORRECT", Toast.LENGTH_SHORT).show();

        }
    }



}
