package com.example.projetfinale.controllers;

import com.example.projetfinale.models.Offre;
import com.example.projetfinale.services.OffreService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/offre")
@CrossOrigin
public class OffreController {

    private final OffreService service;

    OffreController(OffreService service, OffreService offreService) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<Offre> getAllOffre() {
        return service.getAll();
    }
}
