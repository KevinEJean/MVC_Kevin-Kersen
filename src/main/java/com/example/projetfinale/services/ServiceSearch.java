package com.example.projetfinale.services;

import com.example.projetfinale.models.Offres;
import com.example.projetfinale.repositories.OffreRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceSearch {

    private final OffreRepository offreRepository;

    public ServiceSearch(OffreRepository offreRepository) {
        this.offreRepository = offreRepository;
    }

    public List<Offres> afficherToutesLesOffres() {
        return offreRepository.findAll();
    }

    public List<Offres> getTopNOffresMoinsCheres(int n) {
        List<Offres> toutesLesOffres = offreRepository.findAll();

        toutesLesOffres.sort(Comparator.comparing(Offres::getPrixBase));

        return toutesLesOffres.stream()
                .limit(n)
                .collect(Collectors.toList());
    }

    public List<Offres> trierOffresParPrix(String ordre) {
        List<Offres> toutesLesOffres = offreRepository.findAll();

        Comparator<Offres> comparator = Comparator.comparing(Offres::getPrixBase);

        if (ordre != null && ordre.equalsIgnoreCase("DESC")) {
            toutesLesOffres.sort(comparator.reversed());
        } else {
            toutesLesOffres.sort(comparator);
        }

        return toutesLesOffres;
    }
}