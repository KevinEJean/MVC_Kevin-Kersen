package com.example.projetfinale.repositories;

import com.example.projetfinale.models.Vols;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolsRepo extends JpaRepository<Vols, Long> {
    List<Vols> searchAllBy(int origine_id, int destination_id, String date, String section);
}
