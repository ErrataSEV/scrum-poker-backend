package org.errata.scrumpoker.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EpicDTO {

    private long id;
    private String name;
    private Date createdAt;
    private Date updatedAt;

}
