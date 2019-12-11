package com.emse.spring.faircorp.webFile;

import com.emse.spring.faircorp.model.Light;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Status;

public class LightDTO {
    private  Long id;
    private  Integer level;
    private Status status;
    private Long room ;

    public Long getRoom() {
        return room;
    }

    public void setRoom(Long room) {
        this.room = room;
    }

    public LightDTO() {
    }

    public LightDTO(Light light) {
        this.id = light.getId();
        this.level = light.getLevel();
        this.status = light.getStatus();
        this.room = light.getRoom().getId();
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

}
