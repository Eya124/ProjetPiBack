package tn.esprit.projetpiback.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.projetpiback.repository.ReservationRepository;

@Service
@RequiredArgsConstructor
public class ReservationImpl {
    private final ReservationRepository reservationRepository;
}
