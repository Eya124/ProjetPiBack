package tn.esprit.projetpiback.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.projetpiback.repository.ReservationRepository;

@Service
@RequiredArgsConstructor
@Slf4j

public class reservationImpl {
    private final ReservationRepository reservationRepository;
}