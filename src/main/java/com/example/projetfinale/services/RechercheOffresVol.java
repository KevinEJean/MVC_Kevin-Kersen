package com.example.projetfinale.services;

import com.example.projetfinale.models.SearchCriteriaDTO;
import com.example.projetfinale.repositories.StrategieRechercheOffres;
import com.example.projetfinale.models.trajet.Trajet;
import com.example.projetfinale.models.trajet.TypeTrajet;
import com.example.projetfinale.repositories.FabriqueTrajet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RechercheOffresVol implements StrategieRechercheOffres {

    private final FabriqueTrajet trajetRepository;
    RechercheOffresVol(FabriqueTrajet trajetRepository) {
        this.trajetRepository = trajetRepository;
    }

    @Override
    public boolean appliesTo(TypeTrajet type) {
        return type == TypeTrajet.VOL;
    }

    @Override
    public List<Trajet> search(SearchCriteriaDTO criteria) {
        if (criteria.getOrigineId() == null || criteria.getDestinationId() == null || criteria.getDate() == null) {
            throw new IllegalArgumentException("Invalid search criteria");
        }
        return trajetRepository.findTrainsByType(
                criteria.getOrigineId(), criteria.getDestinationId(), criteria.getDate()
        );
    }
}
