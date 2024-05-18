package com.example.webservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "Foyer")
public class Foyer implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "idFoyer")
    private long idFoyer;
    private String nomFoyer;
    private long capaciteFoyer;



    private TypeFoyer type;

    @OneToMany (mappedBy = "foyer" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Bloc> blocs;

    @OneToOne (mappedBy = "foyer")
    private Universite universite;

    public long getIdFoyer() {
        return idFoyer;
    }

    public void setIdFoyer(long idFoyer) {
        this.idFoyer = idFoyer;
    }

    public String getNomFoyer() {
        return nomFoyer;
    }

    public void setNomFoyer(String nomFoyer) {
        this.nomFoyer = nomFoyer;
    }

    public long getCapaciteFoyer() {
        return capaciteFoyer;
    }

    public void setCapaciteFoyer(long capaciteFoyer) {
        this.capaciteFoyer = capaciteFoyer;
    }

    public List<Bloc> getBlocs() {
        return blocs;
    }

    public void setBlocs(List<Bloc> blocs) {
        this.blocs = blocs;
    }

    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    public Foyer(long idFoyer, String nomFoyer, long capaciteFoyer, List<Bloc> blocs, Universite universite) {
        this.idFoyer = idFoyer;
        this.nomFoyer = nomFoyer;
        this.capaciteFoyer = capaciteFoyer;
        this.blocs = blocs;
        this.universite = universite;
    }

    public Foyer() {
    }
    public Foyer(long idFoyer, String nomFoyer, long capaciteFoyer, TypeFoyer type, List<Bloc> blocs, Universite universite) {
        this.idFoyer = idFoyer;
        this.nomFoyer = nomFoyer;
        this.capaciteFoyer = capaciteFoyer;
        this.type = type;
        this.blocs = blocs;
        this.universite = universite;
    }

    public TypeFoyer getType() {
        return type;
    }

    public void setType(TypeFoyer type) {
        this.type = type;
    }
}

