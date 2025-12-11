package com.example.projetfinale.models;

import com.example.projetfinale.models.trajet.Trajet;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Offres {

    public Offres() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "trajet_id", referencedColumnName = "id")
    private Trajet trajet;

    @ManyToOne
    @JoinColumn(name = "operateur_id", referencedColumnName = "id")
    private Operateur operateur;

    private String depart;
    private double prixBase;

    @ManyToOne
    @JoinColumn(name = "sieges_id", referencedColumnName = "id")
    private Sieges sieges;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    public Operateur getOperateur() {
        return operateur;
    }

    public void setOperateur(Operateur operateur) {
        this.operateur = operateur;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public double getPrixBase() {
        return prixBase;
    }

    public void setPrixBase(double prixBase) {
        this.prixBase = prixBase;
    }

    public Sieges getSieges() {
        return sieges;
    }

    public void setSieges(Sieges sieges) {
        this.sieges = sieges;
    }
}