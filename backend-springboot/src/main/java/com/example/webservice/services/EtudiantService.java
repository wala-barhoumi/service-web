package com.example.webservice.services;

import com.example.webservice.entities.Etudiant;
import com.example.webservice.entities.Reservation;
import com.example.webservice.repository.EtudiantRepository;
import com.example.webservice.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService{
    EtudiantRepository etudiantRepository;
   ReservationRepository reservationRepository;
   ReservationService reservationService;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {

        return etudiantRepository.save(e) ;
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {

        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {

        return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, Long idReservation) {
        Etudiant etudiant = etudiantRepository.findEtudiantByNomEtAndPrenomEt(nomEt, prenomEt);
        Reservation reservation = reservationService.retrieveReservation(idReservation);
        List<Reservation> reservations = new ArrayList<>();
        if (etudiant.getReservations() != null){
            reservations = etudiant.getReservations();
        }
        reservations.add(reservation);
        etudiant.setReservations(reservations);
        etudiantRepository.save(etudiant);
        return etudiant;
    }
       /** if (etudiant != null && reservation != null){
            // Mettre à jour la liste d'étudiants de la réservation
            reservation.getEtudiants().add(etudiant);

            // Mettre à jour la liste de réservations de l'étudiant
            etudiant.getReservations().add(reservation);
            etudiantRepository.save(etudiant);
            reservationRepository.save(reservation);
            return etudiant;
        }
        else
            return null;
    }**/
}
