package com.wklinkowski.manager_lounge.controller;

import com.wklinkowski.manager_lounge.services.AluguelServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    private final AluguelServiceImpl aluguelServiceImpl;

    public AluguelController(AluguelServiceImpl aluguelServiceImpl) {
        this.aluguelServiceImpl = aluguelServiceImpl;
    }
}
