package com.example.projetfinale.controllers;

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

import com.example.projetfinale.models.Offres;
import com.example.projetfinale.models.Sieges;
import com.example.projetfinale.services.ServiceClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

            @RequestParam int trajet_id,
            @RequestParam String siege_numero,
            @RequestParam String numero_carte,
            @RequestParam String cvv,
            @RequestParam String nom
    ) {
        return ResponseEntity.ok(
               serviceClient.payerOffreVol(trajet_id, siege_numero, numero_carte, cvv, nom)
        );
    }

    @PutMapping("/reserverOffre")
    public ResponseEntity<Sieges> reserverOffre(
            @RequestParam int trajet_id,
            @RequestParam String siege_numero
    ) {
        return ResponseEntity.ok(
                serviceClient.reserverOffreVol(trajet_id, siege_numero)
        );
    }
}
