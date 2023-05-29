package tn.esprit.projetpiback.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.projetpiback.entites.User;
import tn.esprit.projetpiback.repository.UsersRepository;
import tn.esprit.projetpiback.services.UserService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImpUserService implements UserService {
    private final JavaMailSender mailSender;
    private final UsersRepository usersRepository;



    @Scheduled(cron = "0 0 12 * * *")
    @Override
    public void sendEmail() {
        LocalDate date = LocalDate.now();
        LocalDate d1 =date.minusDays(15);
        LocalDate d2 =date.minusDays(30);
        LocalDate d3 =date.minusDays(120);
        List<User> users1=usersRepository.findAllByLastLog(d1);
        List<User> users2=usersRepository.findAllByLastLog(d2);
        List<User> users3=usersRepository.findAllByLastLog(d3);
        LocalDate d4 =date.plusDays(90);
        String subject="";
        String message="";

        for(User u:users1) {
            subject=subject+ "Your Inactivity in BEST CAMP";
            message=message+"Hello "+ u.getNom()+ ",\n" +
                    "\n" +
                    "We hope this email finds you well. "+"\n"+" We wanted to inform you that it has been 15 days since your last visit to BEST CAMP. We wanted to reach out and let you know that we miss you!";
            sendEmailParametre(u.getEmail(),subject,message);


            }
        for(User u:users2) {
            subject=subject+ "Your Inactivity in BEST CAMP";
            message=message+"Hello "+ u.getNom()+ ",\n" +
                    "\n" +
                    "We hope this email finds you well. "+"\n"+" We wanted to inform you that it has been 30 days since your last visit to BEST CAMP. We wanted to reach out and let you know that we miss you!"+"\n"+"Your account will be removed on "+d4;
            sendEmailParametre(u.getEmail(),subject,message);


        }
        for(User u:users3){
            usersRepository.delete(u);
        }


    }

    @Override
    public void sendEmailParametre(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("bestcamp195@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        this.mailSender.send(simpleMailMessage);

    }
}
