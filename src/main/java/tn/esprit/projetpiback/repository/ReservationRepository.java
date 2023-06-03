package tn.esprit.projetpiback.repository;

import tn.esprit.projetpiback.entites.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    int countReservationsByUser_IdUser (Integer idUser);
    
}
