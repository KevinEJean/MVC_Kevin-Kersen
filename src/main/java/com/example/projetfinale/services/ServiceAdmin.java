package com.example.projetfinale.services;

import com.example.projetfinale.models.trajet.*;
import com.example.projetfinale.repositories.FabriqueTrajet;
import org.springframework.stereotype.Service;

@Service
public class ServiceAdmin {

    private final FabriqueTrajet trajetRepository;
    public ServiceAdmin(FabriqueTrajet trajetRepository) {
        this.trajetRepository = trajetRepository;
    }

    public Trajet creerTrajetVol(TrajetDTO trajetDTO) {
        Trajet trajet = new TrajetVol(trajetDTO.getOrigineId(), trajetDTO.getDestinationId(), trajetDTO.getOperateurId(), trajetDTO.getDate(), trajetDTO.getDuree(),
                trajetDTO.getHeureArriver(), trajetDTO.getHeureDepart(), trajetDTO.getType());

        return trajetRepository.save(trajet);
    }

    public Trajet creerTrajetTrain(TrajetDTO trajetDTO) {
        Trajet trajet = new TrajetTrain(trajetDTO.getOrigineId(), trajetDTO.getDestinationId(), trajetDTO.getOperateurId(), trajetDTO.getDate(), trajetDTO.getDuree(),
                trajetDTO.getHeureArriver(), trajetDTO.getHeureDepart(), trajetDTO.getType());

        return trajetRepository.save(trajet);
    }
}