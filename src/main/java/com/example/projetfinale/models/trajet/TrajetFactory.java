package com.example.projetfinale.models.trajet;

import org.springframework.stereotype.Component;

@Component
public class TrajetFactory {

    public Trajet createTrajet(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }

        switch (type.toUpperCase()) {
            case "TRAIN":
                return new TrajetTrain();
            case "VOL":
                return new TrajetVol();
            default:
                throw new IllegalArgumentException("Unknown trajet type: " + type);
        }
    }
}
