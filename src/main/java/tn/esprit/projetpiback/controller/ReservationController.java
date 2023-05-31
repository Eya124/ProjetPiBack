package tn.esprit.projetpiback.controller;

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
   @PostMapping
   public Reservation save(@RequestBody Reservation reservation){
       return iAppService.addResrvation(reservation);
   }


    @GetMapping
    public List<Reservation> getAll(){
        return iAppService.getALl();
    }

   @DeleteMapping("/{id}")
   void delete(@PathVariable int id){
       iAppService.delete(id);
   }
}