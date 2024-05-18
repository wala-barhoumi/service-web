package com.example.webservice.services;

import com.example.webservice.entities.Reservation;

public interface IReservationService {
    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (long idReservation);
}
