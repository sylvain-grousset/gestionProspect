package com.example.gestionprospect.Model;

public class Prospect {

    private String nom;
    private String prenom;
    private String phone;
    private String email;
    private String notes;
    private Entreprise entreprise;

    public Prospect(String nom, String prenom, String phone, String email, String notes){
        this.nom = nom;
        this.prenom = prenom;
        this.phone = phone;
        this.email = email;
        this.notes = notes;
    }

    public Prospect(String nom, String prenom, String phone, String email){
        this.nom = nom;
        this.prenom = prenom;
        this.phone = phone;
        this.email = email;
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

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }
}