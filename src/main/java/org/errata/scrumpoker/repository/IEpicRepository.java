package org.errata.scrumpoker.repository;

import org.errata.scrumpoker.entity.Epic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEpicRepository extends JpaRepository<Epic, Long> {
}
