package com.example.webservice.repository;

import com.example.webservice.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    Chambre findChambreByNumeroChambre(Long numChambre);
}
