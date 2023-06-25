package tn.esprit.projetpiback.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetpiback.entites.Evenement;
import tn.esprit.projetpiback.entites.Reservation;
import tn.esprit.projetpiback.services.ReservationService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("reservation")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ReservationController {
    private final ReservationService iAppService;
   @PostMapping("/archiverReservation/{reservationId}")
  public void save(@PathVariable("reservationId") Integer reservationId){
    iAppService.insertReservationWithActif(reservationId);
   }


    @GetMapping("/{idUser}")
    public List<Evenement> getAll(@PathVariable("idUser") Integer idUser){
        return iAppService.getALlbyUserAndDate(idUser);
    }


    @GetMapping("/nbReservation/{idEvenement}")
    public int nbReservationParUser(@PathVariable Long idEvenement) {
        return iAppService.getNbrReservationActifEvenement(idEvenement, false);
    }
}