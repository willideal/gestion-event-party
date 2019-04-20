package fr.orleans.miage.projet.groupeJ.microserviceuser.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wilfrid on 14/03/2019.
 */
@Entity
public class Notification {
    @Id
    @GeneratedValue
    private long id;
    private  String message;
    private String typeNotif;
    private String status ;
    private String pseudoSender;
    private String pseudoReceiver;

    //la soiree à laquelle est associé la notification
    private long idSoiree;

    public Notification() {
    }

    public Notification(String message, String typeNotif, String pseudoReceiver) {
        this.message = message;
        this.pseudoReceiver = pseudoReceiver;
        this.typeNotif = typeNotif;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdSoiree() {
        return idSoiree;
    }

    public void setIdSoiree(long idSoiree) {
        this.idSoiree = idSoiree;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudoSender() {
        return pseudoSender;
    }

    public void setPseudoSender(String pseudoSender) {
        this.pseudoSender = pseudoSender;
    }

    public String getPseudoReceiver() {
        return pseudoReceiver;
    }

    public void setPseudoReceiver(String pseudoReceiver) {
        this.pseudoReceiver = pseudoReceiver;
    }

    public String getTypeNotif() {
        return typeNotif;
    }

    public void setTypeNotif(String typeNotif) {
        this.typeNotif = typeNotif;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
/*
    public Collection<String> getPseudo() {
        return pseudo;
    }

    public void setPseudo(Collection<String> pseudo) {
        this.pseudo = pseudo;
    }
*/
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
