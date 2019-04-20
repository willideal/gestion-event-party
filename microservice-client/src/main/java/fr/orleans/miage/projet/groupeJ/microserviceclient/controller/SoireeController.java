package fr.orleans.miage.projet.groupeJ.microserviceclient.controller;

import fr.orleans.miage.projet.groupeJ.microserviceclient.beans.*;
import fr.orleans.miage.projet.groupeJ.microserviceclient.proxies.MicroserviceEventProxy;
import fr.orleans.miage.projet.groupeJ.microserviceclient.proxies.MicroserviceNotificationProxy;
import fr.orleans.miage.projet.groupeJ.microserviceclient.proxies.MicroserviceSoireeProxy;
import fr.orleans.miage.projet.groupeJ.microserviceclient.proxies.MicroserviceUserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by wilfrid on 17/03/2019.
 */
@Controller
@SessionAttributes("pseudo")
public class SoireeController {

    @Autowired
    MicroserviceSoireeProxy microserviceSoireeProxy;


    @Autowired
    MicroserviceEventProxy microserviceEventProxy;

    @Autowired
    MicroserviceUserProxy microserviceUserProxy;


    //
    @GetMapping(value = "soiree")
    public String addSoireeTemplate(Model model,
                     @SessionAttribute(value="pseudo", required = false) String pseudo){

        model.addAttribute("soiree", new SoireeBean());
        model.addAttribute("pseudo", pseudo);

        return "addSoiree";
    }

    @PostMapping(value = "soiree")
    public String addsoiree(Model model, @ModelAttribute SoireeBean soireeBean ,
                            @SessionAttribute(value="pseudo", required = false) String pseudo){

      long idSoiree =  microserviceSoireeProxy.creerSoiree(soireeBean);
        Collection<EvenementBean> events =  microserviceEventProxy.getEventByPseudo(pseudo);

        SoireeBean soireeBean1 = microserviceSoireeProxy.getSoireeById(idSoiree);

        model.addAttribute("idSoiree", idSoiree);
        model.addAttribute("pseudo", pseudo);
        model.addAttribute("nomSoiree", soireeBean1.getNom());
        model.addAttribute("events", events);

        return "customSoiree";
    }


    @GetMapping(value = "soirees/{pseudo}")
    public String allSoiree(Model model,
                                    @SessionAttribute(value="pseudo", required = false) String pseudo){

        Collection<SoireeBean> soirees =  microserviceSoireeProxy.getAllSoiree(pseudo);

        model.addAttribute("soirees", soirees);
        model.addAttribute("pseudo", pseudo);

        return "allSoiree";
    }


    @PostMapping(value = "soiree/notification/{id}")
    public String notifSoireeToFriends(Model model, @PathVariable("id") long id,
                            @SessionAttribute(value="pseudo", required = false) String pseudo){

        Collection<String> friend  = microserviceUserProxy.getFriendPseudo(pseudo);
        SoireeBean soiree = microserviceSoireeProxy.getSoireeById(id);
       /* NotificationBean nb = new NotificationBean();
        nb.setMessage("votre ami "+ pseudo +" vous  invite à la soiree "+ soiree.getNom() );
        nb.setPseudoSender(pseudo);
        nb.setTypeNotif("invite_soiree");
        nb.setIdSoiree(soiree.getId());*/

      //  long idNotifSoiree = microserviceNotificationProxy.addNotifSoiree(notif);

        for (String ami: friend) {
            UserBean user = microserviceUserProxy.getUserByPseudoMethod(ami);
           // Collection<NotificationBean> notifUser =  microserviceUserProxy.getAllNotifUser(ami);
            UserBean userAmi = microserviceUserProxy.getUserByPseudoMethod(ami);
            microserviceUserProxy.creerNotifSoiree(pseudo, ami, id, soiree.getNom());

          //  userAmi.getNotifications().add(idNotif);

            //userAmi.setNotifications(notifUser);
           // microserviceUserProxy.updateUser(userAmi);

        }

        model.addAttribute("msg", "invitation envoyé");
       // SoireeBean soiree =  microserviceSoireeProxy.getSoireeById(idSoiree);
        Collection<EvenementBean> eventOfSoiree = new ArrayList<>();
        Collection<EvenementOpenDataBean> eventOpenDataOfSoiree = new ArrayList<>();

        for (long idSp: soiree.getEvenementsPrivee()) {
            eventOfSoiree.add(microserviceEventProxy.getEventById(idSp));


        }

        for (long idSo: soiree.getEvenementsExterne()) {
            eventOpenDataOfSoiree.add(microserviceEventProxy.getEventOpenDataById(idSo));


        }

        model.addAttribute("soiree", soiree);
        model.addAttribute("participants", soiree.getParticipant());
        model.addAttribute("eventPrivateOfSoiree", eventOfSoiree);
        model.addAttribute("eventOpenDataOfSoiree", eventOpenDataOfSoiree);
        model.addAttribute("pseudo", pseudo);


        return "detail-soiree";
    }


    @GetMapping(value = "soiree/{idSoiree}")
    public String detailSoiree(Model model, @PathVariable("idSoiree") long idSoiree,
                            @SessionAttribute(value="pseudo", required = false) String pseudo){

        SoireeBean soiree =  microserviceSoireeProxy.getSoireeById(idSoiree);
        Collection<EvenementBean> eventOfSoiree = new ArrayList<>();
        Collection<EvenementOpenDataBean> eventOpenDataOfSoiree = new ArrayList<>();

        for (long id: soiree.getEvenementsPrivee()) {
            eventOfSoiree.add(microserviceEventProxy.getEventById(id));


        }

        for (long id: soiree.getEvenementsExterne()) {
            eventOpenDataOfSoiree.add(microserviceEventProxy.getEventOpenDataById(id));


        }

        model.addAttribute("soiree", soiree);
        model.addAttribute("participants", soiree.getParticipant());
        model.addAttribute("eventPrivateOfSoiree", eventOfSoiree);
        model.addAttribute("eventOpenDataOfSoiree", eventOpenDataOfSoiree);
        model.addAttribute("pseudo", pseudo);
        model.addAttribute("notification", new NotificationBean());

        return "detail-soiree";
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
    public String detailNotifSoiree(Model model, @PathVariable("idSoiree") long idSoiree,
                               @SessionAttribute(value="pseudo", required = false) String pseudo){

        SoireeBean soiree =  microserviceSoireeProxy.getSoireeById(idSoiree);
        Collection<EvenementBean> eventOfSoiree = new ArrayList<>();
        Collection<EvenementOpenDataBean> eventOpenDataOfSoiree = new ArrayList<>();

        for (long id: soiree.getEvenementsPrivee()) {
            eventOfSoiree.add(microserviceEventProxy.getEventById(id));


        }

        for (long id: soiree.getEvenementsExterne()) {
            eventOpenDataOfSoiree.add(microserviceEventProxy.getEventOpenDataById(id));


        }

        model.addAttribute("soiree", soiree);
      //  model.addAttribute("participants", soiree.getParticipant());
        model.addAttribute("eventPrivateOfSoiree", eventOfSoiree);
        model.addAttribute("eventOpenDataOfSoiree", eventOpenDataOfSoiree);
        model.addAttribute("pseudo", pseudo);
        model.addAttribute("notification", new NotificationBean());

        return "detailNotif-soiree";
    }

    @PostMapping(value = "soiree/participe/{idSoiree}")
    public String participerTosoiree(@SessionAttribute(value="pseudo", required = false) String pseudo,
                                   @PathVariable("idSoiree") long idSoiree, Model model){

         microserviceSoireeProxy.addParticipantToSoiree(idSoiree, pseudo);
        model.addAttribute("msg", "Votre participation a ete prise en compte");
        UserBean user = microserviceUserProxy.getUserByPseudoMethod(pseudo);
        model.addAttribute("user", user);
        model.addAttribute("pseudo", user.getPseudo());
        model.addAttribute("friends", microserviceUserProxy.getFriendPseudo(user.getPseudo()));


        return  "dashboard";
    }

}
