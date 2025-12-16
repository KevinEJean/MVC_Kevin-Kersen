package com.example.projetfinale.controllers;

import com.example.projetfinale.models.Offres;
import com.example.projetfinale.services.ServiceSearch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@CrossOrigin
public class SearchController {

    private final ServiceSearch serviceSearch;

    public SearchController(ServiceSearch serviceSearch) {
        this.serviceSearch = serviceSearch;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Offres>> afficherToutesLesOffres() {
        return ResponseEntity.ok(
                serviceSearch.afficherToutesLesOffres()
        );
    }

    @GetMapping("/sortByPrice")
    public ResponseEntity<List<Offres>> trierParPrix(
            @RequestParam String ordre
    ) {
        String ordreValide = ordre.toUpperCase().equals("DESC") ? "DESC" : "ASC";

        return ResponseEntity.ok(
                serviceSearch.trierOffresParPrix(ordreValide)
        );
    }

    @GetMapping("/topCheap")
    public ResponseEntity<List<Offres>> getTopCheapest(
            @RequestParam int n
    ) {
        if (n <= 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(
                serviceSearch.getTopNOffresMoinsCheres(n)
        );
    }
}