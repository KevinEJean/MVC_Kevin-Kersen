package com.example.projetfinale.models;

import jakarta.persistence.*;

@Entity
@Table(name = "terminal")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_terminal", discriminatorType = DiscriminatorType.STRING)
public abstract class Terminal {

    public Terminal(String code, String ville) {
        this.code = code;
        this.ville = ville;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String ville;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
