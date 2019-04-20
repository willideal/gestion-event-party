package fr.orleans.miage.projet.groupeJ.microserviceuser.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class FriendAlreadyException extends RuntimeException {


    public FriendAlreadyException(String message) {
        super(message);
    }
}
