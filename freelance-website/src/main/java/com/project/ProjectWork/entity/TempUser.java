package com.project.ProjectWork.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="temp_user")
@ToString
public class TempUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

}
