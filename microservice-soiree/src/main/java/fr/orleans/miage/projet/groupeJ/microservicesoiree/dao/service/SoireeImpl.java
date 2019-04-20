package fr.orleans.miage.projet.groupeJ.microservicesoiree.dao.service;

import fr.orleans.miage.projet.groupeJ.microservicesoiree.dao.repository.SoireeRepository;
import fr.orleans.miage.projet.groupeJ.microservicesoiree.exceptions.SoireeNotFoundException;
import fr.orleans.miage.projet.groupeJ.microservicesoiree.model.Soiree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by wilfrid on 16/03/2019.
 */
@Service
public class SoireeImpl implements ISoiree {

    @Autowired
    SoireeRepository soireeRepository;

    @Override
    public long creerSoiree(Soiree soiree) {
        //ajout de celui cree la soiree dans les participant
        soireeRepository.save(soiree);
     //   soiree.getParticipant().add(soiree.getPseudo());

        return soiree.getId();
    }

    @Override
    public Soiree getByIdSoiree(long id) {
        return soireeRepository.getSoireeById(id);
    }

    @Override
    public Collection<Soiree> getSoireesByPseudo(String pseudo) {

        return soireeRepository.getSoireesByPseudo(pseudo);
    }

    @Override
    public void ajouterEventToSoiree(long idSoiree, long evenement) {
        Soiree soiree = soireeRepository.getSoireeById(idSoiree);
        if(soiree != null) {
            soiree.getEvenementsPrivee().add(evenement);
            soireeRepository.save(soiree);
        }
        else throw new SoireeNotFoundException("impossible d'ajouter votre event à la soiree");

    }

    @Override
    public void ajouterEventOpenDataToSoiree(long idSoiree,  long evenementOpenData) {

        Soiree soiree = soireeRepository.getSoireeById(idSoiree);
        if(soiree != null) {
            soiree.getEvenementsExterne().add(evenementOpenData);
            soireeRepository.save(soiree);
        }
        else throw new SoireeNotFoundException("impossible d'ajouter votre event Externe à la soiree");

    }

    @Override
    public void ajouterParticipantToSoiree(long idSoiree, String participant) {
        Soiree soiree = soireeRepository.getSoireeById(idSoiree);
        if(soiree != null) {
            soiree.getParticipant().add(participant);
            soireeRepository.save(soiree);
        }
        else throw new SoireeNotFoundException("impossible d'ajouter ce participant à la soiree");

    }

    @Override
    public void deleteSoiree(long idSoiree) {
        Soiree soiree = soireeRepository.getSoireeById(idSoiree);
        soireeRepository.delete(soiree);
    }

    @Override
    public void modifierSoiree(long idSoiree) {
        Soiree soiree = soireeRepository.getSoireeById(idSoiree);
        //todo update
        soireeRepository.save(soiree);
    }


}
