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
@DiscriminatorValue("Fiction")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Fiction extends Book {

    @Enumerated(EnumType.STRING)
    @Column
    private BookGenre bookGenre;

    @Column(length = 255)
    private String summary;
}
