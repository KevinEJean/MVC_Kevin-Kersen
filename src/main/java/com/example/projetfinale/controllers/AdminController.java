package com.example.projetfinale.controllers;

import com.example.projetfinale.models.Aeroport;
import com.example.projetfinale.models.trajet.TrajetVol;
import com.example.projetfinale.services.ServiceAdmin;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/creerAeroport")
    public ResponseEntity<Aeroport> creerAeroport(
            @RequestParam int id,
            @RequestParam String code,
            @RequestParam String ville) {

        Aeroport aeroport = serviceAdmin.creerAeroport(id, code, ville);

        if (aeroport == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(aeroport, HttpStatus.OK);
    }
}
