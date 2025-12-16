package com.example.projetfinale.services;

import com.example.projetfinale.models.Offres;
import com.example.projetfinale.models.Sieges;
import com.example.projetfinale.repositories.OffreRepository;
import com.example.projetfinale.repositories.SiegeRepository;
import org.springframework.stereotype.Service;

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

    public Sieges reserverOffreVol(int id, String siege_numero) {
        try {
            Offres offreChoisi = null;
            for (Offres offres : offresRepository.findAll()) {
                if (offres.getTrajet().getId() == id) {
                    offreChoisi = offres;
                }
            }

            if (offreChoisi == null) {
                System.out.println("L'offre n'existe pas'!");
                return null;
            }

            Sieges siegeChoisi = null;
            for (Sieges siege : offreChoisi.getSieges()) {
                if (siege.getNumeroSiege().equals(siege_numero)) {
                    siegeChoisi = siege;
                    break;
                }
            }

            if (siegeChoisi == null) {
                System.out.println("Le siege n'existe pas !");
                return null;
            }

            if (siegeChoisi.getStatut() == "RESERVER") {
                System.out.println("Le siege n'est pas dsiponible !");
                return null;
            }

            siegeChoisi.setStatut("RESERVER");

            offresRepository.save(offreChoisi);

            return siegeChoisi;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public Sieges payerOffreVol(int id, String siege_numero, String numeroCarte, String cvv, String nom) {
        try {
            Offres offreChoisi = null;
            for (Offres offres : offresRepository.findAll()) {
                if (offres.getTrajet().getId() == id) {
                    offreChoisi = offres;
                }
            }

            if (offreChoisi == null) {
                System.out.println("L'offre n'existe pas !");
                return null;
            }

            Sieges siegeChoisi = null;
            for (Sieges siege : offreChoisi.getSieges()) {
                if (siege.getNumeroSiege().equals(siege_numero)) {
                    siegeChoisi = siege;
                    break;
                }
            }

            if (siegeChoisi == null) {
                System.out.println("Le siège n'existe pas !");
                return null;
            }

            if (!"RESERVER".equals(siegeChoisi.getStatut())) {
                System.out.println("Réservez le siège avant de payer, SVP!");
                return null;
            }

            boolean paymentSuccessful = processPayment(numeroCarte, cvv, nom);

            if (!paymentSuccessful) {
                System.out.println("Le paiement a échoué. Vérifiez les informations de votre carte.");
                return null;
            }

            siegeChoisi.setStatut("PAYER");

            offresRepository.save(offreChoisi);

            System.out.println("Le paiement a été effectué avec succès pour le siège " + siege_numero + ".");
            return siegeChoisi;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Simulation d'un paiement
    private boolean processPayment(String numeroCarte, String cvv, String nom) {

        String validCardNumber = "123456789";
        String validCvv = "123";
        String validCardholderName = "John Doe";

        if (numeroCarte.equals(validCardNumber) && cvv.equals(validCvv) && nom.equals(validCardholderName)) {
            return true;
        } else {
            return false;
        }
    }



    public ArrayList<Offres> rechercherOffreVol(
            int trajet_id,
            String date,
            String section
    ) {
        try {
            List<Offres> listeOffres = offresRepository.findAll();
            ArrayList<Offres> listeResultat = new ArrayList<>();

            // comparé donnée en paramètre avec données de la BD et retourner liste d'offre disponible
            return listeResultat;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
