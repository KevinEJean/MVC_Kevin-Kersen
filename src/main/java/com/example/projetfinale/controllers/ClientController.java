package com.example.projetfinale.controllers;

import com.example.projetfinale.models.Offres;
import com.example.projetfinale.models.SearchCriteriaDTO;
import com.example.projetfinale.services.ServiceClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/client")
@CrossOrigin
public class ClientController {

    private final ServiceClient serviceClient;
    public ClientController(ServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    @GetMapping("/searchOffers")
    public List<Offres> searchOffers(@RequestBody SearchCriteriaDTO criteria) {
        return serviceClient.executeSearch(criteria);
    }

    @PutMapping("reserveOffer/{id}")
    public boolean reserveOffer(@PathVariable int id) {        
        return serviceClient.reserve(id);
    }
}
