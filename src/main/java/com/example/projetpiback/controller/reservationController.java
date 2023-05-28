package com.example.projetpiback.controller;

import com.example.projetpiback.services.reservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class reservationController {
    private final reservationService iAppService;
}
