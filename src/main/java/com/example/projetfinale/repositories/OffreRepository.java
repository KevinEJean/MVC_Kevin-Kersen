package com.example.projetfinale.repositories;

import com.example.projetfinale.models.Offres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OffreRepository extends JpaRepository<Offres, Integer> {
}
