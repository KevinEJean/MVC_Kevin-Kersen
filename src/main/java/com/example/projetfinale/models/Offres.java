package com.example.projetfinale.models;

import com.example.projetfinale.models.trajet.Trajet;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Offres {

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

    @OneToMany(mappedBy = "offre", cascade = CascadeType.ALL)
    private List<Sieges> sieges;

    public Offres(Trajet trajetId, Operateur operateurId, String depart, double prixBase) {
        this.trajet = trajetId;
        this.operateur = operateurId;
        this.depart = depart;
        this.prixBase = prixBase;
    }

    public Offres() {}

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

    public List<Sieges> getSieges() {
        return sieges;
    }

    public void setSieges(List<Sieges> sieges) {
        this.sieges = sieges;
    }
}