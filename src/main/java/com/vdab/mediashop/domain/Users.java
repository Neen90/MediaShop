package com.vdab.mediashop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^(([a-zA-Z]){1})(([a-zA-Z])|([-])){0,13}(([a-zA-Z]){1})$",
            message = "Your name can't contain a number, whitespace or a special character, maximum of 15 characters")
    private String userName;


}
