package org.errata.scrumpoker.service;

import org.errata.scrumpoker.dto.UserStoryDTO;

import java.util.List;

public interface IUserStoryService {

    List<UserStoryDTO> findAll();

    UserStoryDTO findOneById(long id);

    UserStoryDTO save(UserStoryDTO data);

    void update(long id, UserStoryDTO data) throws Exception;

    void delete(long id);

}
