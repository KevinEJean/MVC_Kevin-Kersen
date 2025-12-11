package com.example.projetfinale.models.trajet;

import com.example.projetfinale.models.Aeroport;
import com.example.projetfinale.models.Sieges;
import jakarta.persistence.*;

import com.example.projetfinale.models.Operateur;

@Entity
@Table(name = "trajet")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_trajet", discriminatorType = DiscriminatorType.STRING)
public class Trajet {

    @Id
    private int id;

    private String numero;

    @ManyToOne
    @JoinColumn(name = "origine_id", referencedColumnName = "id")
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


    public Trajet(String numero, Aeroport origine, Aeroport destination, Operateur operateur, String date, String duree, String heureArriver, String heureDepart) {
        this.numero = numero;
        this.origine = origine;
        this.destination = destination;
        this.operateur = operateur;
        this.date = date;
        this.duree = duree;
        this.heureArriver = heureArriver;
        this.heureDepart = heureDepart;
    }

    public Trajet() {
    }


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aeroport getOrigine() {
        return origine;
    }

    public void setOrigine(Aeroport origine) {
        this.origine = origine;
    }

    public Aeroport getDestination() {
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
