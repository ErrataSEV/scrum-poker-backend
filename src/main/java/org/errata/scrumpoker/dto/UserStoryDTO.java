package org.errata.scrumpoker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.errata.scrumpoker.entity.Sprint;
import org.errata.scrumpoker.entity.Epic;

import java.util.Date;

@Data
public class UserStoryDTO {

    private long id;
    private String name;
    private int storyPoints;
    private String type;
    private Date createdAt;
    private Date updatedAt;
    private Epic epic;
    private Sprint sprint;

    @JsonProperty("epic_id")
    private void unpackNested(long epic_id) {
        this.epic = new Epic();
        epic.setId(epic_id);
    }

    @JsonProperty("sprint_id")
    private void unpackNestedSprint(long sprint_id) {
        this.sprint = new Sprint();
        sprint.setId(sprint_id);
    }

}
