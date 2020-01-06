package com.emse.spring.faircorp.webFile;

import com.emse.spring.faircorp.model.Light;

import com.emse.spring.faircorp.model.Status;

public class LightDTO {
    private  Long id;
    private  Integer level;
    private Status status;
    private Long room ;
    private Integer floor;



    public LightDTO() {
    }



    public LightDTO(Light light) {
        this.id = light.getId();
        this.level = light.getLevel();
        this.status = light.getStatus();
        this.room = light.getRoom().getId();
        this.floor = light.getRoom().getFloor();
    }

    public Long getId() {
        return id;
    }

    public Integer getLevel() {
        return level;
    }

    public Status getStatus() {
        return status;
    }

    public Long getRoom() {
        return room;
    }

    public Integer getFloor() { return floor; }
}
