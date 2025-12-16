package com.example.projetfinale.models;

import jakarta.persistence.*;

@Entity
public class Siege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public enum StatutSiege {
        DISPONIBLE,
        RESERVE,
        VENDU
    }

    @Enumerated(EnumType.STRING)
    private StatutSiege statut = StatutSiege.DISPONIBLE;

    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offres offre;

    private String section;
    private String numeroSiege;

    public enum PreferenceSiege { FENETRE, COULOIR, AUCUN }
    public enum ColoneSiege { A, B, C, D, E, F, G, H, I, J }

    @Enumerated(EnumType.STRING)
    private PreferenceSiege preference;

    @Enumerated(EnumType.STRING)
    private ColoneSiege colonne;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StatutSiege getStatut() {
        return statut;
    }

    public void setStatut(StatutSiege statut) {
        this.statut = statut;
    }

    public Offres getOffre() {
        return offre;
    }

    public void setOffre(Offres offre) {
        this.offre = offre;
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

    public PreferenceSiege getPreference() {
        return preference;
    }

    public void setPreference(PreferenceSiege preference) {
        this.preference = preference;
    }

    public ColoneSiege getColonne() {
        return colonne;
    }

    public void setColonne(ColoneSiege colonne) {
        this.colonne = colonne;
    }
}
