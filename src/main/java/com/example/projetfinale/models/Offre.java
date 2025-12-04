package com.example.projetfinale.models;

import jakarta.persistence.*;

@Entity
public class Offre {

    @Id
    @GeneratedValue
    private int id;
    private int trajet_id;
    private int operateur_id;
    private String depart;
    private double prix_base;
    @ManyToOne
    @JoinColumn(name = "siege_id")
    private Sieges sieges;

    public Sieges getSieges() {
        return sieges;
    }

    public void setSieges(Sieges sieges) {
        this.sieges = sieges;
    }

    public double getPrix_base() {
        return prix_base;
    }

    public void setPrix_base(double prix_base) {
        this.prix_base = prix_base;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrajet_id() {
        return trajet_id;
    }

    public void setTrajet_id(int trajet_id) {
        this.trajet_id = trajet_id;
    }

    public int getOperateur_id() {
        return operateur_id;
    }

    public void setOperateur_id(int operateur_id) {
        this.operateur_id = operateur_id;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }
}