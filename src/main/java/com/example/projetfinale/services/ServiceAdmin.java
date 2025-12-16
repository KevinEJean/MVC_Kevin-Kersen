package com.example.projetfinale.services;

import com.example.projetfinale.models.Aeroport;
import com.example.projetfinale.models.Offres;
import com.example.projetfinale.models.Operateur;
import com.example.projetfinale.models.Siege;
import com.example.projetfinale.models.Siege.StatutSiege;
import com.example.projetfinale.models.trajet.Trajet;
import com.example.projetfinale.models.trajet.TrajetFactory;
import com.example.projetfinale.models.trajet.TrajetVol;

import com.example.projetfinale.repositories.AeroportRepository;
import com.example.projetfinale.repositories.OffreRepository;
import com.example.projetfinale.repositories.OperateurRepository;
import com.example.projetfinale.repositories.TrajetVolRepository;
import com.example.projetfinale.repositories.SiegeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

@Service
public class ServiceAdmin {

    private final OffreRepository offreRepository;
    private final TrajetVolRepository trajetRepository;
    private final AeroportRepository aeroportRepository;
    private final OperateurRepository operateurRepository;
    private final SiegeRepository siegeRepository;
    private final TrajetFactory trajetFactory;

    public ServiceAdmin(
            OffreRepository offreRepository,
            TrajetVolRepository trajetRepository,
            AeroportRepository aeroportRepository,
            OperateurRepository operateurRepository,
            SiegeRepository siegeRepository,
            TrajetFactory trajetFactory) {

        this.offreRepository = offreRepository;
        this.trajetRepository = trajetRepository;
        this.aeroportRepository = aeroportRepository;
        this.operateurRepository = operateurRepository;
        this.siegeRepository = siegeRepository;
        this.trajetFactory = trajetFactory;
    }

    @Transactional
    public TrajetVol creerTrajetVol(
            String numero,
            int origineId,
            int destinationId,
            String duree,
            int trajetVolId
    ) {
        final int operateurId = 1;
        final String dateVol = "2025-12-25";
        final double prixDeBase = 500.00;

        try {
            Aeroport aeroportOrigine = aeroportRepository.findById(origineId).orElseThrow(
                    () -> new IllegalArgumentException("Aéroport d'origine non trouvé: " + origineId)
            );
            Aeroport aeroportDst = aeroportRepository.findById(destinationId).orElseThrow(
                    () -> new IllegalArgumentException("Aéroport de destination non trouvé: " + destinationId)
            );
            Operateur operateur = operateurRepository.findById(operateurId).orElseThrow(
                    () -> new IllegalArgumentException("Opérateur non trouvé (ID 1 requis):")
            );

            Trajet trajet = trajetFactory.createTrajet("VOL");

            if (!(trajet instanceof TrajetVol)) {
                throw new IllegalStateException("La Factory n'a pas retourné un TrajetVol.");
            }
            TrajetVol newTrajet = (TrajetVol) trajet;

            newTrajet.setId(trajetVolId);
            newTrajet.setNumero(numero);
            newTrajet.setOrigine(aeroportOrigine);
            newTrajet.setDestination(aeroportDst);
            newTrajet.setDuree(duree);
            newTrajet.setDate(dateVol);
            newTrajet.setHeureDepart("14:00");
            newTrajet.setHeureArriver("22:30");
            newTrajet.setOperateur(operateur);

            Offres offre = new Offres();
            offre.setTrajet(newTrajet);
            offre.setOperateur(operateur);
            offre.setDepart(dateVol);
            offre.setPrixBase(prixDeBase);

            List<Siege> sieges = new ArrayList<>();
            for (String section : new String[]{"Economie", "Affaires"}) {
                int count = section.equals("Economie") ? 3 : 1;
                String suffixe = section.equals("Economie") ? "A" : "D";

                for (int i = 1; i <= count; i++) {
                    Siege siege = new Siege();
                    siege.setNumeroSiege(i + suffixe);
                    siege.setSection(section);
                    siege.setStatut(StatutSiege.DISPONIBLE);
                    siege.setOffre(offre);
                    sieges.add(siege);
                }
            }
            offre.setSieges(sieges);

            trajetRepository.save(newTrajet);
            offreRepository.save(offre);
            siegeRepository.saveAll(sieges);

            return newTrajet;

        } catch (IllegalArgumentException e) {
            System.err.println("Erreur de donnée (ID non trouvé): " + e.getMessage());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Aeroport creerAeroport(int id, String code, String ville) {
        Aeroport existingAeroport = aeroportRepository.findById(id).orElse(null);

        if (existingAeroport != null) {
            System.out.println("L'aéroport avec l'ID " + id + " existe déjà.");

            existingAeroport.setCode(code);
            existingAeroport.setVille(ville);
            return aeroportRepository.save(existingAeroport);

        } else {
            Aeroport newAeroport = new Aeroport();
            newAeroport.setId(id);
            newAeroport.setCode(code);
            newAeroport.setVille(ville);

            return aeroportRepository.save(newAeroport);
        }
    }

    public Trajet modifierTrajetVol(int id, String numero) {
        try {
            Trajet trajetChoisi = null;

            List<TrajetVol> listTrajet = trajetRepository.findAll();
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

            trajetRepository.save((TrajetVol) trajetChoisi);

            return trajetChoisi;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Trajet getTrajet(int id) {
        try {
            Trajet trajetChoisi = null;

            List<TrajetVol> listTrajet = trajetRepository.findAll();
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

    @jakarta.transaction.Transactional
    public void supprimerTrajet(int id) {
        try {
            Trajet trajetChoisi = null;
            Offres offreAssocie = null;

            List<TrajetVol> listTrajet = trajetRepository.findAll();
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

            trajetRepository.delete((TrajetVol) trajetChoisi);

        } catch (Exception e) {
            System.out.println("Erreur lors de la supression du trajet");
            e.printStackTrace();
        }
    }

    public Operateur creerOperateur(int id, String nom) {
        Operateur existingOperateur = operateurRepository.findById(id).orElse(null);

        if (existingOperateur != null) {
            System.out.println("L'Opérateur avec l'ID " + id + " existe déjà.");
            return existingOperateur;
        } else {
            Operateur newOperateur = new Operateur();
            newOperateur.setId(id);
            newOperateur.setNom(nom);

            return operateurRepository.save(newOperateur);
        }
    }
}