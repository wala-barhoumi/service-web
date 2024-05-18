package com.example.webservice.services;

import com.example.webservice.entities.Universite;
import java.util.List;
public interface IUniversiteService {
    List<Universite> retrieveAllUniversities();

    List<Universite> allUniversitiesWhereFoyerIsNull();
    Universite addUniversity (Universite u);
    Universite updateUniversity (Universite u);
    Universite retrieveUniversity (long idUniversity);
    void removeUniversity  (long idUniversity );

    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);
    public Universite desaffecterFoyerAUniversite (long idFoyer, long idUniversite) ;
}
