package com.example.projetfinale.models.trajet;

import com.example.projetfinale.models.Aeroport;
import com.example.projetfinale.models.Operateur;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("vol")
public class TrajetVol extends Trajet {

    public TrajetVol(String numero, Aeroport origine, Aeroport destination, Operateur operateur, String date, String duree, String heureArriver, String heureDepart) {
        super(numero, origine, destination, operateur, date, duree, heureArriver, heureDepart);
    }

    public TrajetVol() {
        super();
    }
}