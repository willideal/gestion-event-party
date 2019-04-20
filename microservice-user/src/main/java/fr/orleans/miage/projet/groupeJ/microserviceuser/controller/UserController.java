package fr.orleans.miage.projet.groupeJ.microserviceuser.controller;

import fr.orleans.miage.projet.groupeJ.microserviceuser.dao.service.IUser;
import fr.orleans.miage.projet.groupeJ.microserviceuser.dao.service.UserImpl;
import fr.orleans.miage.projet.groupeJ.microserviceuser.domain.Follow;
import fr.orleans.miage.projet.groupeJ.microserviceuser.domain.Login;
import fr.orleans.miage.projet.groupeJ.microserviceuser.model.Notification;
import fr.orleans.miage.projet.groupeJ.microserviceuser.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

/**
 * Created by wilfrid on 02/03/2019.
 */
@RestController
@RequestMapping(value ="/")
@Api( description="API pour la gestion des users et leurs amis ")
public class UserController {

    @Autowired
    private UserImpl facade;


    //inscription du user
    @ApiOperation(value = "Permet d'ajouter un nouveau user!")
    @PostMapping(value = "users")
    public ResponseEntity inscription(@RequestBody User u){
        facade.inscription(u);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{pseudo}")
                .buildAndExpand(u.getPseudo()).toUri();

        return ResponseEntity.created(location).build();
    }

    //retourne les pseudo des amis du user pour envoi de notification
    @PostMapping(value = "users/login")
    @ApiOperation(value = "Permet de connecter un user!")
    public  ResponseEntity connexion(@RequestBody Login login){
         facade.connexion(login);


         return ResponseEntity.ok().build();
    }


    @PostMapping(value = "users/follow")
    @ApiOperation(value = "Permet de suivre un user sur le reseau social")
    public ResponseEntity follow(@RequestBody Follow follow){
        facade.follow(follow);

        return  ResponseEntity.ok().build();
    }


    @PostMapping(value = "users/unfollow")
    @ApiOperation(value = "Permet de ne plus suivre un user sur le reseau social")
    public ResponseEntity unfollow(@RequestBody Follow follow){

        facade.unfollow(follow);

        return  ResponseEntity.ok().build();
    }

    @GetMapping(value = "users/friends/{pseudo}")
    @ApiOperation(value = "Permet de recuperer les amis d'un user")
    public  Collection<String> getFriendPseudo(@PathVariable("pseudo") String  pseudo){
       Collection<String> friend = facade.userFriends(pseudo);

            return    friend;

    }




    @GetMapping(value = "users/{pseudo}")
    @ApiOperation(value = "Permet de recuperer un user grace a son pseudo dans url!")
    public  ResponseEntity<User> getUser(@PathVariable("pseudo") String  pseudo){
        User user= facade.getUserByPseudo(pseudo);

        return    ResponseEntity.ok(user);

    }

    @GetMapping(value = "users/pseudo")
    @ApiOperation(value = "Permet de recuperer un user grace a son pseudo dans le parametre!")
    public  User getUserByPseudoMethod(@RequestParam("pseudo") String  pseudo){
        User user= facade.getUserByPseudo(pseudo);

        return   user;

    }

    @PostMapping(value = "users/notif/uupdate/soiree")
    @ApiOperation(value = "Permet d'ajouter une notification à un user!")
    public  void updateUser(@RequestBody User  user){
         facade.updateUserNotif(user);
    }


    @PostMapping(value = "users/notif/soiree")
    @ApiOperation(value = "Permet de creer une notification d'alerte soiree")
    public  long creerNotifSoiree(@RequestParam("pseudo")String pseudo,
                                  @RequestParam("amis")String amis,
                                  @RequestParam("id")long id,
                                  @RequestParam("nomSoiree")String nomSoiree){
       long idCree = facade.creerNotifSoiree(pseudo, amis, id, nomSoiree);

        return  idCree;
    }

    @GetMapping(value = "users")
    @ApiOperation(value = "Permet de recuperer tous les utilisateurs!")
    public  Iterable<User> getAllUser(){
        return   facade.getAllUser();

    }

    @GetMapping("users/notif/{pseudo}")
    @ApiOperation(value = "Permet de recuperer  les notifications d'un utilisateur!")
    public  Collection<Notification> getAllNotifUser(@PathVariable("pseudo") String  pseudo){

        return   facade.getNotifsById(pseudo);

    }


}

