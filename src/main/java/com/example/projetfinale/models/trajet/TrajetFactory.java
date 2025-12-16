package com.example.projetfinale.models.trajet;

import org.springframework.stereotype.Component;

@Component
public class TrajetFactory {

    public Trajet createTrajet(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }

        switch (type.toUpperCase().trim()) {
            case "TRAIN":
                return new TrajetTrain();
            case "VOL":
                return new TrajetVol();
            default:
                throw new IllegalArgumentException("Unknown trajet type: " + type);
        }
    }
}
