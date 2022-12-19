package org.errata.scrumpoker.controller;


import org.errata.scrumpoker.dto.UserStoryDTO;
import org.errata.scrumpoker.service.IUserStoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-stories")
public class UserStoryController {

    private IUserStoryService service;

    public UserStoryController(IUserStoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserStoryDTO> all() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserStoryDTO save(@RequestBody UserStoryDTO data) {
        return service.save(data);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody UserStoryDTO data) throws Exception{
        service.update(id, data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) {
        service.delete(id);
    }
}
