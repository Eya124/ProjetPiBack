package tn.esprit.projetpiback.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.projetpiback.entites.Evenement;
import tn.esprit.projetpiback.entites.Reclamation;
import tn.esprit.projetpiback.entites.Reservation;
import tn.esprit.projetpiback.entites.User;
import tn.esprit.projetpiback.repository.EvenementRepository;
import tn.esprit.projetpiback.repository.ReclamationRepository;
import tn.esprit.projetpiback.repository.ReservationRepository;
import tn.esprit.projetpiback.repository.UsersRepository;
import tn.esprit.projetpiback.services.ReclamationService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ReclamationServiceImp implements ReclamationService {
    private final ReclamationRepository reclamationRepository;
    private final EvenementRepository evenementRepository;
    private final ReservationRepository reservationRepository;
    private final UsersRepository usersRepository;
    @Override
    @Transactional
    public void ajouterReclamation(int iduserrec1,int iduserarec2,Reclamation rec) {
        //check users exists
        User userreclame = usersRepository.findById(iduserrec1).orElse(null);
        User userareclame = usersRepository.findById(iduserarec2).orElse(null);

        Assert.notNull(userareclame,"User doesn't exist");
        Assert.notNull(userreclame,"User doesn't exist");

        //condition 1 : check whether the user that is going to send a claim is registred in an event
                // get all id evenement of the user
        List<Reservation> reservs = reservationRepository.findReservationsByUserIdUserAndEvenementsDateDebutBefore(iduserrec1,new Date());
        List<Long> idevens=new ArrayList<>();
        for(Reservation x:reservs) {
            for(Evenement e: x.getEvenements()) {
                idevens.add(e.getIdEvenement());
            }
        }
        // condition 2: check that the one who's bein claimed is the one that posted the even
                // get alll even that has been posted by that user
        List<Evenement> evens2 = evenementRepository.findAllByUsereveIdUser(iduserarec2);
        List<Long> ideven2 = new ArrayList<>();
        for(Evenement evenement:evens2){
            ideven2.add(evenement.getIdEvenement());
        }
        System.out.println(idevens);
        System.out.println(ideven2);
    //    Assert.notNull(idevens,"No reservation found ");
     //   Assert.notNull(ideven2,"This User didn't post any events");
        // compare the 2 lists
        if (Collections.disjoint(idevens,ideven2)) {
            System.out.println("you cannot send a claim to this person");
        } else {
            rec.setUserrec(userreclame);
            rec.setUserarec(userareclame);
            reclamationRepository.save(rec);
        }
    }

    @Override
    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }
}
