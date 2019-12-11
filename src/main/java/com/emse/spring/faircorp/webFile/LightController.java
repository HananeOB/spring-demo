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

@RestController
@RequestMapping("/api/lights")
@Transactional
public class LightController {

    @Autowired
    private LightDao lightDao;
    @Autowired
    private RoomDao roomDao;


    @GetMapping
    public List<LightDTO> findAll() {
        return lightDao.findAll()
                .stream()
                .map(LightDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public LightDTO findById(@PathVariable Long id) {
        return lightDao.findById(id).map(light -> new LightDTO(light)).orElse(null);
    }

    @PutMapping(path = "/{id}/switch")
    public LightDTO switchStatus(@PathVariable Long id) {
        Light light = lightDao.findById(id).orElseThrow(IllegalArgumentException::new);
        light.setStatus(light.getStatus() == Status.ON ? Status.OFF: Status.ON);
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
            lightDao.save(light);
        }

        return new LightDTO(light);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        lightDao.deleteById(id);
    }

}
