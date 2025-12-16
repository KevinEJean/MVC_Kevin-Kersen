package com.example.projetfinale;

import com.example.projetfinale.models.Aeroport;
import com.example.projetfinale.models.Offres;
import com.example.projetfinale.models.trajet.TrajetVol;
import com.example.projetfinale.repositories.AeroportRepository;
import com.example.projetfinale.repositories.FrabriquerTrajet;
import com.example.projetfinale.repositories.OffreRepository;
import com.example.projetfinale.services.ServiceAdmin;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServiceAdminTest {

    private ServiceAdmin serviceAdmin;
    private FrabriquerTrajet trajetRepository;
    private AeroportRepository aeroportRepository;
    private OffreRepository offreRepository;

    @Test
    void testCreerTrajetVol() {
        Aeroport origine = new Aeroport();
        origine.setId(1);
        Aeroport destination = new Aeroport();
        destination.setId(2);

        when(aeroportRepository.getById(1)).thenReturn(origine);
        when(aeroportRepository.getById(2)).thenReturn(destination);

        TrajetVol resultat = serviceAdmin.creerTrajetVol("NV123", 1, 2, "2h30", 10);

        assertNotNull(resultat);
        assertEquals("NV123", resultat.getNumero());
        assertEquals(origine, resultat.getOrigine());
        assertEquals(destination, resultat.getDestination());
        assertEquals(10, resultat.getId());

        verify(trajetRepository, times(1)).save(resultat);
    }

    @Test
    void testSupprimerTrajet() {
        TrajetVol trajet = new TrajetVol();
        trajet.setId(1);

        Offres offre = new Offres();
        offre.setId(100);
        offre.setTrajet(trajet);

        List<TrajetVol> trajets = new ArrayList<>();
        trajets.add(trajet);

        List<Offres> offres = new ArrayList<>();
        offres.add(offre);

        when(trajetRepository.findAll()).thenReturn(new ArrayList<>(trajets));
        when(offreRepository.findAll()).thenReturn(new ArrayList<>(offres));

        serviceAdmin.supprimerTrajet(1);

        verify(offreRepository, times(1)).delete(offre);
        verify(trajetRepository, times(1)).delete(trajet);
    }
}