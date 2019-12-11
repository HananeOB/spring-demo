package com.emse.spring.faircorp.model;

import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)

@DataJpaTest
class RoomDaoImplTest {
    @Autowired
    private RoomDao RoomDao;

    @Test
    public void shouldFindRooms() {
        Assertions.assertThat(RoomDao.findRoomByName("Room1"))
                .hasSize(1)
                .extracting("id", "name")
                .containsExactly(Tuple.tuple(-10L, "Room1"));

    }
    @Test
    public void shouldFindRoomsLight() {

        Assertions.assertThat(RoomDao.findRoomLight(-10))
                .hasSize(2)
                .extracting("room.id")
                .containsExactly(-10L,-10L);

    }

}