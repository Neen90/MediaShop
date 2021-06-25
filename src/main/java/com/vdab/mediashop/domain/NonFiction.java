package com.vdab.mediashop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
//@DiscriminatorColumn(name = "type")
@DiscriminatorValue("Non-Fiction")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity

public class NonFiction extends Book {

    @Enumerated(EnumType.STRING)
    @Column
    private Subject subject;
}
