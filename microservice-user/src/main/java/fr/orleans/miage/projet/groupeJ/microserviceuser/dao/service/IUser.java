package fr.orleans.miage.projet.groupeJ.microserviceuser.dao.service;

import fr.orleans.miage.projet.groupeJ.microserviceuser.domain.Follow;
import fr.orleans.miage.projet.groupeJ.microserviceuser.domain.Login;
import fr.orleans.miage.projet.groupeJ.microserviceuser.exceptions.UserAlreadyConnectedException;
import fr.orleans.miage.projet.groupeJ.microserviceuser.exceptions.UserNotFoundException;
import fr.orleans.miage.projet.groupeJ.microserviceuser.model.Notification;
import fr.orleans.miage.projet.groupeJ.microserviceuser.model.User;

import java.util.Collection;

/**
 * Created by wilfrid on 14/03/2019.
 */
public interface IUser {

    //permet de connecter un user
    public  void connexion(Login login) throws UserNotFoundException, UserAlreadyConnectedException;

    //permet d'inscrire  un user
    public void inscription(User u) throws UserNotFoundException;

    //permet de deconnecter un user
    public void deconnexion(String pseudo);


    /*le pseudo veut suivre un amis, je rajoute  amis  a la liste d'amis du pseudo
    String pseudo, String amis
    */
    public void follow(Follow follow);


    /*le pseudo  veut unfollow le amis, je remove le amis   de la liste du pseudo
     * du follower */
    public  void unfollow(Follow follow);


    //retourne les pseudo des amis du user pour notification
    public Collection<String> userFriends(String pseudo);

    //retourne un user gace à son pseudo
    public User getUserByPseudo(String pseudo);

    //retourne tous les users
    public Iterable<User> getAllUser();

     Collection<Notification> getNotifsById(String pseudo);
     //Notification getNotifById(long id);
     void updateUserNotif(User u);
}
