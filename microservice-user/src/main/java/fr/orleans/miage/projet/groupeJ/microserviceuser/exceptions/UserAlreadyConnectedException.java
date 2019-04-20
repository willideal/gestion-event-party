package fr.orleans.miage.projet.groupeJ.microserviceuser.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyConnectedException extends RuntimeException {


    public UserAlreadyConnectedException(String message) {
        super(message);
    }
}
