package com.example.gestionprospect.Model;

public class Entreprise {

    private String raisonSocial;
    private int siret;

    public Entreprise(String raisonSocial, int siret){
        this.raisonSocial = raisonSocial;
        this.siret = siret;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public int getSiret() {
        return siret;
    }

    public void setSiret(int siret) {
        this.siret = siret;
    }



}
