package com.example.projetfinale.models;

import com.example.projetfinale.models.trajet.TypeTrajet;

public class SearchCriteriaDTO {
    private Integer origineId;

    private Integer destinationId;

    private String date;

    private TypeTrajet type;

    private Boolean estReserver;


    public Integer getOrigineId() {
        return origineId;
    }

    public void setOrigineId(Integer origineId) {
        this.origineId = origineId;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public TypeTrajet getType() {
        return type;
    }

    public void setType(TypeTrajet type) {
        this.type = type;
    }

    public Boolean getEstReserver() {
        return estReserver;
    }

    public void setEstReserver(Boolean estReserver) {
        this.estReserver = estReserver;
    }

    @Override
    public String toString() {
        return "SearchCriteriaDTO{" +
                "origineId=" + origineId +
                ", destinationId=" + destinationId +
                ", date=" + date +
                ", type=" + type +
                ", estReserver=" + estReserver +
                '}';
    }
}
