package org.launchcode.readinglog.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Log extends AbstractEntity {

    //consider relationships to Volumes
    //analagous to 'Job'
    //implement when making volumes their own objects
    @ManyToOne
    private Volume volume;

    //remove volumeId/volumeName as String when fully implement volumes as objects
    private String volumeGoogleId;
    private String volumeName;
    //private LocalDate date;
    private String date;
    private Integer minutesLogged;
    private int pagesLogged;

    public Log() {}

    //save space for other Log constructor
    //UUID carried down from abstract entity
    //date (mandatory)
    //time/minutes
    //pages

//all fields
    public Log(Volume volume, String volumeGoogleId, String volumeName, String date, Integer minutesLogged, int pagesLogged) {
        this.volumeGoogleId = volumeGoogleId;
        this.volumeName = volumeName;
        this.volume = volume;
        this.date = date;
        this.minutesLogged = minutesLogged;
        this.pagesLogged = pagesLogged;
    }
//pagecount not necessary
    public Log(Volume volume, String volumeGoogleId, String volumeName, String date, Integer minutesLogged) {
        this.volumeGoogleId = volumeGoogleId;
        this.volumeName = volumeName;
        this.volume = volume;
        this.date = date;
        this.minutesLogged = minutesLogged;
    }
//timelog not necessary
    public Log(Volume volume, String volumeGoogleId, String volumeName, String date, int pagesLogged) {
        this.volumeGoogleId = volumeGoogleId;
        this.volumeName = volumeName;
        this.volume = volume;
        this.date = date;
        this.pagesLogged = pagesLogged;
    }


//pagecount/time not necessary
    public Log(Volume volume, String volumeGoogleId, String volumeName, String date) {
        this.volumeGoogleId = volumeGoogleId;
        this.volumeName = volumeName;
        this.volume = volume;
        this.date = date;
    }

    public Volume getVolume() {
        return volume;
    }

    public String getVolumeGoogleId() {
        return volumeGoogleId;
    }

    public void setVolumeGoogleId(String volumeId) {
        this.volumeGoogleId = volumeId;
    }

    public String getVolumeName() {
        return volumeName;
    }

    public void setVolumeName(String volumeName) {
        this.volumeName = volumeName;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getMinutesLogged() {
        return minutesLogged;
    }

    public void setMinutesLogged(Integer minutesLogged) {
        this.minutesLogged = minutesLogged;
    }

    public int getPagesLogged() {
        return pagesLogged;
    }

    public void setPagesLogged(int pagesLogged) {
        this.pagesLogged = pagesLogged;
    }



}
