package com.vdab.mediashop.domain;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Favourites {

    @OneToMany(fetch = FetchType.EAGER)
    private Article article;
    @ManyToOne
    private Users user;
}
