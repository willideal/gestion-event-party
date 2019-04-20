package fr.orleans.miage.projet.groupeJ.microserviceevent.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by wilfrid on 06/03/2019.
 */
@Entity
public class Evenement {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    /*@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)*/
    private String dateEvent;
    private String heure;
    private String lieu;
    //pseudo de celui qui a creer leveement privee
    private String pseudo;


    //l'id de la soiree à associée à levenement
    private long soireeId;


    public Evenement(String name, String dateEvent, String heure, String lieu, String pseudo) {
        this.name = name;
        this.heure = heure;
        this.lieu = lieu;
        this.pseudo = pseudo;
        this.dateEvent = dateEvent;
    }

    public Evenement() {
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    public long getSoireeId() {
        return soireeId;
    }

    public void setSoireeId(long soireeId) {
        this.soireeId = soireeId;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
}

