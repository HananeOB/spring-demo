package com.emse.spring.faircorp.model;


import javax.persistence.*;

import java.util.Set;

@Entity
public class Building {
    @Id
    @GeneratedValue
    private long Id;

    @Column(nullable = false)
    private String name;

    public Building(){

    }

    @OneToMany(mappedBy="building")
    private Set<Room> Room;

    public Building(long id, String name){
        this.Id = id;
        this.name = name;

    }


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
