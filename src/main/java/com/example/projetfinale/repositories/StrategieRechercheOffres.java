package com.example.projetfinale.repositories;

import com.example.projetfinale.models.SearchCriteriaDTO;
import com.example.projetfinale.models.trajet.TypeTrajet;
import com.example.projetfinale.models.Offres;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StrategieRechercheOffres {
    boolean appliesTo(TypeTrajet type);
    List<Offres> search(SearchCriteriaDTO criteria);
}
