package fr.orleans.miage.projet.groupeJ.microserviceclient.domain;

/**
 * Created by wilfrid on 16/03/2019.
 */
public class Follow {
    private String pseudo;
    private String amis;


    public Follow() {
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getAmis() {
        return amis;
    }

    public void setAmis(String amis) {
        this.amis = amis;
    }
}
