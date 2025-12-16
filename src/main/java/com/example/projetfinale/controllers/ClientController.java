package com.example.projetfinale.controllers;

import com.example.projetfinale.models.Offres;
import com.example.projetfinale.models.Siege;
import com.example.projetfinale.services.ServiceClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
    public ResponseEntity<Siege> payerOffre(
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
    public ResponseEntity<Siege> reserverOffre(
            @RequestParam int trajet_id,
            @RequestParam String siege_numero
    ) {
        return ResponseEntity.ok(
                serviceClient.reserverOffreVol(trajet_id, siege_numero)
        );
    }
}