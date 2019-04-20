package fr.orleans.miage.projet.groupeJ.microserviceuser.domain;

/**
 * Created by wilfrid on 16/03/2019.
 */
public class Login {
    private String pseudo;
    private String password;


    public Login() {
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
