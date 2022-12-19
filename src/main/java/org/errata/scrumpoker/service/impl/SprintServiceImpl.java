package org.errata.scrumpoker.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.errata.scrumpoker.dto.SprintDTO;
import org.errata.scrumpoker.entity.Sprint;
import org.errata.scrumpoker.mapper.ISprintMapper;
import org.errata.scrumpoker.repository.ISprintRepository;
import org.errata.scrumpoker.service.ISprintService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SprintServiceImpl implements ISprintService {

    private ISprintMapper mapper;
    private ISprintRepository repository;

    public SprintServiceImpl(ISprintMapper mapper, ISprintRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<SprintDTO> findAll() {
        List<Sprint> sprints = repository.findAll();
        return sprints.stream().map(mapper::toDTO).toList();
    }

    @Override
    public SprintDTO findOneById(long id) {
        Optional<Sprint> sprint = repository.findById(id);
        return mapper.toDTO(sprint.get());
    }

    @Override
    public SprintDTO save(SprintDTO data) {
        log.info("Saving new Sprint " + data.getId());
        Sprint sprint = mapper.toEntity(data);
        return mapper.toDTO(repository.save(sprint));
    }

    @Override
    public void update(long id, SprintDTO data) throws Exception {
        Optional<Sprint> result = repository.findById(id);

        if (result.isEmpty()) {
            log.error("Sprint don't exist");
            throw new Exception("Sprint does not exist");
        }

        Sprint sprint = result.get();
        sprint.setBeginDate(data.getBeginDate());
        sprint.setEndDate(data.getEndDate());

        log.info("Editing Sprint " + data.getId());
        repository.save(sprint);
    }

    @Override
    public void delete(long id) {
        log.warn("Deleting Sprint " + id);
        repository.deleteById(id);
    }

}
