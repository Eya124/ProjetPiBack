package tn.esprit.projetpiback.services;

import tn.esprit.projetpiback.entites.Reservation;

public interface EvenementService {
    Reservation addReservationAndAssignToEvenement(Reservation reservation, Long idEvenement);
}
