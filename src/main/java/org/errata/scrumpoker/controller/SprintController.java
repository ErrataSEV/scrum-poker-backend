package org.errata.scrumpoker.controller;

import org.errata.scrumpoker.dto.SprintDTO;
import org.errata.scrumpoker.service.ISprintService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sprints")
public class SprintController {

    private ISprintService service;

    public SprintController(ISprintService service) {
        this.service = service;
    }

    @GetMapping
    public List<SprintDTO> all() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SprintDTO save(@RequestBody SprintDTO data) {
        return service.save(data);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody SprintDTO data) throws Exception{
        service.update(id, data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) {
        service.delete(id);
    }
}
