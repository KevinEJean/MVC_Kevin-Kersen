package com.example.projetfinale.controllers;

import com.example.projetfinale.models.trajet.Trajet;
import com.example.projetfinale.models.trajet.TrajetDTO;
import com.example.projetfinale.services.ServiceAdmin;
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
    public Trajet creerTrajetVol(@RequestBody TrajetDTO trajetDTO) {
        // Convert DTO to Trajet (or call a service method that does this)
        return serviceAdmin.creerTrajetVol(trajetDTO);
    }

    @PostMapping("/creerTrajetTrain")
    public Trajet creerTrajetTrain(@RequestBody TrajetDTO trajetDTO) {
        // Convert DTO to Trajet (or call a service method that does this)
        return serviceAdmin.creerTrajetTrain(trajetDTO);
    }
}
