package fr.orleans.miage.projet.groupeJ.microserviceclient.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyConnectedException extends RuntimeException {


    public UserAlreadyConnectedException(String message) {
        super(message);
    }
}
