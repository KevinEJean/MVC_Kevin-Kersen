package com.example.projetfinale.models.trajet;


import com.example.projetfinale.models.Aeroport;
import com.example.projetfinale.models.Operateur;

public class TrajetDTO {

    private Aeroport origineId;
    private Aeroport destinationId;
    private Operateur operateurId;
    private String date;
    private String duree;
    private String heureArriver;
    private String heureDepart;
    private TypeTrajet type;

    public Aeroport getOrigineId() {
        return origineId;
    }

    public void setOrigineId(Aeroport origineId) {
        this.origineId = origineId;
    }

    public Aeroport getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Aeroport destinationId) {
        this.destinationId = destinationId;
    }

    public Operateur getOperateurId() {
        return operateurId;
    }

    public void setOperateurId(Operateur operateurId) {
        this.operateurId = operateurId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getHeureArriver() {
        return heureArriver;
    }

    public void setHeureArriver(String heureArriver) {
        this.heureArriver = heureArriver;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public TypeTrajet getType() {
        return type;
    }

    public void setType(TypeTrajet type) {
        this.type = type;
    }
}
