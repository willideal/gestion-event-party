package fr.orleans.miage.projet.groupeJ.microserviceevent.dao.service;

import fr.orleans.miage.projet.groupeJ.microserviceevent.dao.repository.EvenementOpenDataRepository;
import fr.orleans.miage.projet.groupeJ.microserviceevent.dao.repository.EvenementRepository;
import fr.orleans.miage.projet.groupeJ.microserviceevent.exceptions.EventNotFoundException;
import fr.orleans.miage.projet.groupeJ.microserviceevent.model.Evenement;
import fr.orleans.miage.projet.groupeJ.microserviceevent.model.EvenementOpenData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by wilfrid on 16/03/2019.
 */
@Service
public class EvenementImpl implements IEvenement {

    @Autowired
    EvenementRepository evenementRepository;

    @Autowired
    EvenementOpenDataRepository evenementOpenDataRepository;

    @Override
    public long creerEventPrivee(Evenement event) {
        evenementRepository.save(event);
        return event.getId();
    }

    @Override
    public long creerEventOpenData(EvenementOpenData evenementOpenData) {
        evenementOpenDataRepository.save(evenementOpenData);
        return evenementOpenData.getId();
    }

    @Override
    public Iterable<EvenementOpenData> getAllEventOpenData() {
        return evenementOpenDataRepository.findAll();
    }

    @Override
    public Collection<Evenement> getEventPrviateByPseudo(String pseudo) {

        return  evenementRepository.getEvenementsByPseudo(pseudo);
    }

    @Override
    public Evenement getEventPrviateById(long id) throws EventNotFoundException {
        Evenement evenement =  evenementRepository.getEvenementById(id);
        if(evenement==null)
            throw new EventNotFoundException("l'evenement avec "+ id+" n'existe pas");

        return evenement;
    }

    @Override
    public EvenementOpenData getEventOpenDataById(long id) throws EventNotFoundException {
        EvenementOpenData evenement =  evenementOpenDataRepository.getEvenementOpenDataById(id);
        if(evenement==null)
            throw new EventNotFoundException("l'evenement avec "+ id+" n'existe pas");

        return evenement;
    }
}
