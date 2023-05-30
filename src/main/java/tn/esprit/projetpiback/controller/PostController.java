package tn.esprit.projetpiback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetpiback.entites.Commentaire;
import tn.esprit.projetpiback.entites.Post;
import tn.esprit.projetpiback.services.PostService;
import tn.esprit.projetpiback.services.impl.ImpNotificationService;
import tn.esprit.projetpiback.services.impl.ImpPostService;

import java.util.List;

@RestController
@RequestMapping("post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping()
    public List<Post> getAllPost(){
        return postService.getAllPost();
    }
    @GetMapping("/{id}")
    public Post getByIdPost(@PathVariable int id){
        return postService.getByIdPost(id);
    }
    @DeleteMapping("/{id}")
    private void deletePost(@PathVariable int id){
        postService.deletePost(id);
    }
    @PostMapping()
    public void ajouterPost(@RequestBody Post post){
        postService.ajouterPost(post);
    }
    @PutMapping()
    private Post updatePost(@RequestBody Post post){
        postService.updatePost(post);
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
//    @PostMapping("/posts")
//    public ResponseEntity<Post> createPost(@RequestBody Post post) {
//        // Logique pour créer la publication
//
//        // Envoie d'une notification
//        impNotificationService.createNotification("Nouvelle publication créée");
//
//        return ResponseEntity.ok("Publication créée avec succès");
//    }

    @PostMapping("/{postId}/comments")
    public String addCommentToPost(@PathVariable Integer postId, @RequestBody Commentaire commentaire) {
        postService.addCommentToPost(postId, commentaire);
        return "Commentaire ajouté avec succès";
    }

    @PostMapping("/comments/{commentId}/replies")
    public String addReplyToComment(@PathVariable Integer commentId, @RequestBody Commentaire reply) {
        postService.addReplyToComment(commentId, reply);
        return "Réponse ajoutée avec succès";
    }
}
