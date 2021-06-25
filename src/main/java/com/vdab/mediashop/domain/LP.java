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
//@DiscriminatorValue("LP")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"artist","title"}))

public class LP extends Article {

    private String artist;

    @Enumerated(EnumType.STRING)
    private LPGenre lpGenre;

}
