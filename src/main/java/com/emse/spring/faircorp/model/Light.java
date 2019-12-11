package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity
public class Light {
    @Id // 3.
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer level;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Room room ;

    public Light() {
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Light(Integer level, Status status, Room room) {
        this.level = level;
        this.status = status;
        this.room = room;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
