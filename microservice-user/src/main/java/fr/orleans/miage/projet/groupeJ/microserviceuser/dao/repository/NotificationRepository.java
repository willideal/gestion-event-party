package fr.orleans.miage.projet.groupeJ.microserviceuser.dao.repository;

import fr.orleans.miage.projet.groupeJ.microserviceuser.model.Notification;
import fr.orleans.miage.projet.groupeJ.microserviceuser.model.User;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by wilfrid on 02/03/2019.
 */
@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long> {
   Notification getNotificationById(long id);
   Collection<Notification> getNotificationsByIdSoiree(long idSoiree);
   Collection<Notification> getNotificationsByPseudoReceiver(String pseudo);


}
