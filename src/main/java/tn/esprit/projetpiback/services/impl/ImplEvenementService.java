package tn.esprit.projetpiback.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.projetpiback.entites.Evenement;
import tn.esprit.projetpiback.entites.Reservation;
import tn.esprit.projetpiback.repository.EvenementRepository;
import tn.esprit.projetpiback.repository.ReservationRepository;
import tn.esprit.projetpiback.services.EvenementService;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ImplEvenementService implements EvenementService {
    private final EvenementRepository EvenementRepository;
    private final ReservationRepository ReservationRepository;
    @Override
    @Transactional
    public Reservation addReservationAndAssignToEvenement(Reservation reservation, Long idEvenement) {
        Evenement evenement = EvenementRepository.findById(idEvenement).orElse(null);
        Assert.notNull(evenement, "id not found");
        Assert.notNull(reservation, "reservation ne doit pas etre null");
        ReservationRepository.saveAndFlush(reservation);
        evenement.getReservations().add(reservation);//TCHOUF CLASS ELI TJERI
        return reservation;
    }


}
