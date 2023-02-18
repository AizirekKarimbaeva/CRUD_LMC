package com.peaksoft.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    private String email;
    @Column(name = "last_name")
    private String lastName;
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE})
    private Group group;

    @Transient
    private Long groupId;
}
