package org.errata.scrumpoker.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SprintDTO {

    private long id;
    private Date beginDate;
    private Date endDate;

}
