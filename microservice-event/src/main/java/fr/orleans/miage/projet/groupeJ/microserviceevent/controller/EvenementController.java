package fr.orleans.miage.projet.groupeJ.microserviceevent.controller;

import fr.orleans.miage.projet.groupeJ.microserviceevent.dao.service.IEvenement;
import fr.orleans.miage.projet.groupeJ.microserviceevent.model.Evenement;
import fr.orleans.miage.projet.groupeJ.microserviceevent.model.EvenementOpenData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by wilfrid on 06/03/2019.
 */
@RestController(value = "/")
@Api( description="API pour les opérations CRUD des evenements")
public class EvenementController {

    @Autowired
    private IEvenement facade;

    //creer un event
    @ApiOperation(value = "Permet d'ajouter un nouvel evenement!")
    @PostMapping(value = "event")
    public Long creerEvenementPrivee(@RequestBody Evenement evenement){
      long idEvement =  facade.creerEventPrivee(evenement);

        return idEvement;

    }

    //sauvegarder les evenement opendata dans notre base
    @ApiOperation(value = "Permet d'ajouter un evenement openData!")
    @PostMapping(value = "event/openData", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public long openDataEventSave(@RequestBody EvenementOpenData evenementOpenData){
        long idEvementOpenData =  facade.creerEventOpenData(evenementOpenData);

        return idEvementOpenData;

    }

    //recuperer tous les evenet openData
    @ApiOperation(value = "Permet de recuperer tous les evenement open data!")
    @GetMapping(value = "event")
    public Iterable<EvenementOpenData> getAllEventOpenData(){

        return facade.getAllEventOpenData();

    }

    //recuperer  tous les events
    @ApiOperation(value = "Permet de recuperer les event privee d'un user")
    @GetMapping(value = "event/{pseudo}")
    public Collection<Evenement> getEventByPseudo(@PathVariable("pseudo") String pseudo){
      return   facade.getEventPrviateByPseudo(pseudo);

    }

    //recuperer  tous les events
    @ApiOperation(value = "Permet de recuperer un event privee avec son id!")
    @GetMapping(value = "event/private/{id}")
    public Evenement getEventById(@PathVariable("id") long id){
        return   facade.getEventPrviateById(id);

    }

    //recuperer  tous les opendata events
    @ApiOperation(value = "Permet de recuperer un evenement opendata grace à son id!")
    @GetMapping(value = "event/openData/{id}")
    public EvenementOpenData getEventOpenDataById(@PathVariable("id") long id){
        return   facade.getEventOpenDataById(id);

    }
}
