package com.emse.spring.faircorp.webFile;


import com.emse.spring.faircorp.model.LightDao;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.RoomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/Rooms")
@Transactional
public class RoomController {


    @Autowired
    private LightDao lightDao;
    @Autowired
    private RoomDao roomDao;





    @GetMapping(path = "/{id}")
    private List<LightDTO> roomLight(@PathVariable Long id){
        return roomDao.findRoomLight(id)
                .stream()
                .map(LightDTO::new)
                .collect(Collectors.toList());

    };
















}
