package com.example.projetfinale.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Operateur {

    @Id
    private String code;
    private String nom;

        return id;
    }

        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}