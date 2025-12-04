package com.example.projetfinale.repositories;

import com.example.projetfinale.models.trajet.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FabriqueTrajet extends JpaRepository<Trajet, String> {
    List<Trajet> findTrainsByType(int attr0, int attr1, String attr2);
}
