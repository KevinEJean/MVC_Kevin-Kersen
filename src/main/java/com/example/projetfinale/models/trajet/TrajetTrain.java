package com.example.projetfinale.models.trajet;

import com.example.projetfinale.models.Aeroport;
import com.example.projetfinale.models.Operateur;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@DiscriminatorValue("train")
public class TrajetTrain extends Trajet {

    public TrajetTrain(String numero, Aeroport origineId, Aeroport destinationId, Operateur operateurId, String date, String duree, String heureArriver, String heureDepart) {
        super(numero, origineId, destinationId, operateurId, date, duree, heureArriver, heureDepart);
    }

    public TrajetTrain() {
        super();
    }

    @Id
    private int id;
    private enum Section {
        F,
        A,
        P,
        E
    };

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
