package com.example.projetfinale.repositories;

import com.example.projetfinale.models.SearchCriteriaDTO;
import com.example.projetfinale.models.trajet.Trajet;
import com.example.projetfinale.models.trajet.TypeTrajet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StrategieRechercheOffres {

    boolean appliesTo(TypeTrajet type);
    List<Trajet> search(SearchCriteriaDTO criteria);
}
