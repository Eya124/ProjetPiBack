package tn.esprit.projetpiback.services;

import tn.esprit.projetpiback.entites.Reservation;

public interface EvenementService {
    void insertEvenementWithNbrParticipants(Integer idEvenement);

    Reservation addReservationAndAssignToEvenement(Integer idUser, Integer idEvenement);
}
