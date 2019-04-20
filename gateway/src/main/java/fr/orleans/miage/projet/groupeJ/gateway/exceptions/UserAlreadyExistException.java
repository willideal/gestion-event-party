package fr.orleans.miage.projet.groupeJ.gateway.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyExistException extends RuntimeException {


    public UserAlreadyExistException(String message) {
        super(message);
    }
}
