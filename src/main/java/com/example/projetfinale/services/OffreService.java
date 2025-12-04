package com.example.projetfinale.services;

import com.example.projetfinale.models.Offre;
import com.example.projetfinale.repositories.OffreRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffreService {

    private final OffreRepo repo;
    OffreService(OffreRepo repo) {
        this.repo = repo;
    }

    public List<Offre> getAll() {
        return repo.getAll();
    }
}
