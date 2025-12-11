package com.example.projetfinale.repositories;

import com.example.projetfinale.models.Sieges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiegeRepository extends JpaRepository<Sieges, Integer> {
}
