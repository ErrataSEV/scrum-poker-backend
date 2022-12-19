package org.errata.scrumpoker.service;

import org.errata.scrumpoker.dto.EpicDTO;

import java.util.List;
import java.util.Optional;

public interface IEpicService {

    List<EpicDTO> findAll();

    EpicDTO findOneById(long id);

    EpicDTO save(EpicDTO data);

    void update(long id, EpicDTO data) throws Exception;

    void delete(long id);

}
