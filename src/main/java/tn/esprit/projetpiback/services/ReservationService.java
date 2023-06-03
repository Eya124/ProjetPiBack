package tn.esprit.projetpiback.services;

import tn.esprit.projetpiback.entites.Reservation;

import java.util.List;

public interface ReservationService {
    //Reservation addResrvation (Reservation reservation);
    List<Reservation> getALl();
    void delete(int id);
    int getNbrReservationUser(Integer idUser);

}
