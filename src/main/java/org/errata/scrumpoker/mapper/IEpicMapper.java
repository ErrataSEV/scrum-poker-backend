package org.errata.scrumpoker.mapper;

import org.errata.scrumpoker.dto.EpicDTO;
import org.errata.scrumpoker.entity.Epic;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IEpicMapper {

    EpicDTO toDTO(Epic data);

    Epic toEntity(EpicDTO data);

}
