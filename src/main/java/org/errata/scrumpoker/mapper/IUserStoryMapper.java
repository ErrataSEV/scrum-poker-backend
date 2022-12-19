package org.errata.scrumpoker.mapper;

import org.errata.scrumpoker.dto.UserStoryDTO;
import org.errata.scrumpoker.entity.UserStory;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IUserStoryMapper {

    UserStoryDTO toDTO(UserStory data);

    UserStory toEntity(UserStoryDTO data);

}
