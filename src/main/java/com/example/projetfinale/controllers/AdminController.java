package com.example.projetfinale.controllers;

import com.example.projetfinale.models.Aeroport;
import com.example.projetfinale.models.Offres;
import com.example.projetfinale.models.Operateur;
import com.example.projetfinale.models.Sieges;
import com.example.projetfinale.models.trajet.Trajet;
import com.example.projetfinale.models.trajet.TrajetVol;
import com.example.projetfinale.models.trajet.TypeTrajet;
import com.example.projetfinale.services.ServiceAdmin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    private final ServiceAdmin serviceAdmin;
    AdminController(ServiceAdmin serviceAdmin) {
        this.serviceAdmin = serviceAdmin;
    }

    @PostMapping("/creerTrajetVol")
    public ResponseEntity<TrajetVol> creerTrajetVol(
            @RequestParam String numero,
            @RequestParam int origine,
            @RequestParam int destination,
            @RequestParam String duree,
            @RequestParam int id
    ) {
        return ResponseEntity.ok(
                serviceAdmin.creerTrajetVol(numero, origine, destination, duree, id)
        );
    }


}
