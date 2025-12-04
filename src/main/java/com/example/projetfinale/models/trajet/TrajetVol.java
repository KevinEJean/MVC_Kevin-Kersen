package com.example.projetfinale.models.trajet;

import com.example.projetfinale.models.Aeroport;
import com.example.projetfinale.models.Operateur;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("vol")
public class TrajetVol extends Trajet {

    private String airline;

    public TrajetVol(Aeroport origine, Aeroport destination, Operateur operateur, String date, String duree,
                     String heureArriver, String heureDepart, TypeTrajet type, String airline) {
        super(origine, destination, operateur, date, duree, heureArriver, heureDepart, type);
        this.airline = airline;
    }

    public TrajetVol() {
        super();
    }

    public TrajetVol(Aeroport origineId, Aeroport destinationId, Operateur operateurId, String date, String duree, String heureArriver, String heureDepart, TypeTrajet type) {
        super(origineId, destinationId, operateurId, date, duree, heureArriver, heureDepart, type);
    }
}