package com.example.webservice.repository;

import com.example.webservice.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {
    public Bloc findBlocByNomBloc(String nomBloc);


}
