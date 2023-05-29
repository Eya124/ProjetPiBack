package tn.esprit.projetpiback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projetpiback.entites.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    // Ajoutez des méthodes supplémentaires si nécessaire
}
