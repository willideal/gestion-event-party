package fr.orleans.miage.projet.groupeJ.gateway.controller;

import fr.orleans.miage.projet.groupeJ.gateway.beans.EvenementBean;
import fr.orleans.miage.projet.groupeJ.gateway.beans.EvenementOpenDataBean;
import fr.orleans.miage.projet.groupeJ.gateway.proxies.MicroserviceEventProxy;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@SessionAttributes("pseudo")
public class EventController {


    @Autowired
    MicroserviceEventProxy microserviceEventProxy;




    @PostMapping(value = "/event", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<Long> addEvenementPrivee(@RequestBody EvenementBean evenement,
                                     @SessionAttribute(value="pseudo", required = false) String pseudo){

       long id =  microserviceEventProxy.creerEvenementPrivee(evenement);


        return ResponseEntity.ok(id);
    }

    @PostMapping(value = "event/openData",     consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<Long> addEvenementPriveess(@RequestBody EvenementOpenDataBean evenement,
                                               @SessionAttribute(value="pseudo", required = false) String pseudo){

       long id = microserviceEventProxy.openDataEventSave(evenement) ;

       /* model.addAttribute("event", new EvenementBean());
        model.addAttribute("pseudo", pseudo);
        model.addAttribute("msg", "votre evenement a ete bien ajouté");*/

        return ResponseEntity.ok(id);
    }
    @GetMapping(value = "event/{pseudo}")
    public ResponseEntity<Collection<EvenementBean>> getEventByPseudos(@PathVariable("pseudo") String pseudo, Model model){

        Collection<EvenementBean> events =  microserviceEventProxy.getEventByPseudo(pseudo);

        return ResponseEntity.ok(events);
    }

    @GetMapping(value = "event/private/{id}")
    public ResponseEntity<EvenementBean> getEventById(@PathVariable("id") long id){

        EvenementBean events =  microserviceEventProxy.getEventById(id);

        return ResponseEntity.ok(events);
    }


}
