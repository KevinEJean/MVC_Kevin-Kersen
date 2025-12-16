package com.example.projetfinale.models.trajet;

import com.example.projetfinale.models.Aeroport;
import com.example.projetfinale.models.Operateur;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("vol")
public class TrajetVol extends Trajet {

    public TrajetVol(String numero, Aeroport origineId, Aeroport destinationId, Operateur operateurId, String date, String duree, String heureArriver, String heureDepart) {
        super(numero, origineId, destinationId, operateurId, date, duree, heureArriver, heureDepart);
    }

    public TrajetVol() {
        super();
    }

    public TrajetVol(String numero, Aeroport origine, Aeroport destination, String durree, int id) {
    }
}