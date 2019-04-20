package fr.orleans.miage.projet.groupeJ.microservicesoiree.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by wilfrid on 17/03/2019.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SoireeNotFoundException extends RuntimeException {


    public SoireeNotFoundException(String message) {
        super(message);
    }
}
