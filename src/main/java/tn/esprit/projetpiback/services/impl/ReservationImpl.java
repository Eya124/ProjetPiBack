package tn.esprit.projetpiback.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projetpiback.entites.Evenement;
import tn.esprit.projetpiback.entites.Reservation;
import tn.esprit.projetpiback.repository.EvenementRepository;
import tn.esprit.projetpiback.repository.ReservationRepository;
import tn.esprit.projetpiback.services.ReservationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final EvenementRepository evenementRepository;
    @Override
    public List<Reservation> getALl() {
        return reservationRepository.findAllByActif(false);
    }

  /*  @Override
    public void delete(int id) {
        reservationRepository.deleteById(id);

    }*/
  @Override
  public void insertEvenementWithNbrParticipants(Integer reservationId) {
      Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(() -> new IllegalArgumentException("Reservation not found"));
      List<Evenement> evenements =  reservation.getEvenements();
      for (Evenement evenement : evenements) {
            Integer evenementId  =evenement.getIdEvenement();
          int nbr = reservationRepository.countReservationsByEvenements_IdEvenementAndActif(evenementId , false);
          evenement.setNbrParticipants(nbr);
          evenementRepository.save(evenement);

      }
  }
    @Override
    public int getNbrReservationActifEvenement(Integer idEvenement, boolean actif) {
        return reservationRepository.countReservationsByEvenements_IdEvenementAndActif(idEvenement, actif);
    }
    @Override
    public void insertReservationWithActif(Integer reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(() -> new IllegalArgumentException("Reservation not found"));
        reservation.setActif(true);
        reservationRepository.save(reservation);
        this.insertEvenementWithNbrParticipants(reservationId);
    }

}
