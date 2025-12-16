package com.example.projetfinale.repositories;

import com.example.projetfinale.models.trajet.TrajetVol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetVolRepository extends JpaRepository<TrajetVol, Integer> {
}
