package com.emse.spring.faircorp.webFile;

import com.emse.spring.faircorp.model.Light;
import com.emse.spring.faircorp.model.Room;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class RoomDTO {

    private long id ;
    public RoomDTO(){ }

    public RoomDTO(Room room){
        this.id = room.getId();  }



    public long getId() {
        return id;
    }



}
