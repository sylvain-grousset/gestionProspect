package com.example.gestionprospect.Model;

import java.io.Serializable;

public class Prospect implements Serializable {

    private String nom;
    private String prenom;
    private String phone;
    private String email;
    private String notes;
    private String entreprise;


    public Prospect(String nom, String prenom, String phone, String email, String entreprise){
        this.nom = nom;
        this.prenom = prenom;
        this.phone = phone;
        this.email = email;
        this.entreprise = entreprise;
    }

    public Prospect(String nom, String prenom, String entreprise){
        this.nom = nom;
        this.prenom = prenom;
        this.entreprise = entreprise;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }


}
