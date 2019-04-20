package fr.orleans.miage.projet.groupeJ.microserviceevent.dao.repository;

import fr.orleans.miage.projet.groupeJ.microserviceevent.model.EvenementOpenData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wilfrid on 06/03/2019.
 */
@Repository
public interface EvenementOpenDataRepository extends CrudRepository<EvenementOpenData, Long> {
    EvenementOpenData getEvenementOpenDataById(long id);
}
