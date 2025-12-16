package com.example.projetfinale.services;

import com.example.projetfinale.models.Offres;
import com.example.projetfinale.models.Siege;
import com.example.projetfinale.models.Siege.StatutSiege;
import com.example.projetfinale.repositories.OffreRepository;
import com.example.projetfinale.repositories.SiegeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceClient {

    private final OffreRepository offresRepository;
    private final SiegeRepository siegeRepository;

    public ServiceClient(OffreRepository offresRepository, SiegeRepository siegeRepository) {
        this.offresRepository = offresRepository;
        this.siegeRepository = siegeRepository;
    }

    @Transactional
    public Siege reserverOffreVol(int trajetId, String siege_numero) {
        try {
            Offres offreChoisie = offresRepository.findByTrajetId(trajetId).stream().findFirst().orElse(null);

            if (offreChoisie == null) {
                System.out.println("L'offre n'existe pas !");
                return null;
            }

            Siege siegeChoisi = offreChoisie.getSieges().stream()
                    .filter(siege -> siege.getNumeroSiege().equals(siege_numero))
                    .findFirst()
                    .orElse(null);

            if (siegeChoisi == null) {
                System.out.println("Le siège n'existe pas !");
                return null;
            }

            if (siegeChoisi.getStatut() != StatutSiege.DISPONIBLE) {
                System.out.println("Le siège n'est pas disponible ! Statut actuel : " + siegeChoisi.getStatut());
                return null;
            }

            siegeChoisi.setStatut(StatutSiege.RESERVE);

            return siegeRepository.save(siegeChoisi);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Transactional
    public Siege payerOffreVol(int trajetId, String siege_numero, String numeroCarte, String cvv, String nom) {
        try {
            Offres offreChoisie = offresRepository.findByTrajetId(trajetId).stream().findFirst().orElse(null);

            if (offreChoisie == null) {
                System.out.println("L'offre n'existe pas !");
                return null;
            }

            Siege siegeChoisi = offreChoisie.getSieges().stream()
                    .filter(siege -> siege.getNumeroSiege().equals(siege_numero))
                    .findFirst()
                    .orElse(null);


            if (siegeChoisi == null) {
                System.out.println("Le siège n'existe pas !");
                return null;
            }

            if (siegeChoisi.getStatut() != StatutSiege.RESERVE) {
                System.out.println("Réservez le siège avant de payer, SVP! Statut actuel : " + siegeChoisi.getStatut());
                return null;
            }

            boolean paymentSuccessful = processPayment(numeroCarte, cvv, nom);

            if (!paymentSuccessful) {
                System.out.println("Le paiement a échoué. Vérifiez les informations de votre carte.");
                return null;
            }

            siegeChoisi.setStatut(StatutSiege.VENDU);

            System.out.println("Le paiement a été effectué avec succès pour le siège " + siege_numero + ".");
            return siegeRepository.save(siegeChoisi);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean processPayment(String numeroCarte, String cvv, String nom) {
        final String validCardNumber = "123456789";
        final String validCvv = "123";
        final String validCardholderName = "John Doe";

        return numeroCarte.equals(validCardNumber) && cvv.equals(validCvv) && nom.equals(validCardholderName);
    }

    public ArrayList<Offres> rechercherOffreVol(
            int trajetId,
            String date,
            String section
    ) {
        try {
            List<Offres> offresPourTrajet = offresRepository.findByTrajetId(trajetId);
            ArrayList<Offres> listeResultat = new ArrayList<>();

            for (Offres offre : offresPourTrajet) {

                if (offre.getTrajet().getDate().equals(date)) {

                    boolean siegeDisponible = false;
                    for (Siege siege : offre.getSieges()) {
                        if (siege.getSection().equalsIgnoreCase(section) &&
                                siege.getStatut() == StatutSiege.DISPONIBLE) {
                            siegeDisponible = true;
                            break;
                        }
                    }

                    if (siegeDisponible) {
                        listeResultat.add(offre);
                    }
                }
            }

            return listeResultat;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}