package fr.orleans.miage.projet.groupeJ.gateway.proxies;

import fr.orleans.miage.projet.groupeJ.gateway.beans.EvenementBean;
import fr.orleans.miage.projet.groupeJ.gateway.beans.EvenementOpenDataBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

/**
 * Created by wilfrid on 12/03/2019.
 */
@FeignClient(name = "gateway")
//@FeignClient(name = "zuul-server")
//@FeignClient(name = "microservice-soiree", url = "localhost:8084")
public interface MicroserviceEventProxy {


    //eventcontroller
    @PostMapping(value = "/microservice-event/event")
    Long creerEvenementPrivee(@RequestBody EvenementBean evenement);

    @PostMapping(value = "/microservice-event/event/openData", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    long openDataEventSave(@RequestBody EvenementOpenDataBean evenementOpenData);

    @GetMapping(value = "/microservice-event/event")
    Iterable<EvenementOpenDataBean> getAllEventOpenData();

    @GetMapping(value = "/microservice-event/event/{pseudo}")
    Collection<EvenementBean> getEventByPseudo(@PathVariable("pseudo") String pseudo);
    @GetMapping(value = "/microservice-event/event/private/{id}")
     EvenementBean getEventById(@PathVariable("id") long id);
    @GetMapping(value = "/microservice-event/event/openData/{id}")
     EvenementOpenDataBean getEventOpenDataById(@PathVariable("id") long id);
}
