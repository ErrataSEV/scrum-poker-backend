package org.errata.scrumpoker.repository;

import org.errata.scrumpoker.entity.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserStoryRepository extends JpaRepository<UserStory, Long> {
}
