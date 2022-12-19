package org.errata.scrumpoker.service;

import org.errata.scrumpoker.dto.SprintDTO;

import java.util.List;

public interface ISprintService {

    List<SprintDTO> findAll();

    SprintDTO findOneById(long id);

    SprintDTO save(SprintDTO data);

    void update(long id, SprintDTO data) throws Exception;

    void delete(long id);

}
