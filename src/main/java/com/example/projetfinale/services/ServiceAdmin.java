package com.example.projetfinale.services;

import com.example.projetfinale.models.Aeroport;
import com.example.projetfinale.models.Offres;
import com.example.projetfinale.models.trajet.*;
import com.example.projetfinale.repositories.AeroportRepository;
import com.example.projetfinale.repositories.FrabriquerTrajet;
import com.example.projetfinale.repositories.OffreRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAdmin {

    private final FrabriquerTrajet trajetRepository;
    private final AeroportRepository aeroportRepository;
    private final OffreRepository offreRepository;

    public ServiceAdmin(FrabriquerTrajet trajetRepository, AeroportRepository aeroportRepository, OffreRepository offreRepository) {
        this.trajetRepository = trajetRepository;
        this.aeroportRepository = aeroportRepository;
        this.offreRepository = offreRepository;
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

    public Trajet modifierTrajetVol(int id, String numero) {
        try {
            Trajet trajetChoisi = null;

            List<Trajet> listTrajet = trajetRepository.findAll();
            for (Trajet trajet : listTrajet) {
                if (trajet.getId() == id) {
                    trajetChoisi = trajet;
                }
            }

            if (trajetChoisi == null) {
                System.out.println("Le trajet n'existe pas");
                return null;
            }

            trajetChoisi.setNumero(numero);

            trajetRepository.save(trajetChoisi);

            return trajetChoisi;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Trajet getTrajet(int id) {
        try {
            Trajet trajetChoisi = null;

            List<Trajet> listTrajet = trajetRepository.findAll();
            for (Trajet trajet : listTrajet) {
                if (trajet.getId() == id) {
                    trajetChoisi = trajet;
                }
            }

            return trajetChoisi;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public void supprimerTrajet(int id) {
        try {
            Trajet trajetChoisi = null;
            Offres offreAssocie = null;

            List<Trajet> listTrajet = trajetRepository.findAll();
            for (Trajet trajet : listTrajet) {
                if (trajet.getId() == id) {
                    trajetChoisi = trajet;
                    break;
                }
            }

            List<Offres> listOffres = offreRepository.findAll();
            for (Offres offre : listOffres) {
                if (offre.getTrajet().getId() == id) {
                    offreAssocie = offre;
                    offreRepository.delete(offreAssocie);
                    break;
                }
            }

            if (trajetChoisi == null) {
                System.out.println("Le trajet n'existe pas.");
                return;
            }

            if (offreAssocie == null) {
                System.out.println("Il n'y a pas d'offre associer au trajet.");
                return;
            }

            trajetRepository.delete(trajetChoisi);

        } catch (Exception e) {
            System.out.println("Erreur lors de la supression du trajet");
            e.printStackTrace();
        }
    }

}