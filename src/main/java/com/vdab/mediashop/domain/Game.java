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
//@DiscriminatorValue("Game")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"publisher","title"}))
public class Game extends Article {
    @Column(length = 100)
    private String publisher;
    private Long minAge;
    @Enumerated(EnumType.STRING)
    private GameGenre gameGenre;

//    private String type ="Game";
}
