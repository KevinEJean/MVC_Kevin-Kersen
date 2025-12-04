package com.example.projetfinale.models.trajet;

import com.example.projetfinale.models.Aeroport;
import jakarta.persistence.*;

import com.example.projetfinale.models.Terminal;
import com.example.projetfinale.models.Operateur;

@Entity
@Table(name = "trajet")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_trajet", discriminatorType = DiscriminatorType.STRING)
public abstract class Trajet {

    public Trajet(Aeroport origine_id, Aeroport destination_id, Operateur operateur_id, String date, String duree, String heureArriver, String heureDepart) {
        this.origine = origine_id;
        this.destination = destination_id;
        this.operateur = operateur_id;
        this.date = date;
        this.duree = duree;
        this.heureArriver = heureArriver;
        this.heureDepart = heureDepart;
    }

    public Trajet(Aeroport origine, Aeroport destination, Operateur operateur, String date, String duree, String heureArriver, String heureDepart, TypeTrajet type) {
    }

    public Trajet() {
    }

    @Id
    @GeneratedValue
    private String id;
    @ManyToOne
    @JoinColumn(name = "orgine_id", referencedColumnName = "id")
    private Aeroport origine;
    @ManyToOne
    @JoinColumn(name = "destination_id", referencedColumnName = "id")
    private Aeroport destination;
    private String date;
    private String duree;
    private String heureArriver;
    private String heureDepart;
    @ManyToOne
    @JoinColumn(name = "operateur_id", referencedColumnName = "id")
    private Operateur operateur;
    private TypeTrajet type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Terminal getOrigine() {
        return origine;
    }

    public void setOrigine(Aeroport origine) {
        this.origine = origine;
    }

    public Terminal getDestination() {
        return destination;
    }

    public void setDestination(Aeroport destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getHeureArriver() {
        return heureArriver;
    }

    public void setHeureArriver(String heureArriver) {
        this.heureArriver = heureArriver;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public Operateur getOperateur() {
        return operateur;
    }

    public void setOperateur(Operateur operateur) {
        this.operateur = operateur;
    }
}
