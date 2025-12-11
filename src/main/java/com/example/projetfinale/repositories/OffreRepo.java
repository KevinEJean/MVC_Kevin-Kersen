package com.example.projetfinale.repositories;

import com.example.projetfinale.models.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffreRepo extends JpaRepository<Offre, Long> {
    List<Offre> getAll();
}
