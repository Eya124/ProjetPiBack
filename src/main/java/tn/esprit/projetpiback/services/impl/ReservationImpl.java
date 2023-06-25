package tn.esprit.projetpiback.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projetpiback.entites.Evenement;
import tn.esprit.projetpiback.entites.Reservation;
import tn.esprit.projetpiback.repository.EvenementRepository;
import tn.esprit.projetpiback.repository.ReservationRepository;
import tn.esprit.projetpiback.services.ReservationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final EvenementRepository evenementRepository;
    @Override
    public List<Evenement> getALlbyUserAndDate(Integer idUser) {
        List<Evenement>    evenements = reservationRepository.findDatesEvenementsByUserId(idUser);
        // Filtre les réservations inactives pour chaque événement
        List<Evenement> evenementsFiltres = evenements.stream()
                .peek(evenement -> {
                    List<Reservation> reservationsInactives = evenement.getReservations().stream()
                            .filter(reservation -> !reservation.isActif()&& reservation.getUser().getIdUser().equals(idUser))
                            .collect(Collectors.toList());
                    evenement.setReservations(reservationsInactives);
                })
                .filter(evenement -> !evenement.getReservations().isEmpty())
                .collect(Collectors.toList());

        return evenementsFiltres;
    }


  @Override
  public void insertEvenementWithNbrParticipants(Integer reservationId) {
      Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(() -> new IllegalArgumentException("Reservation not found"));
      List<Evenement> evenements =  reservation.getEvenements();
      for (Evenement evenement : evenements) {
          Long evenementId  =evenement.getIdEvenement();
          int nbr = reservationRepository.countReservationsByEvenements_IdEvenementAndActif(evenementId , false);
          evenement.setNbrParticipants(nbr);
          evenementRepository.save(evenement);

      }
  }
    @Override
    public int getNbrReservationActifEvenement(Long idEvenement, boolean actif) {
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
