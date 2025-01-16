package com.wklinkowski.manager_lounge.services;

import com.wklinkowski.manager_lounge.mappers.NarguileMapper;
import com.wklinkowski.manager_lounge.repositories.AluguelRepository;
import org.springframework.stereotype.Service;

@Service
public class AluguelService {

    private final AluguelRepository aluguelRepository;
    private final CarvaoService carvaoService;
    private final RoshService roshService;
    private final FumoService fumoService;
    private final NarguileService narguileService;
    private final NarguileMapper narguileMapper;

    public AluguelService(AluguelRepository aluguelRepository, CarvaoService carvaoService, RoshService roshService,
                                FumoService fumoService, NarguileService narguileService, NarguileMapper narguileMapper) {
        this.aluguelRepository = aluguelRepository;
        this.carvaoService = carvaoService;
        this.roshService = roshService;
        this.fumoService = fumoService;
        this.narguileService = narguileService;
        this.narguileMapper = narguileMapper;
    }

    //CREATE


    //GET TODOS
    //GET POR ID
    //CONSULTAS PERSONALIZADAS
    //PUT
    //DELETES

}
