package com.example.gestionprospect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

import com.example.gestionprospect.Control.Control;
import com.example.gestionprospect.Model.AccesLocal;

public class MainActivity extends AppCompatActivity {

    private AccesLocal accesLocal;

    private TextView textViewLogin;
    private TextView textViewMDP;

    private Control control = new Control();

    private TextView login;
    private TextView password;
    private Button validate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accesLocal = new AccesLocal(this);

        accesLocal.ajout();

        //Liens entre graphique/variable
        login = (TextView) findViewById(R.id.editTextLogin);
        password = (TextView) findViewById(R.id.editTextPassword);
        validate = (Button) findViewById(R.id.btn_Validate);

        //Quand on click sur le bouton --> méthode connection
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accesLocal.checkConnexion(login.getText().toString(), password.getText().toString());
            }
        });


    }

    //vérifie le login et MDP de l'utilisateur
    public void connection(String login, String password){

        //control.connexion(login, password);
       /* if(control.connexion(login, password) == true){
             Intent intent=new Intent(this, Accueil.class);
             startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "Login/MDP INCORRECT", Toast.LENGTH_SHORT).show();
        }
        */




    }



}
