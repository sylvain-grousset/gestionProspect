package com.example.gestionprospect.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.gestionprospect.Outil.MySQLiteOpenHelper;

public class AccesLocal {
    private String nomBase = "bdUsers.db";
    private int version = 1;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;

    public AccesLocal(Context context){
        accesBD = new MySQLiteOpenHelper(context, nomBase, null, version);
    }

    public void ajout(){
        bd = accesBD.getWritableDatabase();
        String req = "INSERT INTO USERS VALUES('SGROUSSET', 'bpsen');";
        bd.execSQL(req);
    }

    public void checkConnexion(String login, String password){
        bd = accesBD.getWritableDatabase();
        //Cursor c = bd.rawQuery("SELECT password FROM USERS WHERE login = '" + login + "';", null);

        Log.d("TEST1", c.getString(0));
    }

}
