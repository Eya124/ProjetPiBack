package tn.esprit.projetpiback.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.projetpiback.entites.Evenement;
import tn.esprit.projetpiback.entites.Reservation;
import tn.esprit.projetpiback.entites.User;
import tn.esprit.projetpiback.repository.EvenementRepository;
import tn.esprit.projetpiback.repository.ReservationRepository;
import tn.esprit.projetpiback.repository.UsersRepository;
import tn.esprit.projetpiback.services.EvenementService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImplEvenementService implements EvenementService {
    private final EvenementRepository EvenementRepository;
    private final UsersRepository UsersRepository;
    private final ReservationRepository ReservationRepository;
    @Override
    public void insertEvenementWithNbrParticipants(Long idEvenement) {
        Evenement evenement = EvenementRepository.findById(idEvenement).orElseThrow(() -> new IllegalArgumentException("Evenement not found"));
        int nbr = ReservationRepository.countReservationsByEvenements_IdEvenementAndActif(idEvenement, false);
        evenement.setNbrParticipants(nbr);
        EvenementRepository.save(evenement);
    }
    @Override
    @Transactional
    public Reservation addReservationAndAssignToEvenement(Integer idUser, Long idEvenement) {

        Reservation reservation1 = Reservation.builder()
                //.user()
                .build();

        Evenement evenement = EvenementRepository.findById(idEvenement).orElse(null);
        User user = UsersRepository.findById(idUser).orElse(null);
        Assert.notNull(evenement, "id not found");
        Assert.notNull(user, "id not found");
        reservation1.setUser(user);
        ReservationRepository.saveAndFlush(reservation1);
        List<Reservation> reservations =ReservationRepository.findReservationsByUserIdUserAndEvenementsDateDebutBetween(idUser, evenement.getDateDebut(), evenement.getDateFin());
        if(!reservations.isEmpty()){
            throw new RuntimeException("Une réservation existe déjà pour cet utilisateur et cet événement à la même date:"+evenement.getDateDebut());
        }
        if(evenement.getNbrMaxParticipants() <= evenement.getNbrParticipants()){
            throw new RuntimeException("désole, l'événement est complet");
        }
        evenement.getReservations().add(reservation1);//TCHOUF CLASS ELI TJERI
        this.insertEvenementWithNbrParticipants(idEvenement);
        return reservation1;
    }


}
