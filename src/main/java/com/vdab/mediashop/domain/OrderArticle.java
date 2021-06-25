package com.vdab.mediashop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderArticle {
    @OneToMany(fetch = FetchType.EAGER)
    private Article article;

    @ManyToOne
    private Order order;

}
