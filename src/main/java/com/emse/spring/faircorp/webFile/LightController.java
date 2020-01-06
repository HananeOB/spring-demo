package com.emse.spring.faircorp.webFile;

import com.emse.spring.faircorp.model.Light;
import com.emse.spring.faircorp.model.LightDao;
import com.emse.spring.faircorp.model.RoomDao;
import com.emse.spring.faircorp.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/")
@Transactional
public class LightController {

    @Autowired
    private LightDao lightDao;
    @Autowired
    private RoomDao roomDao;


    @GetMapping(path = "/lights")
    public List<LightDTO> findAll() {
        return lightDao.findAll()
                .stream()
                .map(LightDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/lights/{id}")
    public LightDTO findById(@PathVariable Long id) {
        return lightDao.findById(id).map(light -> new LightDTO(light)).orElse(null);
    }






    @PutMapping(path = "lights/{id}/switch")
    public List<LightDTO> switchStatusWeb(@PathVariable Long id) {
        Light light = lightDao.findById(id).orElseThrow(IllegalArgumentException::new);
        light.setStatus(light.getStatus() == Status.ON ? Status.OFF: Status.ON);
        return lightDao.findAll()
                .stream()
                .map(LightDTO::new)
                .collect(Collectors.toList());
    }
    @PutMapping(path = "lights/{id}/{level}")
    public List<LightDTO> switchLevelWeb(@PathVariable Long id,@PathVariable Integer level) {
        Light light = lightDao.findById(id).orElseThrow(IllegalArgumentException::new);
        light.setLevel(level);
        return lightDao.findAll()
                .stream()
                .map(LightDTO::new)
                .collect(Collectors.toList());
    }

    @PutMapping(path = "Lights/{id}/switch")
    public LightDTO switchStatusAndroid(@PathVariable Long id) {
        Light light = lightDao.findById(id).orElseThrow(IllegalArgumentException::new);
        light.setStatus(light.getStatus() == Status.ON ? Status.OFF: Status.ON);
        return new LightDTO(light);
    }
    @PutMapping(path = "Lights/{id}/{level}")
    public LightDTO switchLevelAndroid(@PathVariable Long id,@PathVariable Integer level) {
        Light light = lightDao.findById(id).orElseThrow(IllegalArgumentException::new);
        light.setLevel(level);
        return new LightDTO(light);
    }







    @PostMapping
    public LightDTO create(@RequestBody LightDTO dto) {
        Light light = null;
        if (dto.getId() != null) {
            light = lightDao.findById(dto.getId()).orElse(null);
        }

        if (light == null) {
            light = lightDao.save(new Light(dto.getLevel(), dto.getStatus(), roomDao.getOne(dto.getRoom())));
        } else {
            light.setLevel(dto.getLevel());
            light.setStatus(dto.getStatus());
            light.setRoom(dto.getRoom());

            lightDao.save(light);
        }

        return new LightDTO(light);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        lightDao.deleteById(id);
    }

}
