package com.vdab.mediashop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Data
@DiscriminatorColumn(name = "Type",discriminatorType = DiscriminatorType.STRING)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public abstract class Book extends Article{
    @Column(length = 100)
    private String author;
//    @Pattern(regexp= "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3}) " +
//            "[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$) " +
//            "(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$" , message = "ISBN must be correctly formatted.")
    private String isbn;
    private Long numberOfPages;

  }
