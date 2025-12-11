package com.example.projetfinale.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class RegistreOffres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private List<Offres> listeOffres;
    private static RegistreOffres instance = new RegistreOffres();

    private RegistreOffres() {}

    public static RegistreOffres getInstance() {
        if (instance == null) {
            instance = new RegistreOffres();
        }
        return instance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Offres> getListeOffres() {
        return listeOffres;
    }

    public void setListeOffres(List<Offres> listeOffreses) {
        this.listeOffres = listeOffreses;
    }
}
