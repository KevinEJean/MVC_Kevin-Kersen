package com.example.projetfinale.services;

import com.example.projetfinale.models.Vols;
import com.example.projetfinale.repositories.VolsRepo;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolsService {

    private final VolsRepo repo;
    VolsService(VolsRepo repo) {
        this.repo = repo;
    }

    public List<Vols> searchVols(int origine_id, int destination_id, String date, String section) {
        try {
            return repo.searchAllBy(origine_id, destination_id, date, section);
        } catch (Exception e) {}
        return null;
    }
}
