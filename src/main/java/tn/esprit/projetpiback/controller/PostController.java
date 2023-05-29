package tn.esprit.projetpiback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetpiback.entites.Post;
import tn.esprit.projetpiback.services.impl.ImpNotificationService;
import tn.esprit.projetpiback.services.impl.ImpPostService;

import java.util.List;

@RestController
@RequestMapping("post")
@RequiredArgsConstructor
public class PostController {
    private final ImpPostService impPostService;
    private final ImpNotificationService impNotificationService;
    @GetMapping()
    public List<Post> getAllPost(){
        return impPostService.getAllPost();
    }
    @GetMapping("/{id}")
    public Post getByIdPost(@PathVariable int id){
        return impPostService.getByIdPost(id);
    }
    @DeleteMapping("/{id}")
    private void deletePost(@PathVariable int id){
        impPostService.deletePost(id);
    }
    @PostMapping()
    public void ajouterPost(@RequestBody Post post){
        impPostService.ajouterPost(post);
    }
    @PutMapping()
    private Post updatePost(@RequestBody Post post){
        impPostService.updatePost(post);
        return post;
    }
    // Autre constructeur existant qui ne prend pas de paramètre
    /*public PostController() {
        // Code du constructeur sans paramètre
    }*/

    //ajout une notification
    /*public PostController(ImpNotificationService impNotificationService) {
        this.impNotificationService = impNotificationService;
    }*/
    @PostMapping("/posts")
    public ResponseEntity<String> createPost(@RequestBody Post post) {
        // Logique pour créer la publication

        // Envoie d'une notification
        impNotificationService.createNotification("Nouvelle publication créée");

        return ResponseEntity.ok("Publication créée avec succès");
    }
}
