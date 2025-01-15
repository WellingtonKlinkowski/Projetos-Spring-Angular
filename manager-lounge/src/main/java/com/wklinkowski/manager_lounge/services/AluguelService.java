package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.repositories.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AluguelService {

    private final AluguelRepository aluguelRepository;

    @Autowired
    public AluguelService (AluguelRepository aluguelRepository){
        this.aluguelRepository = aluguelRepository;
    }



}
