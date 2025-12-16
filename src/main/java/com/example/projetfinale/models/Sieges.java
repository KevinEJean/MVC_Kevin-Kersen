package com.example.projetfinale.models;

import jakarta.persistence.*;

@Entity
public class Sieges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String statut = "DISPONIBLE";

    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offres offre;

    private String section;
    private String numeroSiege;
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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getNumeroSiege() {
        return numeroSiege;
    }

    public void setNumeroSiege(String numeroSiege) {
        this.numeroSiege = numeroSiege;
    }
}
