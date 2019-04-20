package fr.orleans.miage.projet.groupeJ.microserviceclient.beans;

import java.util.Collection;
import java.util.Date;

/**
 * Created by wilfrid on 17/03/2019.
 */
public class EvenementOpenDataBean {

    private long id;
    private String titre;
    private String placename;
    private String pricing_info;
    private Date date_start;
    private String link;
    private String adress;
    private Collection<Long> soireeIds;

    public EvenementOpenDataBean() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }

    public String getPricing_info() {
        return pricing_info;
    }

    public void setPricing_info(String pricing_info) {
        this.pricing_info = pricing_info;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Collection<Long> getSoireeIds() {
        return soireeIds;
    }

    public void setSoireeIds(Collection<Long> soireeIds) {
        this.soireeIds = soireeIds;
    }
}

