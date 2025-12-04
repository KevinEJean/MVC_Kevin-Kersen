package com.example.projetfinale.models.trajet;

import com.example.projetfinale.models.Aeroport;
import com.example.projetfinale.models.Operateur;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@DiscriminatorValue("train")
public class TrajetTrain extends Trajet {

    @Id
    private String id;

    public TrajetTrain(Aeroport origineId, Aeroport destinationId, Operateur operateurId, String date, String duree, String heureArriver, String heureDepart, TypeTrajet type) {
        super(origineId, destinationId, operateurId, date, duree, heureArriver, heureDepart, type);
    }

    private enum Section {
        F,
        A,
        P,
        E
    };

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
