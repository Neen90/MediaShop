package com.vdab.mediashop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100,nullable = false)
    private String title;
    @Column(precision = 5,scale = 2,nullable = false)
    private Double price;
    @Column(length = 100,nullable = false)
    private String vendorId;


}
