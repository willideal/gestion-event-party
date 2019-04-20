package fr.orleans.miage.projet.groupeJ.microserviceclient.controller;

import fr.orleans.miage.projet.groupeJ.microserviceclient.beans.EvenementBean;
import fr.orleans.miage.projet.groupeJ.microserviceclient.beans.EvenementOpenDataBean;
import fr.orleans.miage.projet.groupeJ.microserviceclient.proxies.MicroserviceEventProxy;
import fr.orleans.miage.projet.groupeJ.microserviceclient.proxies.MicroserviceSoireeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by wilfrid on 17/03/2019.
 */
@Controller
@SessionAttributes("pseudo")
public class EventController {


    @Autowired
    MicroserviceEventProxy microserviceEventProxy;


    //
    @GetMapping(value = "event")
    public String addEvenementPriveeTemplate(Model model,
                     @SessionAttribute(value="pseudo", required = false) String pseudo){

        model.addAttribute("event", new EvenementBean());
        model.addAttribute("pseudo", pseudo);

        return "addEventPrivate";
    }


    @PostMapping(value = "event")
    public String addEvenementPrivee(@ModelAttribute EvenementBean evenement, Model model,
                                     @SessionAttribute(value="pseudo", required = false) String pseudo){

        microserviceEventProxy.creerEvenementPrivee(evenement);

        model.addAttribute("event", new EvenementBean());
        model.addAttribute("pseudo", pseudo);
        model.addAttribute("msg", "votre evenement a ete bien ajouté");

        return "addEventPrivate";
    }

    @PostMapping(value = "event/openData",     consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<Long> addEvenementPriveess(@RequestBody EvenementOpenDataBean evenement, Model model,
                                               @SessionAttribute(value="pseudo", required = false) String pseudo){

       long id = microserviceEventProxy.openDataEventSave(evenement) ;

       /* model.addAttribute("event", new EvenementBean());
        model.addAttribute("pseudo", pseudo);
        model.addAttribute("msg", "votre evenement a ete bien ajouté");*/

        return ResponseEntity.ok(id);
    }
    @GetMapping(value = "event/{pseudo}")
    String getEventByPseudos(@PathVariable("pseudo") String pseudo, Model model){

        Collection<EvenementBean> events =  microserviceEventProxy.getEventByPseudo(pseudo);
        model.addAttribute("events", events );
        model.addAttribute("pseudo", pseudo);

        return "allPrivateEvent";
    }


}
