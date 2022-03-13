package com.acelada.dsmovie.controllers;

import com.acelada.dsmovie.dto.MovieDTO;
import com.acelada.dsmovie.dto.ScoreDTO;
import com.acelada.dsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

    @Autowired
    private ScoreService service;
    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO score) {
        return service.saveScore(score);
    }

}
