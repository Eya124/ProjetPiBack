package tn.esprit.projetpiback.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.projetpiback.entites.Reclamation;
import tn.esprit.projetpiback.services.ReclamationService;


@RestController
@RequestMapping("reclamation")
@RequiredArgsConstructor
public class ReclamationController {
    private final ReclamationService reclamationService;

    @PostMapping("/post")
    public void ajouterReclamation(@RequestBody Reclamation rec) {
            reclamationService.ajouterReclamation(rec);
    }


}
