package tn.esprit.projetpiback.services;

import tn.esprit.projetpiback.entites.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> getALl();

    void insertEvenementWithNbrParticipants(Integer reservationId);

    int getNbrReservationActifEvenement(Long idEvenement, boolean actif);

    void insertReservationWithActif(Integer reservationId);


}
