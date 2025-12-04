package com.example.projetfinale.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Offre {

    @Id
    private Long id;
    private int trajet_id;
    private int operateur_id;
    private double depart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public double getDepart() {
        return depart;
    }

    public void setDepart(double depart) {
        this.depart = depart;
    }
}
