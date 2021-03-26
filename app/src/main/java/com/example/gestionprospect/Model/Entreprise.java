package com.example.gestionprospect.Model;

import java.io.Serializable;

public class Entreprise implements Serializable {

    private String raisonSocial;
    private String siren;

    public Entreprise(String raisonSocial, String siren){
        this.raisonSocial = raisonSocial;
        this.siren = siren;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public String getSiren() {
        return siren;
    }

    public void setSiren(String siren) {
        this.siren = siren;
    }
}
