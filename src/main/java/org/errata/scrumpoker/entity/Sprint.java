package org.errata.scrumpoker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
//import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sprints")
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date beginDate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date endDate;

    /*
    @OneToMany
    @JoinColumn(name = "user_story")
    Set<UserStory> stories;
    */
}
