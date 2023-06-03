package tn.esprit.projetpiback.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetpiback.entites.Reclamation;
import tn.esprit.projetpiback.entites.User;
import tn.esprit.projetpiback.services.ReclamationService;


@RestController
@RequestMapping("reclamation")
@RequiredArgsConstructor
public class ReclamationController {
    private final ReclamationService reclamationService;

    @PostMapping("/post/{iduser1}/{iduser2}")
    public void ajouterReclamation(@RequestBody Reclamation rec, @PathVariable int iduser1,@PathVariable int iduser2) {
            reclamationService.ajouterReclamation(rec,iduser1,iduser2);
    }


}
