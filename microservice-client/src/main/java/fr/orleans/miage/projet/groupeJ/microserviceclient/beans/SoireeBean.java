package fr.orleans.miage.projet.groupeJ.microserviceclient.beans;

import java.util.Collection;

/**
 * Created by wilfrid on 17/03/2019.
 */
public class SoireeBean {

    private  long id;
    private String nom;
    private String pseudo;

    private Collection<String> participant;
    private Collection<Long> evenementsExterne;
    private Collection<Long> evenementsPrivee;

    public SoireeBean() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Collection<String> getParticipant() {
        return participant;
    }

    public void setParticipant(Collection<String> participant) {
        this.participant = participant;
    }

    public Collection<Long> getEvenementsExterne() {
        return evenementsExterne;
    }

    public void setEvenementsExterne(Collection<Long> evenementsExterne) {
        this.evenementsExterne = evenementsExterne;
    }

    public Collection<Long> getEvenementsPrivee() {
        return evenementsPrivee;
    }

    public void setEvenementsPrivee(Collection<Long> evenementsPrivee) {
        this.evenementsPrivee = evenementsPrivee;
    }
}
