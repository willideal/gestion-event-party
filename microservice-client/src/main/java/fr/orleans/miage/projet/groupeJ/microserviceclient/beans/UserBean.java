package fr.orleans.miage.projet.groupeJ.microserviceclient.beans;

import java.util.Collection;

/**
 * Created by wilfrid on 12/03/2019.
 */
public class UserBean {
    private String pseudo;
    private String firstName;
    private String LastName;
    private String email;
    private String password;
    private String roles;
    private boolean isConnected;
    private Collection<UserBean> friends;
    private Collection<Long> notifications;


    public UserBean() {
    }



    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    public Collection<UserBean> getFriends() {
        return friends;
    }

    public void setFriends(Collection<UserBean> friends) {
        this.friends = friends;
    }

    public Collection<Long> getNotifications() {
        return notifications;
    }

    public void setNotifications(Collection<Long> notifications) {
        this.notifications = notifications;
    }
}

