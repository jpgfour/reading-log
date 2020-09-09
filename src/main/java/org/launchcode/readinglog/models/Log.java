package org.launchcode.readinglog.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Log extends AbstractEntity {

    //consider relationships to Volumes
    //analagous to 'Job'
    @ManyToOne
    private Volume volume;


    private Date date;
    private Integer logTimeInMinutes;
    private int logPageCount;

    public Log() {}

    //save space for other Log constructor
    //UUID carried down from abstract entity
    //date (mandatory)
    //time/minutes
    //pages

//all fields
    public Log(Volume volume, Date date, Integer logTimeInMinutes, int logPageCount) {
        this.volume = volume;
        this.date = date;
        this.logTimeInMinutes = logTimeInMinutes;
        this.logPageCount = logPageCount;
    }
//pagecount not necessary
    public Log(Volume volume, Date date, Integer logTimeInMinutes) {
        this.volume = volume;
        this.date = date;
        this.logTimeInMinutes = logTimeInMinutes;
    }
//timelog not necessary
    public Log(Volume volume, Date date, int logPageCount) {
        this.volume = volume;
        this.date = date;
        this.logPageCount = logPageCount;
    }


//pagecount/time not necessary
    public Log(Volume volume, Date date) {
        this.volume = volume;
        this.date = date;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getLogTimeInMinutes() {
        return logTimeInMinutes;
    }

    public void setLogTimeInMinutes(Integer logTimeInMinutes) {
        this.logTimeInMinutes = logTimeInMinutes;
    }

    public int getLogPageCount() {
        return logPageCount;
    }

    public void setLogPageCount(int logPageCount) {
        this.logPageCount = logPageCount;
    }



}
