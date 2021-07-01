package com.vdab.mediashop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



import javax.persistence.*;
import javax.validation.constraints.Pattern;

@EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;


    private boolean employee;

    private boolean loggedIn;
}
