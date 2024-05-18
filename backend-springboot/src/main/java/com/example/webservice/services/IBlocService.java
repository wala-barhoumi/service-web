package com.example.webservice.services;

import com.example.webservice.entities.Bloc;
import com.example.webservice.entities.Foyer;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveBlocs();

    Bloc updateBloc (Bloc bloc);

    Bloc addBloc (Bloc bloc);

    Bloc retrieveBloc (long idBloc);


    Foyer addFoyerWithBloc(Foyer f);
}
