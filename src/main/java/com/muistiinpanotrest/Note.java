package com.muistiinpanotrest;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String heading, description;

    public Note() {
    }

    public Note(int id, String heading, String description) {
        super();
        this.id = id;
        this.heading = heading;
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public String getHeading() {
        return this.heading;
    }

    public String getDescription() {
        return this.description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}