package tn.esprit.projetpiback.repository;

import tn.esprit.projetpiback.entites.Evenement;
import tn.esprit.projetpiback.entites.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    int countReservationsByUser_IdUser (Integer idUser);

    List<Reservation> findAllByUserIdUserAndEvenementDateDebutBefore(int iduserrec,Date date);
}
