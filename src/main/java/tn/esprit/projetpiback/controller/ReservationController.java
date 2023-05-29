package tn.esprit.projetpiback.controller;

import tn.esprit.projetpiback.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService iAppService;
}