package com.example.gestionprospect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.os.Bundle;
import android.database.*;

public class MainActivity extends AppCompatActivity {

    private TextView textViewLogin;
    private TextView textViewMDP;

    private TextView login;
    private TextView password;
    private Button validate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Liens entre graphique/variable
        login = (TextView) findViewById(R.id.editTextLogin);
        password = (TextView) findViewById(R.id.editTextPassword);
        validate = (Button) findViewById(R.id.btn_Validate);
        textViewLogin = (TextView) findViewById(R.id.textViewLogin);
        textViewMDP = (TextView) findViewById(R.id.textViewMDP);

        //Quand on click sur le bouton --> méthode connection
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connection(login.getText().toString(), password.getText().toString());
            }
        });


    }

    public void connection(String login, String password){
        textViewLogin.setText(login);
        textViewMDP.setText(password);

        Intent intent=new Intent(this, Accueil.class);
        startActivity(intent);

    }



}
