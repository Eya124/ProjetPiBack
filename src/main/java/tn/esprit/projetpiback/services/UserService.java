package tn.esprit.projetpiback.services;

public interface UserService {
    void sendEmail();
    void sendEmailParametre(String to, String subject, String message);
    void findPartner(String name,String lastname);

}
