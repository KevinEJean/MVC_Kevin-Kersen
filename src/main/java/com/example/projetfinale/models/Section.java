package com.example.projetfinale.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Section {

    @Id
    private String id;
    private enum section {
        F,
        A,
        P,
        E
    }
}
