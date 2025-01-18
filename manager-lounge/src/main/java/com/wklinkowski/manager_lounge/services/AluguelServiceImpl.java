package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.mappers.NarguileMapper;
import com.wklinkowski.manager_lounge.repositories.AluguelRepository;
import org.springframework.stereotype.Service;

@Service
public class AluguelServiceImpl {

    private final AluguelRepository aluguelRepository;
    private final CarvaoServiceImpl carvaoService;
    private final RoshServiceImpl roshServiceImpl;
    private final FumoServiceImpl fumoServiceImpl;
    private final NarguileServiceImpl narguileServiceImpl;
    private final NarguileMapper narguileMapper;

    public AluguelServiceImpl(AluguelRepository aluguelRepository, CarvaoServiceImpl carvaoServiceImpl, RoshServiceImpl roshServiceImpl,
                              FumoServiceImpl fumoServiceImpl, NarguileServiceImpl narguileServiceImpl, NarguileMapper narguileMapper) {
        this.aluguelRepository = aluguelRepository;
        this.carvaoService = carvaoServiceImpl;
        this.roshServiceImpl = roshServiceImpl;
        this.fumoServiceImpl = fumoServiceImpl;
        this.narguileServiceImpl = narguileServiceImpl;
        this.narguileMapper = narguileMapper;
    }

    //CREATE


    //GET TODOS
    //GET POR ID
    //CONSULTAS PERSONALIZADAS
    //PUT
    //DELETES

}
