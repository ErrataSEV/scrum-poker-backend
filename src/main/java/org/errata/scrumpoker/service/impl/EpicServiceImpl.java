package org.errata.scrumpoker.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.errata.scrumpoker.dto.EpicDTO;
import org.errata.scrumpoker.entity.Epic;
import org.errata.scrumpoker.mapper.IEpicMapper;
import org.errata.scrumpoker.repository.IEpicRepository;
import org.errata.scrumpoker.service.IEpicService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EpicServiceImpl implements IEpicService {

    private IEpicMapper mapper;
    private IEpicRepository repository;

    public EpicServiceImpl(IEpicMapper mapper, IEpicRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<EpicDTO> findAll() {
        List<Epic> epics = repository.findAll();
        return epics.stream().map(mapper::toDTO).toList();
    }

    @Override
    public EpicDTO findOneById(long id) {
        Optional<Epic> epic = repository.findById(id);
        return mapper.toDTO(epic.get());
    }

    @Override
    public EpicDTO save(EpicDTO data) {
        log.info("Saving new Epic " + data.getName());
        Epic epic = mapper.toEntity(data);
        return mapper.toDTO(repository.save(epic));
    }

    @Override
    public void update(long id, EpicDTO data) throws Exception {
        Optional<Epic> result = repository.findById(id);

        if (result.isEmpty()) {
            log.error("Epic don't exist");
            throw new Exception("Epic does not exist");
        }

        Epic epic = result.get();
        epic.setName(data.getName());
        log.info("Editing Epic " + data.getId());
        repository.save(epic);
    }

    @Override
    public void delete(long id) {
        log.warn("Deleting Epic " + id);
        repository.deleteById(id);
    }

}
