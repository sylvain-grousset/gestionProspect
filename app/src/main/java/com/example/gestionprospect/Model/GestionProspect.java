package com.example.gestionprospect.Model;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

public class GestionProspect implements Serializable {

    private ArrayList<Entreprise> lesEntreprises = new ArrayList<Entreprise>();
    private ArrayList<Prospect> lesProspects = new ArrayList<Prospect>();

    public GestionProspect(){

    }

    public void addProspect(String nom, String prenom, String phone, String email, String entreprise){
        Prospect a = new Prospect(nom, prenom, phone, email, entreprise);
        lesProspects.add(a);
    }

    public void addEntreprise(String raisonSocial, int siret){
        Entreprise a = new Entreprise(raisonSocial, siret);
        lesEntreprises.add(a);
    }

    public ArrayList<Entreprise> getLesEntreprises() {
        return lesEntreprises;
    }

    public void setLesEntreprises(ArrayList<Entreprise> lesEntreprises) {
        this.lesEntreprises = lesEntreprises;
    }

    public ArrayList<Prospect> getLesProspects() {
        return lesProspects;
    }

    public void setLesProspects(ArrayList<Prospect> lesProspects) {
        this.lesProspects = lesProspects;
    }

    public ArrayList<String> getNomsEntreprises(){
        ArrayList<String> lesNomsEntreprises = new ArrayList<>();

        for(int i=0 ; i<lesEntreprises.size() ; i++){
            lesNomsEntreprises.add(lesEntreprises.get(i).getRaisonSocial());
        }
        return lesNomsEntreprises;
    }

}
