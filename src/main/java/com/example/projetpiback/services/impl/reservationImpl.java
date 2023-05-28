package com.example.projetpiback.services.impl;

import com.example.projetpiback.repository.reservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j

public class reservationImpl {
    private final reservationRepository reservationRepository;
}
