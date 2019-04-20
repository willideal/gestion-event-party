package fr.orleans.miage.projet.groupeJ.microserviceuser.dao.repository;

import fr.orleans.miage.projet.groupeJ.microserviceuser.model.Notification;
import fr.orleans.miage.projet.groupeJ.microserviceuser.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by wilfrid on 02/03/2019.
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {
   public User getUserByPseudo(String pseudo);
   public User getUserByPseudoAndPassword(String pseudo, String password);


}
