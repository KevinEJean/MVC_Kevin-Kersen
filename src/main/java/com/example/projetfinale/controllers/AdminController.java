package com.example.projetfinale.controllers;

import com.example.projetfinale.models.Aeroport;
import com.example.projetfinale.models.Offres;
import com.example.projetfinale.models.Operateur;
import com.example.projetfinale.models.Siege;
import com.example.projetfinale.models.trajet.Trajet;
import com.example.projetfinale.models.trajet.TrajetVol;
import com.example.projetfinale.models.trajet.TypeTrajet;
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
            @RequestParam int trajet_id
    ) {
        return ResponseEntity.ok(
                serviceAdmin.creerTrajetVol(numero, origine, destination, duree, trajet_id)
        );
    }

    @PutMapping("/modifierTrajetVol")
    public ResponseEntity<Trajet> modifierTrajetVol(@RequestParam int trajet_id, @RequestParam String numero) {
        return ResponseEntity.ok(
            serviceAdmin.modifierTrajetVol(trajet_id, numero)
        );
    }


    @GetMapping("/getTrajet")
    public ResponseEntity<Trajet> getTrajet(@RequestParam int trajet_id) {
        return ResponseEntity.ok(
            serviceAdmin.getTrajet(trajet_id)
        );
    }


    @DeleteMapping("/supprimerTrajet")
    public void supprimerTrajet(@RequestParam int trajet_id) {
        serviceAdmin.supprimerTrajet(trajet_id);
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

    @PostMapping("/creerOperateur")
    public ResponseEntity<Operateur> creerOperateur(
            @RequestParam int id,
            @RequestParam String nom) {

        Operateur operateur = serviceAdmin.creerOperateur(id, nom);

        if (operateur == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(operateur, HttpStatus.OK);
    }
}
