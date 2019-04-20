package fr.orleans.miage.projet.groupeJ.microserviceevent.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by wilfrid on 29/03/2019.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventNotFoundException extends RuntimeException {


    public EventNotFoundException(String message) {
        super(message);
    }
}
