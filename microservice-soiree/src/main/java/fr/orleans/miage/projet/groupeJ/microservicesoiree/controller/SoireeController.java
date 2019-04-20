package fr.orleans.miage.projet.groupeJ.microservicesoiree.controller;

import fr.orleans.miage.projet.groupeJ.microservicesoiree.dao.service.ISoiree;
import fr.orleans.miage.projet.groupeJ.microservicesoiree.model.Soiree;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by wilfrid on 06/03/2019.
 */
@Api( description="API pour les opérations CRUD de la soiree")
@RestController(value = "/")
public class SoireeController {

    @Autowired
    ISoiree facadeSoiree;

    //creer une soiree
    @ApiOperation(value = "Permet d'ajouter une nouvelle soiree!")
    @PostMapping(value = "soiree")
    public long creerSoiree(@RequestBody Soiree soiree){
      long id =   facadeSoiree.creerSoiree(soiree);

        return id;

    }


    //ajouter un event private a une soiree
    @ApiOperation(value = "Permet d'ajouter une evenement privee à une soiree!")
    @PutMapping(value = "soiree/{idSoiree}/eventPrivate/{idEventPrivate}")
    public ResponseEntity ajouterEventPriveeToSoiree(@PathVariable("idSoiree") long idSoiree,
                                           @PathVariable("idEventPrivate") long idEventPrivate){
        facadeSoiree.ajouterEventToSoiree(idSoiree,idEventPrivate);

        return ResponseEntity.ok().build();

    }

    //ajouter un event openData a une soiree
    @ApiOperation(value = "Permet d'ajouter un evenement opendata à une soiree soiree!")
    @PutMapping(value = "soiree/{idSoiree}/eventopendata/{idEventOpenData}")
    public void ajouterEventOpenDataToSoiree(@PathVariable("idSoiree") long idSoiree,
                                             @PathVariable("idEventOpenData") long idEventOpenData){
        facadeSoiree.ajouterEventOpenDataToSoiree(idSoiree,idEventOpenData);

    }

    //recuperer  une soiree par id
    @ApiOperation(value = "Permet de recuperer une  soiree par son id!")
    @GetMapping(value = "soiree/{idSoiree}")
    public Soiree getSoireeById(@PathVariable("idSoiree") long idSoiree){

        return facadeSoiree.getByIdSoiree(idSoiree);

    }

    //ajoute un participant à la soiree
    @ApiOperation(value = "Permet d'ajouter un participant a une soiree!")
    @PostMapping(value = "soiree/{idSoiree}/participe/{participant}")
    public void addParticipantToSoiree(@PathVariable("idSoiree") long idSoiree,
                                         @PathVariable("participant") String participant){

         facadeSoiree.ajouterParticipantToSoiree(idSoiree, participant);

    }


    //recuperer  toutes les soirees dun user
    @ApiOperation(value = "Permet de recuperer les soirees creer par un utilisateur !")
    @GetMapping(value = "soirees/{pseudo}")
    public Collection<Soiree> getAllSoiree(@PathVariable("pseudo") String pseudo){

        return facadeSoiree.getSoireesByPseudo(pseudo);

    }


    //supprimer une soiree
    @ApiOperation(value = "Permet de supprimer  une soiree!")
    @DeleteMapping(value = "soiree")
    public ResponseEntity deleteSoiree(@RequestParam("idSoiree") int idSoiree){

        facadeSoiree.deleteSoiree(idSoiree);

        return ResponseEntity.ok().build();

    }


    //update une soiree
    @PutMapping(value = "soiree")
    @ApiOperation(value = "Permet de modifier  une soiree!")
    public ResponseEntity updateSoiree(@RequestParam("idSoiree") int idSoiree){

        return null;

    }

}
