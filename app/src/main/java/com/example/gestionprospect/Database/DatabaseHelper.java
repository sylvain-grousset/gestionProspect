package com.example.gestionprospect.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gestionprospect.Model.Entreprise;

public class DatabaseHelper extends SQLiteOpenHelper {

    private String TABLE_USERS = "CREATE TABLE USERS ("
            + "login TEXT PRIMARY KEY,"
            + "password TEXT);";

    private String TABLE_PROSPECT = "CREATE TABLE PROSPECT ("
            + "nom TEXT,"
            + "prenom TEXT,"
            + "phone TEXT,"
            + "email TEXT,"
            + "entreprise TEXT);";

    public DatabaseHelper(Context context){
        super(context, "prospect.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_USERS);
        db.execSQL(TABLE_PROSPECT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USERS,"
                 + "DROP TABLE IF EXISTS PROSPECT;");
        onCreate(db);
    }

    /**
     * <p>Récupère le mot de passe de l'utilisateur qui demande à se connecter</p>
     * @param login
     * @return String mdp
     */
    public String getPassword(String login){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT password FROM USERS WHERE login = '" + login + "';", null);
        cursor.moveToFirst();
        return cursor.getString(0);

    }

    //Bouchon pour créer des utilisateurs
    public void createUsers(){
        SQLiteDatabase db = getWritableDatabase();
       // String query = "INSERT INTO USERS VALUES ('SGROUSSET', 'bpsen');";
        ContentValues cv = new ContentValues();
        cv.put("login", "SGROUSSET");
        cv.put("password", "bpsen");
        db.insert("USERS", null, cv);
        //db.execSQL(query);
    }

    /**
     * <p>Insère les prospects dans la base de données</p>
     * @param nom
     * @param prenom
     * @param phone
     * @param email
     */
    public void insertProspect(String nom, String prenom, String phone, String email, String entreprise){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nom", nom);
        cv.put("prenom", prenom);
        cv.put("phone", phone);
        cv.put("email", email);
        cv.put("entreprise", entreprise);
        db.insert("prospect", null, cv);
    }

}
