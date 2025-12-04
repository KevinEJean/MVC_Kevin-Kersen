package com.example.projetfinale.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Aeroport {

    @Id
    private Long id;
    private String code;
    private String ville;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
