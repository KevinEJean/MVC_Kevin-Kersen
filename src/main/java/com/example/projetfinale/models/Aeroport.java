package com.example.projetfinale.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

    @Id
    private String code;
    private String ville;

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

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
