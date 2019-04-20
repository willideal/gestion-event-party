package fr.orleans.miage.projet.groupeJ.gateway.controller;

import fr.orleans.miage.projet.groupeJ.gateway.beans.*;
import fr.orleans.miage.projet.groupeJ.gateway.proxies.MicroserviceEventProxy;
import fr.orleans.miage.projet.groupeJ.gateway.proxies.MicroserviceSoireeProxy;
import fr.orleans.miage.projet.groupeJ.gateway.proxies.MicroserviceUserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wilfrid on 17/03/2019.
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@SessionAttributes("pseudo")
public class SoireeController {

    @Autowired
    MicroserviceSoireeProxy microserviceSoireeProxy;


    @Autowired
    MicroserviceEventProxy microserviceEventProxy;

    @Autowired
    MicroserviceUserProxy microserviceUserProxy;



    @PostMapping(value = "soiree")
    public ResponseEntity<Long> addsoiree(Model model, @RequestBody SoireeBean soireeBean ){

      long idSoiree =  microserviceSoireeProxy.creerSoiree(soireeBean);
       /* Collection<EvenementBean> events =  microserviceEventProxy.getEventByPseudo(pseudo);

        SoireeBean soireeBean1 = microserviceSoireeProxy.getSoireeById(idSoiree);*/


        return ResponseEntity.ok(idSoiree);
    }


    @GetMapping(value = "soirees/{pseudo}")
    public ResponseEntity<Collection<SoireeBean>> allSoiree(@PathVariable(value="pseudo") String pseudo){

        Collection<SoireeBean> soirees =  microserviceSoireeProxy.getAllSoiree(pseudo);


        return ResponseEntity.ok(soirees);
    }


    @PostMapping(value = "soiree/notification/{id}")
    public ResponseEntity notifSoireeToFriends( @PathVariable("id") long id,
                            @SessionAttribute(value="pseudo", required = false) String pseudo){

        Collection<String> friend  = microserviceUserProxy.getFriendPseudo(pseudo);
        SoireeBean soiree = microserviceSoireeProxy.getSoireeById(id);

        for (String ami: friend) {
            UserBean user = microserviceUserProxy.getUserByPseudoMethod(ami);
           // Collection<NotificationBean> notifUser =  microserviceUserProxy.getAllNotifUser(ami);
            UserBean userAmi = microserviceUserProxy.getUserByPseudoMethod(ami);
            microserviceUserProxy.creerNotifSoiree(pseudo, ami, id, soiree.getNom());

        }

       // SoireeBean soiree =  microserviceSoireeProxy.getSoireeById(idSoiree);
        Collection<EvenementBean> eventOfSoiree = new ArrayList<>();
        Collection<EvenementOpenDataBean> eventOpenDataOfSoiree = new ArrayList<>();

        for (long idSp: soiree.getEvenementsPrivee()) {
            eventOfSoiree.add(microserviceEventProxy.getEventById(idSp));


        }

        for (long idSo: soiree.getEvenementsExterne()) {
            eventOpenDataOfSoiree.add(microserviceEventProxy.getEventOpenDataById(idSo));


        }

    /*    model.addAttribute("soiree", soiree);
        model.addAttribute("participants", soiree.getParticipant());
        model.addAttribute("eventPrivateOfSoiree", eventOfSoiree);
        model.addAttribute("eventOpenDataOfSoiree", eventOpenDataOfSoiree);
        model.addAttribute("pseudo", pseudo);*/


        return ResponseEntity.ok().build();
    }



    @GetMapping(value = "soiree/{idSoiree}")
    public ResponseEntity<Map<String, Object>> detailSoiree(Model model, @PathVariable("idSoiree") long idSoiree,
                                                            @SessionAttribute(value="pseudo", required = false) String pseudo){

        Map<String, Object> data  = new HashMap<>();
        SoireeBean soiree =  microserviceSoireeProxy.getSoireeById(idSoiree);
        Collection<EvenementBean> eventOfSoiree = new ArrayList<>();
        Collection<EvenementOpenDataBean> eventOpenDataOfSoiree = new ArrayList<>();

        for (long id: soiree.getEvenementsPrivee()) {
            eventOfSoiree.add(microserviceEventProxy.getEventById(id));


        }
        data.put("eventPrivate", eventOfSoiree);

        for (long id: soiree.getEvenementsExterne()) {
            eventOpenDataOfSoiree.add(microserviceEventProxy.getEventOpenDataById(id));


        }

        data.put("eventOpenData", eventOpenDataOfSoiree);
       /* model.addAttribute("soiree", soiree);
        model.addAttribute("participants", soiree.getParticipant());
        model.addAttribute("eventPrivateOfSoiree", eventOfSoiree);
        model.addAttribute("eventOpenDataOfSoiree", eventOpenDataOfSoiree);
        model.addAttribute("pseudo", pseudo);
        model.addAttribute("notification", new NotificationBean());*/

        return ResponseEntity.ok(data);
    }

    @PutMapping(value = "soiree/{idSoiree}/eventPrivate/{idEventPrivate}")
    public ResponseEntity ajouterEventPriveeToSoiree(@PathVariable("idSoiree") long idSoiree,
                                           @PathVariable("idEventPrivate") long idEventPrivate){
        microserviceSoireeProxy.ajouterEventPriveeToSoiree(idSoiree, idEventPrivate);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "soiree/{idSoiree}/eventopendata/{idEventOpenData}")
    public ResponseEntity ajouterEventOpenDataToSoiree(@PathVariable("idSoiree") long idSoiree,
                                                     @PathVariable("idEventOpenData") long idEventOpenData){
        microserviceSoireeProxy.ajouterEventOpenDataToSoiree(idSoiree, idEventOpenData);
        return ResponseEntity.ok().build();
    }



    @GetMapping(value = "soiree/notif/{idSoiree}")
    public ResponseEntity<SoireeBean> detailNotifSoiree( @PathVariable("idSoiree") long idSoiree,
                               @SessionAttribute(value="pseudo", required = false) String pseudo){

        SoireeBean soiree =  microserviceSoireeProxy.getSoireeById(idSoiree);
        Collection<EvenementBean> eventOfSoiree = new ArrayList<>();
        Collection<EvenementOpenDataBean> eventOpenDataOfSoiree = new ArrayList<>();

      /*  for (long id: soiree.getEvenementsPrivee()) {
            eventOfSoiree.add(microserviceEventProxy.getEventById(id));


        }

        for (long id: soiree.getEvenementsExterne()) {
            eventOpenDataOfSoiree.add(microserviceEventProxy.getEventOpenDataById(id));


        }*/


        return ResponseEntity.ok(soiree);
    }

    @PostMapping(value = "soiree/participe/{idSoiree}")
    public ResponseEntity participerTosoiree(@SessionAttribute(value="pseudo", required = false) String pseudo,
                                   @PathVariable("idSoiree") long idSoiree){

         microserviceSoireeProxy.addParticipantToSoiree(idSoiree, pseudo);
      /*  model.addAttribute("msg", "Votre participation a ete prise en compte");
        UserBean user = microserviceUserProxy.getUserByPseudoMethod(pseudo);
        model.addAttribute("user", user);
        model.addAttribute("pseudo", user.getPseudo());
        model.addAttribute("friends", microserviceUserProxy.getFriendPseudo(user.getPseudo()));
*/

        return  ResponseEntity.ok().build();
    }

}
