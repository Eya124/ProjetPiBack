package tn.esprit.projetpiback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.projetpiback.entites.User;
import tn.esprit.projetpiback.repository.UsersRepository;
import tn.esprit.projetpiback.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")

@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UsersRepository userRepository;

    @GetMapping("/current")
    public Optional<User> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> userDTO = userRepository.findByUsername(username);
        return userDTO;
    }
    @GetMapping("/{name}/{lastname}")
    public List<User> findPartner(@PathVariable String name, @PathVariable String lastname){
      return userService.findPartner(name,lastname);
    };

}
