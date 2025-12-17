package com.example.projetfinale.services;

import com.example.projetfinale.models.Offres;
import com.example.projetfinale.repositories.OffreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceSearchTest {

    @Mock
    private OffreRepository offreRepository;

    @InjectMocks
    private ServiceSearch serviceSearch;

    private List<Offres> offresDeTest;

    @BeforeEach
    void setUp() {
        Offres offreA = new Offres();
        offreA.setId(1);
        offreA.setPrixBase(700.00);

        Offres offreB = new Offres();
        offreB.setId(2);
        offreB.setPrixBase(400.00);

        Offres offreC = new Offres();
        offreC.setId(3);
        offreC.setPrixBase(900.00);

        Offres offreD = new Offres();
        offreD.setId(4);
        offreD.setPrixBase(550.00);

        offresDeTest = Arrays.asList(offreA, offreB, offreC, offreD);
    }

    @Test
    void testGetTopNOffresMoinsCheres_AvecNInferieurAuTotal() {
        int n = 3;

        when(offreRepository.findAll()).thenReturn(offresDeTest);

        List<Offres> topOffres = serviceSearch.getTopNOffresMoinsCheres(n);

        assertEquals(n, topOffres.size(), "La liste doit contenir"+ n + "éléments.");

        assertEquals(400.00, topOffres.get(0).getPrixBase(), "La première offre doit être la moins chère.");
        assertEquals(550.00, topOffres.get(1).getPrixBase(), "La deuxième offre doit être 550.00.");
        assertEquals(700.00, topOffres.get(2).getPrixBase(), "La troisième offre doit être 700.00.");
    }

    @Test
    void testGetTopNOffresMoinsCheres_AvecNSuperieurAuTotal() {
        int n = 10;

        when(offreRepository.findAll()).thenReturn(offresDeTest);

        List<Offres> topOffres = serviceSearch.getTopNOffresMoinsCheres(n);

        assertEquals(4, topOffres.size(), "La liste doit contenir toutes les offres disponibles donc 4.");

        assertEquals(400.00, topOffres.get(0).getPrixBase());
        assertEquals(900.00, topOffres.get(3).getPrixBase());
    }

    @Test
    void testGetTopNOffresMoinsCheres_ListeVide() {
        int n = 2;

        when(offreRepository.findAll()).thenReturn(Collections.emptyList());

        List<Offres> topOffres = serviceSearch.getTopNOffresMoinsCheres(n);

        assertTrue(topOffres.isEmpty(), "La liste retournée doit être vide.");
    }
}