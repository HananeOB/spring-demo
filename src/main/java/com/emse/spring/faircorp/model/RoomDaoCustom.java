package com.emse.spring.faircorp.model;

import java.util.List;

public interface RoomDaoCustom {
   List<String> findRoomByName(String name);
   List<Light> findRoomLight(long id);
   List<Long> findAllRoomId();
}
