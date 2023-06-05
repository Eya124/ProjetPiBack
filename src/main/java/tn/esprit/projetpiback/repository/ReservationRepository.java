package tn.esprit.projetpiback.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.projetpiback.entites.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findAllByActif(boolean actif);
    int countReservationsByEvenements_IdEvenementAndActif (Integer idEvenement, boolean actif);
    List<Reservation> findReservationsByUserIdUserAndEvenementsDateDebutBetween (Integer idUser, Date dateDebut, Date dateFin);

}
