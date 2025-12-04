package com.example.projetfinale.services;

import com.example.projetfinale.models.SearchCriteriaDTO;
import com.example.projetfinale.models.trajet.Trajet;
import com.example.projetfinale.repositories.StrategieRechercheOffres;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceClient {

    private final RechercheOffresTrajetTrain rechercheOffresTrajetTrain;
    public ServiceClient(RechercheOffresTrajetTrain rechercheOffresTrajetTrain) {
        this.rechercheOffresTrajetTrain = rechercheOffresTrajetTrain;
    }

    public List<Trajet> executeSearch(SearchCriteriaDTO criteria) {
        StrategieRechercheOffres strategy = null;

        if (criteria.getOrigineId() != null && criteria.getDestinationId() != null) {
            strategy = rechercheOffresTrajetTrain;
        }

        if (strategy != null) {
            return strategy.search(criteria);
        }

        return List.of();
    }
}
