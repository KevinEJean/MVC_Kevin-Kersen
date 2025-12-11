package com.example.projetfinale.services;

import com.example.projetfinale.models.Offres;
import com.example.projetfinale.models.SearchCriteriaDTO;
import com.example.projetfinale.repositories.StrategieRechercheOffres;
import com.example.projetfinale.repositories.OffresRepository;
import com.example.projetfinale.models.trajet.TypeTrajet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RechercheOffresVol implements StrategieRechercheOffres {

    private final OffresRepository trajetRepository;
    RechercheOffresVol(OffresRepository trajetRepository) {
        this.trajetRepository = trajetRepository;
    }

    @Override
    public boolean appliesTo(TypeTrajet type) {
        return type == TypeTrajet.VOL;
    }

    @Override
    public List<Offres> search(SearchCriteriaDTO criteria) {
        if (criteria.getOrigineId() == null || criteria.getDestinationId() == null || criteria.getDate() == null) {
            throw new IllegalArgumentException("Invalid search criteria");
        }
        return trajetRepository.findVolsByType(
                criteria.getOrigineId(), criteria.getDestinationId(), criteria.getDate()
        );
    }
}
