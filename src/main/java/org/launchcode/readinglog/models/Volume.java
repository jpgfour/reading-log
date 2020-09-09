package org.launchcode.readinglog.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Volume extends AbstractEntity {

    //consider relationships to Logs
    //analagous to 'Employer'
    @OneToMany
    @JoinColumn
    private List<Log> logs = new ArrayList<>();

    private String googleBooksID;
    private String title;
    private String authors;
    private Integer pagecount;

    public Volume() {}

    //save space for other Volume definition
    //unique identifier
    //title
    //authors?
    //pagecount - use later to see if people went 'over' on pagecount


    public Volume(String googleBooksID, String title, String authors, Integer pagecount) {
        super();
        this.googleBooksID = googleBooksID;
        this.title = title;
        this.authors = authors;
        this.pagecount = pagecount;
    }


    public String getGoogleBooksID() {
        return googleBooksID;
    }

    public void setGoogleBooksID(String googleBooksID) {
        this.googleBooksID = googleBooksID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public Integer getPagecount() {
        return pagecount;
    }

    public void setPagecount(Integer pagecount) {
        this.pagecount = pagecount;
    }
}
