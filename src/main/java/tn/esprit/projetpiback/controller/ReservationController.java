package tn.esprit.projetpiback.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetpiback.entites.Reservation;
import tn.esprit.projetpiback.services.ReservationService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService iAppService;
   @PostMapping("/archiverReservation/{reservationId}")
  public void save(@PathVariable("reservationId") Integer reservationId){
    iAppService.insertReservationWithActif(reservationId);
   }


    @GetMapping
    public List<Reservation> getAll(){
        return iAppService.getALl();
    }

   /*@DeleteMapping("/{id}")
   void delete(@PathVariable int id){
       iAppService.delete(id);
   }*/
    @GetMapping("/nbReservation/{idEvenement}")
    public int nbReservationParUser(@PathVariable Integer idEvenement) {
        return iAppService.getNbrReservationActifEvenement(idEvenement, false);
    }
}