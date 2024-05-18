package com.example.webservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table( name = "Universite")

public class Universite implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="idUniversite")
    private Long idUniversite;
    private String nomUniversite;
    private String adresse;

    private TunisianGovernorate grouvenerat;

    @JsonIgnore()
    @OneToOne (cascade = CascadeType.ALL)
    private Foyer foyer;

    public Universite(Long idUniversite, String nomUniversite, String adresse, TunisianGovernorate grouvenerat, Foyer foyer) {
        this.idUniversite = idUniversite;
        this.nomUniversite = nomUniversite;
        this.adresse = adresse;
        this.grouvenerat = grouvenerat;
        this.foyer = foyer;
    }

    public Universite(Long idUniversite, String nomUniversite, String adresse, Foyer foyer) {
        this.idUniversite = idUniversite;
        this.nomUniversite = nomUniversite;
        this.adresse = adresse;
        this.foyer = foyer;
    }

    public Universite() {
    }

    public Long getIdUniversite() {
        return idUniversite;
    }

    public void setIdUniversite(Long idUniversite) {
        this.idUniversite = idUniversite;
    }

    public String getNomUniversite() {
        return nomUniversite;
    }

    public void setNomUniversite(String nomUniversite) {
        this.nomUniversite = nomUniversite;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Foyer getFoyer() {
        return foyer;
    }

    public void setFoyer(Foyer foyer) {
        this.foyer = foyer;
    }

    public TunisianGovernorate getGrouvenerat() {
        return grouvenerat;
    }

    public void setGrouvenerat(TunisianGovernorate grouvenerat) {
        this.grouvenerat = grouvenerat;
    }
}
