package org.errata.scrumpoker.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.errata.scrumpoker.dto.UserStoryDTO;
import org.errata.scrumpoker.entity.UserStory;
import org.errata.scrumpoker.mapper.IUserStoryMapper;
import org.errata.scrumpoker.repository.IUserStoryRepository;
import org.errata.scrumpoker.service.IUserStoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserStoryServiceImpl implements IUserStoryService {

    private IUserStoryMapper mapper;
    private IUserStoryRepository repository;

    public UserStoryServiceImpl(IUserStoryMapper mapper, IUserStoryRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<UserStoryDTO> findAll() {
        List<UserStory> userStories = repository.findAll();
        return userStories.stream().map(mapper::toDTO).toList();
    }

    @Override
    public UserStoryDTO findOneById(long id) {
        Optional<UserStory> epic = repository.findById(id);
        return mapper.toDTO(epic.get());
    }

    @Override
    public UserStoryDTO save(UserStoryDTO data) {
        log.info("Saving new US " + data.getName());
        UserStory userStory = mapper.toEntity(data);
        return mapper.toDTO(repository.save(userStory));
    }

    @Override
    public void update(long id, UserStoryDTO data) throws Exception {
        Optional<UserStory> result = repository.findById(id);

        if (result.isEmpty()) {
            log.error("US don't exist");
            throw new Exception("US does not exist");
        }

        UserStory userStory = result.get();
        userStory.setName(data.getName());
        log.info("Editing US " + data.getId());
        repository.save(userStory);
    }

    @Override
    public void delete(long id) {
        log.warn("Deleting Epic " + id);
        repository.deleteById(id);
    }
}
