package com.example.webservice.services;

import com.example.webservice.entities.Bloc;
import com.example.webservice.entities.Chambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre c);

    Chambre updateChambre (Chambre c);

    Chambre retrieveChambre (long idChambre);


    Bloc affecterChambreABloc(List<Long> numChambre, String nomBloc);
}
