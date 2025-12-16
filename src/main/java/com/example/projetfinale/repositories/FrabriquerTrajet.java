package com.example.projetfinale.repositories;

import com.example.projetfinale.models.trajet.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrabriquerTrajet extends JpaRepository<Trajet, Integer> {
}
