package org.errata.scrumpoker.controller;

import org.errata.scrumpoker.dto.EpicDTO;
import org.errata.scrumpoker.service.IEpicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/epics")
public class EpicController {

    private IEpicService service;

    public EpicController(IEpicService service) {
        this.service = service;
    }

    @GetMapping
    public List<EpicDTO> all() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EpicDTO save(@RequestBody EpicDTO data) {
        return service.save(data);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody EpicDTO data) throws Exception{
        service.update(id, data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) {
        service.delete(id);
    }

}
