package com.example.projetfinale.services;

import com.example.projetfinale.models.Offres;
import com.example.projetfinale.models.SearchCriteriaDTO;
import com.example.projetfinale.models.trajet.Trajet;
import com.example.projetfinale.repositories.StrategieRechercheOffres;
import com.example.projetfinale.repositories.OffresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceClient {

    private final RechercheOffresTrajetTrain rechercheOffresTrajetTrain;
    private final StrategieRechercheOffres strategieRechercheOffres;
    private final OffresRepository offresRepository;
    public ServiceClient(RechercheOffresTrajetTrain rechercheOffresTrajetTrain, StrategieRechercheOffres strategieRechercheOffres, OffresRepository offresRepository) {
        this.rechercheOffresTrajetTrain = rechercheOffresTrajetTrain;
        this.strategieRechercheOffres = strategieRechercheOffres;
        this.offresRepository = offresRepository;
    }

    public List<Offres> executeSearch(SearchCriteriaDTO criteria) {
        StrategieRechercheOffres strategy = null;

        if (criteria.getOrigineId() != null && criteria.getDestinationId() != null) {
            strategy = rechercheOffresTrajetTrain;
        }

        if (strategy != null) {
            return strategy.search(criteria);
        }

        return List.of();
    }

    public boolean reserve(int id) {
        try {
            List<Offres> allOfers = offresRepository.getList();
            for (Offres currentOffer : allOfers) {
                if (currentOffer.getId().equals(id)) {
                    if (!currentOffer.getSieges().isEstReserver()) {
                        currentOffer.getSieges().setEstReserver(true);
                        offresRepository.save(currentOffer);
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
