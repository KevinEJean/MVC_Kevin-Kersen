package com.example.projetfinale.controllers;

import com.example.projetfinale.models.SearchCriteriaDTO;
import com.example.projetfinale.models.trajet.Trajet;
import com.example.projetfinale.services.ServiceClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin
public class ClientController {

    private final ServiceClient serviceClient;
    public ClientController(ServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    @GetMapping("/search")
    public List<Trajet> searchOffers(SearchCriteriaDTO criteria) {
        return serviceClient.executeSearch(criteria);
    }
}
