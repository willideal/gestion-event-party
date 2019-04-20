package fr.orleans.miage.projet.groupeJ.microserviceclient.beans;

/**
 * Created by wilfrid on 17/03/2019.
 */
public class NotificationBean {
    private int id;
    private  String message;
    private String typeNotif;
    private String status ;
    private String pseudoSender;
    private String pseudoReceiver;
    private long idSoiree;


    public NotificationBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getIdSoiree() {
        return idSoiree;
    }

    public void setIdSoiree(long idSoiree) {
        this.idSoiree = idSoiree;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTypeNotif() {
        return typeNotif;
    }

    public void setTypeNotif(String typeNotif) {
        this.typeNotif = typeNotif;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
