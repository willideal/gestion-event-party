package fr.orleans.miage.projet.groupeJ.gateway.proxies;

import fr.orleans.miage.projet.groupeJ.gateway.beans.NotificationBean;
import fr.orleans.miage.projet.groupeJ.gateway.beans.UserBean;
import fr.orleans.miage.projet.groupeJ.gateway.domain.Follow;
import fr.orleans.miage.projet.groupeJ.gateway.domain.Login;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by wilfrid on 12/03/2019.
 */
//le client passe par le gateway pour recuperer des infos sur
@FeignClient(name = "gateway")
//@FeignClient(name = "microservice-user", url = "localhost:8086")
public interface MicroserviceUserProxy {


    @GetMapping(value = "/microservice-user/users")
    Iterable<UserBean> getAllUser();


    @GetMapping( value = "/microservice-user/users/pseudo")
    UserBean getUserByPseudoMethod(@RequestParam("pseudo") String pseudo);


    @PostMapping(value = "/microservice-user/users/login")
     void connexion(@RequestBody Login login);

    @PostMapping(value = "/microservice-user/users/follow")
    ResponseEntity follow(@RequestBody Follow follow);

    @PostMapping(value = "/microservice-user/users/unfollow")
    ResponseEntity unfollow(@RequestBody Follow follow);

    @PostMapping(value = "/microservice-user/users")
    ResponseEntity inscription(@RequestBody UserBean u);

    @GetMapping(value = "/microservice-user/users/friends/{pseudo}")
    Collection<String> getFriendPseudo(@PathVariable("pseudo") String pseudo);

    @GetMapping(value = "/microservice-user/users/notif/{pseudo}")
    Collection<NotificationBean> getAllNotifUser(@PathVariable("pseudo") String pseudo);

   /* @PostMapping(value = "/microservice-user/users/notif/soiree")
      void updateUser(@RequestBody UserBean  user);*/
   @PostMapping(value = "/microservice-user/users/notif/soiree")
     long creerNotifSoiree(@RequestParam("pseudo") String pseudo,
                           @RequestParam("amis") String amis,
                           @RequestParam("id") long id,
                           @RequestParam("nomSoiree") String nomSoiree);
}
