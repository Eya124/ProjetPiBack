package tn.esprit.projetpiback.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.projetpiback.entites.Reservation;
import tn.esprit.projetpiback.repository.ReservationRepository;
import tn.esprit.projetpiback.services.ReservationService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getALl() {
        return reservationRepository.findAll();
    }

    @Override
    public void delete(int id) {
        reservationRepository.deleteById(id);

    }
    @Override
    public int getNbrReservationUser(Integer idUser) {
        return reservationRepository.countReservationsByUser_IdUser(idUser);
    }

}
