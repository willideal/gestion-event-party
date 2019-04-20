package fr.orleans.miage.projet.groupeJ.microserviceevent.dao.service;

import fr.orleans.miage.projet.groupeJ.microserviceevent.exceptions.EventNotFoundException;
import fr.orleans.miage.projet.groupeJ.microserviceevent.model.Evenement;
import fr.orleans.miage.projet.groupeJ.microserviceevent.model.EvenementOpenData;

import java.util.Collection;

/**
 * Created by wilfrid on 16/03/2019.
 */
public interface IEvenement {

    /**
     * Permet de creer un nouvel evenement  pour le pseudo
     * @param event : objet evenement
     */
    long creerEventPrivee(Evenement event);

    /**
     * Permet de creer un nouvel evenement  via openData
     * @param evenementOpenData : objet evenement
     */
    long creerEventOpenData(EvenementOpenData evenementOpenData);


    /**
     * Permet de recuperer tous  evenement  de openData
     */
    Iterable<EvenementOpenData> getAllEventOpenData();

    /**
     * Permet de recuperer tous  evenement privee  d'un utilisateur
     */
    Collection<Evenement> getEventPrviateByPseudo(String pseudo);

    /**
     * Permet de recuperer tous  evenement privee avec id
     */
    Evenement getEventPrviateById(long id) throws EventNotFoundException;

    /**
     * Permet de recuperer tous  evenement privee avec id
     */
    EvenementOpenData getEventOpenDataById(long id) throws EventNotFoundException;

}
