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
public interface INotif {

   Notification getNotifById(long id);
   Collection<Notification> getAllNotifByPseudo(String pseudo);

   long creerNotifSoiree(String pseudo, String amis, long id,  String nomSoiree);

   long creerNotifFollow(String pseudo, String amis);
   long creerNotifUnFollow(String pseudo, String amis);
}
