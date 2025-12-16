package com.example.projetfinale.controllers;

<<<<<<< HEAD
=======
import com.example.projetfinale.models.Aeroport;
import com.example.projetfinale.models.Offres;
import com.example.projetfinale.models.Operateur;
import com.example.projetfinale.models.Sieges;
import com.example.projetfinale.models.trajet.Trajet;
import com.example.projetfinale.models.trajet.TrajetVol;
import com.example.projetfinale.models.trajet.TypeTrajet;
import com.example.projetfinale.services.ServiceAdmin;
>>>>>>> 6c8ff2a5431d9b4d8659576e5b1844b35fa5c6ca
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.projetfinale.models.trajet.Trajet;
import com.example.projetfinale.models.trajet.TrajetVol;
import com.example.projetfinale.services.ServiceAdmin;

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
<<<<<<< HEAD
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
=======
            @RequestParam int id
    ) {
        return ResponseEntity.ok(
                serviceAdmin.creerTrajetVol(numero, origine, destination, duree, id)
        );
    }


>>>>>>> 6c8ff2a5431d9b4d8659576e5b1844b35fa5c6ca
}
