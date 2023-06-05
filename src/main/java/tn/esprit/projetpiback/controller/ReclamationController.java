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

    @PostMapping("/post/{iduserrec1}/{iduserarec2}")
    public void ajouterReclamation(@RequestBody Reclamation rec, @PathVariable int iduserrec1,@PathVariable int iduserarec2) {
            reclamationService.ajouterReclamation(rec,iduserrec1,iduserarec2);
    }


}
