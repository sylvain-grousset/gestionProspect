package com.example.gestionprospect.Database;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.gestionprospect.Model.Entreprise;
import com.example.gestionprospect.Model.GestionProspect;
import com.example.gestionprospect.Model.Prospect;

import java.io.Serializable;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper implements Serializable {

    private String TABLE_USERS = "CREATE TABLE USERS ("
            + "login TEXT PRIMARY KEY,"
            + "password TEXT);";

    private String TABLE_ENTREPRISE = "CREATE TABLE ENTREPRISE ("
            + "raisonSociale TEXT PRIMARY KEY,"
            + "siren TEXT);";

    private String TABLE_PROSPECT = "CREATE TABLE PROSPECT ("
            + "nom TEXT,"
            + "prenom TEXT,"
            + "phone TEXT,"
            + "email TEXT,"
            + "entreprise TEXT,"
            + "FOREIGN KEY (entreprise) REFERENCES ENTREPRISE(raisonSociale));";

    public DatabaseHelper(Context context) {
        super(context, "prospect.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_USERS);
        db.execSQL(TABLE_ENTREPRISE);
        db.execSQL(TABLE_PROSPECT);
        Intent intent = new Intent();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USERS,"
                + "DROP TABLE IF EXISTS PROSPECT,"
                + "DROP TABLE IF EXISTS ENTREPRISE;");
        onCreate(db);
    }

    //**************************************BOUCHON POUR CREER DES UTILISATEURS ; ENTREPRISES ; PROSPECT*************************************************
    public void createUsers() {
        SQLiteDatabase db = getWritableDatabase();
        // String query = "INSERT INTO USERS VALUES ('SGROUSSET', 'bpsen');";
        ContentValues cv = new ContentValues();
        cv.put("login", "SGROUSSET");
        cv.put("password", "bpsen");
        db.insert("USERS", null, cv);
        //db.execSQL(query);
    }

    public void createEntreprise(){
        SQLiteDatabase db = getWritableDatabase();
        String query = "INSERT INTO ENTREPRISE VALUES ('Cari Electronic', 12345676432), " +
                "('SpaceX', 345654387), " +
                "('Apple', 86996476569);";
        db.execSQL(query);
    }

    public void createProspect(){
        SQLiteDatabase db = getWritableDatabase();
        String query = "INSERT INTO PROSPECT VALUES ('GROUSSET', 'Sylvain', '0645288407', 'sylvain.grou@hotmail.fr', 'Cari Electronic'), " +
                "('GUEISSAZ', 'Emmanuel', '0785465254', 'gueissazmanu@gmail.com', 'SpaceX'), " +
                "('TEYSSERE', 'Karina', '0609508070', 'karinateyssere@gmail.com', 'Apple');";
        db.execSQL(query);

    }
    //**************************************FIN BOUCHON**************************************************************************************************


    /**
     * <p>Récupère le mot de passe de l'utilisateur qui demande à se connecter</p>
     *
     * @param login
     * @return String mdp
     */
    public String getPassword(String login) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT password FROM USERS WHERE login = '" + login + "';", null);
        cursor.moveToFirst();
        return cursor.getString(0);

    }

    /**
     * <p>Insère les prospects dans la base de données</p>
     *
     * @param nom
     * @param prenom
     * @param phone
     * @param email
     * @return boolean
     */
    public boolean insertProspect(String nom, String prenom, String phone, String email, String entreprise) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nom", nom);
        cv.put("prenom", prenom);
        cv.put("phone", phone);
        cv.put("email", email);
        cv.put("entreprise", entreprise);
        try{
            db.insertOrThrow("prospect", null, cv);
            return true;
        }catch (Exception err){
            return false;
        }

    }

    /**
     *<p>Insère les entreprises dans la table ENTREPRISE</p>
     * @param raisonSociale
     * @param siren
     * @return boolean
     */
    public boolean insertEntreprise(String raisonSociale, String siren) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("raisonSociale", raisonSociale);
        cv.put("siren", siren);
        try {
            db.insertOrThrow("ENTREPRISE", null, cv);
            return true;
        }catch (Exception err){
            return false;
        }

        //String query = "INSERT INTO ENTREPRISE VALUES ('" + raisonSociale + "', '" + siren + "');";
        //db.execSQL(query);

    }

    /**
     * <p>Retourne tous les noms d'entreprises</p>
     * @return ArrayList
     */
    public ArrayList<String> getNameEntreprise(){
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<String> entreprise = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM ENTREPRISE;", null);
        cursor.moveToFirst();

        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){

                String raisonSociale = cursor.getString(cursor.getColumnIndex("raisonSociale"));
                String siren = cursor.getString((cursor.getColumnIndex("siren")));

                entreprise.add(raisonSociale);
                cursor.moveToNext();

            }
        }
        return entreprise;
    }

    /**
     * <p>Liste de prospect pour peupler la table</p>
     * @return ArrayList<Prospect>
     */
    public ArrayList<Prospect> getProspectForTable(){
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<Prospect> a = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT nom, prenom, entreprise FROM PROSPECT ORDER BY nom;", null);

        cursor.moveToFirst();
        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                String nom = cursor.getString(cursor.getColumnIndex("nom"));
                String prenom = cursor.getString(cursor.getColumnIndex("prenom"));
                String entreprise = cursor.getString(cursor.getColumnIndex("entreprise"));

                Prospect prospect = new Prospect(nom, prenom, entreprise);
                a.add(prospect);
                cursor.moveToNext();
            }
        }
        return a;
    }

    /**
     * <p>Liste de prospect trié par entreprise pour peupler la table</p>
     * @param company
     * @return ArrayList<Prospect>
     */
    public ArrayList<Prospect> getProspectForTableSortedByEntreprise(String company){
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<Prospect> a = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT nom, prenom, entreprise FROM PROSPECT WHERE entreprise = '" + company + "';", null);


        cursor.moveToFirst();
        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                String nom = cursor.getString(cursor.getColumnIndex("nom"));
                String prenom = cursor.getString(cursor.getColumnIndex("prenom"));
                String entreprise = cursor.getString(cursor.getColumnIndex("entreprise"));

                Prospect prospect = new Prospect(nom, prenom, entreprise);
                a.add(prospect);
                cursor.moveToNext();
            }
        }
        return a;
    }


}
