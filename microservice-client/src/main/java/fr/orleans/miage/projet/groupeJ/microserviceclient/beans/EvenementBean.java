package fr.orleans.miage.projet.groupeJ.microserviceclient.beans;

import java.util.Date;

/**
 * Created by wilfrid on 17/03/2019.
 */
public class EvenementBean {
    private long id;
    private String name;
    private String dateEvent;
    private String heure;
    private String lieu;
    private String pseudo;
    private SoireeBean soiree_int;

    public EvenementBean() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public SoireeBean getSoiree_int() {
        return soiree_int;
    }

    public void setSoiree_int(SoireeBean soiree_int) {
        this.soiree_int = soiree_int;
    }
}
