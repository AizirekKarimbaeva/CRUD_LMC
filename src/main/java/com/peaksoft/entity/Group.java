package com.peaksoft.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "date_of_start")
    private String dateOfStart;
    @Column(name = "date_of_finish")
    private String dateOfFinish;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "group")
    private List<Student> students;
    @ManyToMany(cascade = {CascadeType.REFRESH,CascadeType.MERGE})
    @JoinTable(
            name = "course_group",
            joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    )
    private List<Course> course;
    @Transient
    private Long courseId;

}
