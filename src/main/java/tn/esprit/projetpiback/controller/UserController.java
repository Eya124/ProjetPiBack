package tn.esprit.projetpiback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.projetpiback.entites.User;
import tn.esprit.projetpiback.services.UserService;

import java.util.List;

@RestController
@RequestMapping("user")

@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/{name}/{lastname}")
    public List<User> findPartner(@PathVariable String name, @PathVariable String lastname){
      return userService.findPartner(name,lastname);
    };

}
