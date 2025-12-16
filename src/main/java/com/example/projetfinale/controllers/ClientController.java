package com.example.projetfinale.controllers;

<<<<<<< HEAD
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetfinale.models.Offres;
import com.example.projetfinale.models.Sieges;
import com.example.projetfinale.services.ServiceClient;
=======
import com.example.projetfinale.models.Offres;
import com.example.projetfinale.models.Sieges;
import com.example.projetfinale.services.ServiceClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
>>>>>>> 6c8ff2a5431d9b4d8659576e5b1844b35fa5c6ca


@RestController
@RequestMapping("/client")
@CrossOrigin
public class ClientController {

    private final ServiceClient serviceClient;
    public ClientController(ServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    @PutMapping("/getOffre")
    public ResponseEntity<ArrayList<Offres>> getOffre(
            @RequestParam int trajet,
            @RequestParam String date,
            @RequestParam String section
    ) {
        return ResponseEntity.ok(
                serviceClient.rechercherOffreVol(trajet, date, section)
        );
    }

    @PutMapping("/payerOffre")
    public ResponseEntity<Sieges> payerOffre(
<<<<<<< HEAD
            @RequestParam int trajet_id,
            @RequestParam String siege_numero,
            @RequestParam String numero_carte,
=======
            @RequestParam int id,
            @RequestParam String siege_numero,
            @RequestParam String numeroCarte,
>>>>>>> 6c8ff2a5431d9b4d8659576e5b1844b35fa5c6ca
            @RequestParam String cvv,
            @RequestParam String nom
    ) {
        return ResponseEntity.ok(
<<<<<<< HEAD
               serviceClient.payerOffreVol(trajet_id, siege_numero, numero_carte, cvv, nom)
=======
               serviceClient.payerOffreVol(id, siege_numero, numeroCarte, cvv, nom)
>>>>>>> 6c8ff2a5431d9b4d8659576e5b1844b35fa5c6ca
        );
    }

    @PutMapping("/reserverOffre")
    public ResponseEntity<Sieges> reserverOffre(
<<<<<<< HEAD
            @RequestParam int trajet_id,
            @RequestParam String siege_numero
    ) {
        return ResponseEntity.ok(
                serviceClient.reserverOffreVol(trajet_id, siege_numero)
=======
            @RequestParam int id,
            @RequestParam String siege_numero
    ) {
        return ResponseEntity.ok(
                serviceClient.reserverOffreVol(id, siege_numero)
>>>>>>> 6c8ff2a5431d9b4d8659576e5b1844b35fa5c6ca
        );
    }
}
