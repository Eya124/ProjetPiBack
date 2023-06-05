package tn.esprit.projetpiback.services;

import tn.esprit.projetpiback.entites.Reservation;

import java.util.List;

public interface ReservationService {
    //Reservation addResrvation (Reservation reservation);
    List<Reservation> getALl();

    /*  @Override
      public void delete(int id) {
          reservationRepository.deleteById(id);

      }*/
    void insertEvenementWithNbrParticipants(Integer reservationId);

    //void delete(int id);
    int getNbrReservationActifEvenement(Integer idEvenement, boolean actif);



    void insertReservationWithActif(Integer reservationId);
}
