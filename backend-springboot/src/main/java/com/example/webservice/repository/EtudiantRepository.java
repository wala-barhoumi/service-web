package com.example.webservice.repository;

import com.example.webservice.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
   public Etudiant findEtudiantByNomEtAndPrenomEt(String nomEt, String prenomEt);
}
