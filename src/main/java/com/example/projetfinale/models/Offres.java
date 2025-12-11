package com.example.projetfinale.models;

import com.example.projetfinale.models.trajet.Trajet;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class Offres {

    private int id;
    private Trajet trajet_id;
    private Operateur operateur_id;
    private String depart;
    private double prix_base;
    private Sieges sieges;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Trajet getTrajet_id() {
        return trajet_id;
    }

    public void setTrajet_id(Trajet trajet_id) {
        this.trajet_id = trajet_id;
    }

    public Operateur getOperateur_id() {
        return operateur_id;
    }

    public void setOperateur_id(Operateur operateur_id) {
        this.operateur_id = operateur_id;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public double getPrix_base() {
        return prix_base;
    }

    public void setPrix_base(double prix_base) {
        this.prix_base = prix_base;
    }

    public Sieges getSieges() {
        return sieges;
    }

    public void setSieges(Sieges sieges) {
        this.sieges = sieges;
    }
}