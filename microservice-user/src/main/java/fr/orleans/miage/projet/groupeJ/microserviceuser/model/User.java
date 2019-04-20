package fr.orleans.miage.projet.groupeJ.microserviceuser.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

/**
 * Created by wilfrid on 02/03/2019.
 */
@Entity
public class User {
   @Id
    private String pseudo;
    private String firstName;
    private String LastName;
    private String email;
    private String password;
    private String roles;
    private boolean isConnected;

    @JsonIgnore
    @ManyToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="tbl_friends",
            joinColumns=@JoinColumn(name="followerId"),
            inverseJoinColumns=@JoinColumn(name="friendId")
    )
    private Collection<User> friends;

   /* @JsonIgnore
    @OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Notification> notifications;*/
   @ElementCollection
   private Collection<Long> notifications;

    public User(String pseudo, String firstName, String lastName, String email, String password) {
        this.pseudo = pseudo;
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.password = password;
        this.isConnected = false;
        this.notifications = new ArrayList<>();
    }


    public User() {
    }

    public Collection<Long> getNotifications() {
        return notifications;
    }

    public void setNotifications(Collection<Long> notifications) {
        this.notifications = notifications;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    public Collection<User> getFriends() {
        return friends;
    }

    public void setFriends(Collection<User> friends) {
        this.friends = friends;
    }
}
