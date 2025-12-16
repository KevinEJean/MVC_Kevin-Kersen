package com.example.projetfinale.repositories;

import com.example.projetfinale.models.Operateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperateurRepository extends JpaRepository<Operateur, Integer> {
}
