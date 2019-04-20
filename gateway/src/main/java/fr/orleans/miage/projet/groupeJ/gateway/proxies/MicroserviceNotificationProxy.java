package fr.orleans.miage.projet.groupeJ.gateway.proxies;

import fr.orleans.miage.projet.groupeJ.gateway.beans.NotificationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by wilfrid on 20/03/2019.
 */
//@FeignClient(name = "microservice-notif", url = "localhost:8088")
@FeignClient(name = "gateway")
public interface MicroserviceNotificationProxy {
    @PostMapping(value = "/microservice-notif/notif/follow")
    long addNotifollow();

    @PostMapping(value = "/microservice-notif/notif/unfollow")
    long addNotifUnfollow();

    @GetMapping(value = "/microservice-notif/notif/{idNotif}")
    NotificationBean getNotif(@PathVariable("idNotif") long idNotif);

    @PostMapping(value = "/microservice-notif/notif/soiree")
     long addNotifSoiree(@ModelAttribute NotificationBean notificationBean);

}
