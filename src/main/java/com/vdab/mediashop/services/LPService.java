package com.vdab.mediashop.services;

import com.vdab.mediashop.domain.LP;
import com.vdab.mediashop.repositories.LPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LPService {
    @Autowired
    private LPRepository lpRepository;


    public List<LP> getAllLPs() {
        return lpRepository.getAllLps();
    }

    public void saveLp(LP newLP) {
        lpRepository.saveLp(newLP);
    }

    public LP findLPById(long id) {
        return lpRepository.findLPById(id);
    }

    public void updateLP(LP lp) {
        lpRepository.updateLP(lp);
    }

    public void deleteLP(long id) {
        lpRepository.deleteLP(id);
    }
}
