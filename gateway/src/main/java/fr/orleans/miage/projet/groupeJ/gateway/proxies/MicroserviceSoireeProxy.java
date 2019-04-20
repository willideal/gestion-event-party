package fr.orleans.miage.projet.groupeJ.gateway.proxies;

import fr.orleans.miage.projet.groupeJ.gateway.beans.SoireeBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by wilfrid on 12/03/2019.
 */
@FeignClient(name = "gateway")
//@FeignClient(name = "zuul-server")
//@FeignClient(name = "microservice-soiree", url = "localhost:8084")
public interface MicroserviceSoireeProxy {

    //soireecontroller

    @PostMapping(value = "/microservice-soiree/soiree")
     long creerSoiree(@RequestBody SoireeBean soiree);


    @PostMapping(value = "/microservice-soiree/soiree/participe/{idSoiree}/{idParticipant}")
     void participerSoiree(@PathVariable("idSoiree") long idSoiree,
                           @PathVariable("participant") String participant);


    @PutMapping(value = "/microservice-soiree/soiree/{idSoiree}/eventPrivate/{idEventPrivate}")
    public ResponseEntity ajouterEventPriveeToSoiree(@PathVariable("idSoiree") long idSoiree,
                                                     @PathVariable("idEventPrivate") long idEventPrivate);


    @PutMapping(value = "/microservice-soiree/soiree/{idSoiree}/eventopendata/{idEventOpenData}")
     void ajouterEventOpenDataToSoiree(@PathVariable("idSoiree") long idSoiree,
                                       @PathVariable("idEventOpenData") long idEventOpenData);

    @GetMapping(value = "/microservice-soiree/soiree/{idSoiree}")
     SoireeBean getSoireeById(@PathVariable("idSoiree") long idSoiree);



    @GetMapping(value = "/microservice-soiree/soirees/{pseudo}")
     Collection<SoireeBean> getAllSoiree(@PathVariable("pseudo") String pseudo);

    @PostMapping(value = "/microservice-soiree/soiree/{idSoiree}/participe/{participant}")
     void addParticipantToSoiree(@PathVariable("idSoiree") long idSoiree,
                                 @PathVariable("participant") String participant);
}
