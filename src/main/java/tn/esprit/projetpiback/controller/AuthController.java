package tn.esprit.projetpiback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetpiback.dto.AuthResponseDTO;
import tn.esprit.projetpiback.dto.LoginDto;
import tn.esprit.projetpiback.dto.RegisterDto;
import tn.esprit.projetpiback.entites.ResetPasswordToken;
import tn.esprit.projetpiback.entites.Role;
import tn.esprit.projetpiback.entites.User;
import tn.esprit.projetpiback.exceptions.InvalidTokenException;
import tn.esprit.projetpiback.repository.ResetPasswordTokenRepository;
import tn.esprit.projetpiback.repository.RoleRepository;
import tn.esprit.projetpiback.repository.UsersRepository;
import tn.esprit.projetpiback.security.CustomUserDetailsService;
import tn.esprit.projetpiback.security.JWTGenerator;
import tn.esprit.projetpiback.services.EmailService;

import javax.transaction.Transactional;
import java.util.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UsersRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTGenerator jwtGenerator;
    private final ResetPasswordTokenRepository resetPasswordTokenRepository;
    private final EmailService emailService;
    private final CustomUserDetailsService customUserDetailsService;

    @Transactional
    @PostMapping("reset-password/request/{email}")
    public ResponseEntity<String> requestPasswordReset(@PathVariable String email) {
        User user = userRepository.findUserByUsername(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Generate a reset password token
        String token = UUID.randomUUID().toString();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, 24); // Le jeton expirera dans 24 heures
        Date expirationDate = calendar.getTime();
        System.out.println("1234567");

        ResetPasswordToken resetPasswordToken = new ResetPasswordToken(token, expirationDate, user);
        resetPasswordTokenRepository.save(resetPasswordToken);

        // Send email to the user with the password reset link
        String resetPasswordLink = "http://localhost:9091/api/auth/reset-password/1/" + token;
        emailService.sendResetPasswordEmail(email, resetPasswordLink);System.out.println("1234567");


        return new ResponseEntity<>("Password reset email sent", HttpStatus.OK);
    }

    @GetMapping("reset-password/{token}")
    public ResponseEntity<String> validateResetPasswordToken(@PathVariable String token) {
        ResetPasswordToken resetPasswordToken = resetPasswordTokenRepository.findByToken(token);
        if (resetPasswordToken == null || resetPasswordToken.getExpirationDate().before(new Date())) {
            throw new InvalidTokenException("Invalid or expired reset password token");
        }

        return new ResponseEntity<>("Token validated", HttpStatus.OK);
    }

    @PostMapping("reset-password/1/{token}")
    public ResponseEntity<String> resetPassword(@PathVariable String token, @RequestBody String newPassword) {
        ResetPasswordToken resetPasswordToken = resetPasswordTokenRepository.findByToken(token);
        if (resetPasswordToken == null || resetPasswordToken.getExpirationDate().before(new Date())) {
            throw new InvalidTokenException("Invalid or expired reset password token");
        }

        User user = resetPasswordToken.getUser();
        System.out.println(user.getPassword());
        user.setPassword(null);
        userRepository.save(user);

        return new ResponseEntity<>("Password reset successfully", HttpStatus.OK);
    }





    /*@GetMapping("/current")
    public Optional<User> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> userDTO = userRepository.findByUsername(username);
        return userDTO;
    }*/
   @GetMapping("/current")
    public User getUserConnecte(){
        return userRepository.findUserByUsername(customUserDetailsService.getCurrentUserName())  ;  }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),
                loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode((registerDto.getPassword())));
        user.setAge(registerDto.getAge());
        user.setPrenomPere(registerDto.getPrenomPere());
        user.setTelephone(registerDto.getTelephone());
        user.setNom(registerDto.getNom());
        user.setPrenom(registerDto.getPrenom());
        user.setAdresse(registerDto.getAdresse());
        Role roles = roleRepository.findByName(registerDto.getRoleName());
        user.setRoles(Collections.singletonList(roles));

        userRepository.save(user);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }




}
