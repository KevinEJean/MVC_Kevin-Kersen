package com.example.projetfinale.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sieges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean estReserver;
    private int numeroSiege;
    private String section;
    private enum preferenceSiege {
        FENETRE,
        COULOIR,
        AUCUN
    }
    private enum ColoneSiege {
        A,
        B,
        C,
        D,
        E,
        F,
        G,
        H,
        I,
        J
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEstReserver() {
        return estReserver;
    }

    public void setEstReserver(boolean estReserver) {
        this.estReserver = estReserver;
    }

    public int getNumeroSiege() {
        return numeroSiege;
    }

    public void setNumeroSiege(int numeroSiege) {
        this.numeroSiege = numeroSiege;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
