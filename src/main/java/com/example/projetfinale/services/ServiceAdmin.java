package com.example.projetfinale.services;

import com.example.projetfinale.models.trajet.*;
import com.example.projetfinale.repositories.AeroportRepository;
import com.example.projetfinale.repositories.FrabriquerTrajet;
import com.example.projetfinale.repositories.OffreRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ServiceAdmin {

    private final OffreRepository offreRepository;
    private final FrabriquerTrajet trajetRepository;
    private final AeroportRepository aeroportRepository;

    public ServiceAdmin(OffreRepository offreRepository, FrabriquerTrajet trajetRepository, AeroportRepository aeroportRepository) {
        this.offreRepository = offreRepository;
        this.trajetRepository = trajetRepository;
        this.aeroportRepository = aeroportRepository;
    }

    public TrajetVol creerTrajetVol(
            String numero,
            int origine,
            int destination,
            String durree,
            int id
    ) {
        try {
            Aeroport aeroportOrigine = aeroportRepository.getById(origine);
            Aeroport aeroportDst = aeroportRepository.getById(destination);

            TrajetVol newTrajet = new TrajetVol();
            newTrajet.setId(id);
            newTrajet.setNumero(numero);
            newTrajet.setOrigine(aeroportOrigine);
            newTrajet.setDestination(aeroportDst);
            newTrajet.setDuree(durree);
            trajetRepository.save(newTrajet);

            return newTrajet;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}