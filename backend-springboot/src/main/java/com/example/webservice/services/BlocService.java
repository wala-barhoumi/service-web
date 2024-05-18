package com.example.webservice.services;

import com.example.webservice.entities.Bloc;
import com.example.webservice.entities.Foyer;
import com.example.webservice.repository.BlocRepository;
import com.example.webservice.repository.ChambreRepository;
import com.example.webservice.repository.FoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService {
    BlocRepository blocRepository;
    ChambreRepository chambreRepository;
    FoyerRepository foyerRepository;

    @Override
    public List<Bloc> retrieveBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepository.findById(idBloc).get();
    }


    public Foyer addFoyerWithBloc(Foyer f){
        //sauvgarder l'objet child foyer
        Foyer foyer = foyerRepository.save(f);
        //parcourir la liste des blocs (parent)
        foyer.getBlocs().forEach(bloc -> {
            //affecter le child foyer au parent bloc et sauvgarder le parent
            bloc.setFoyer(foyer);
            blocRepository.save(bloc);

        });
        return foyer;
    }

}






