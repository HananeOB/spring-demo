package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Room {
    @Id
    @GeneratedValue
    private long Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer Floor;

    @OneToMany(mappedBy="room")
    private Set<Light> light;

    public Room(){

    }
    public Room( String s, Integer f){
        this.Floor = f;
        this.name = s;

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

    public Integer getFloor() {
        return Floor;
    }

    public void setFloor(Integer floor) {
        Floor = floor;
    }

    public Set<Light> getLight() {
        return light;
    }

    public void setLight(Set<Light> light) {
        this.light = light;
    }
}
