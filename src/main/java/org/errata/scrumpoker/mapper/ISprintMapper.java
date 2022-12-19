package org.errata.scrumpoker.mapper;

import org.errata.scrumpoker.dto.SprintDTO;
import org.errata.scrumpoker.entity.Sprint;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ISprintMapper {

    SprintDTO toDTO(Sprint data);

    Sprint toEntity(SprintDTO data);
}
