package org.errata.scrumpoker.repository;

import org.errata.scrumpoker.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISprintRepository extends JpaRepository<Sprint, Long> {
}
