package com.game.controller;

import com.game.dto.ResponseListObj;
import com.game.entity.PrizeDetailEntity;
import com.game.service.PrizeConfigureService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prizeconfigure")
public class PrizeConfigureController {
    PrizeConfigureService prizeConfigureService;
    public PrizeConfigureController(PrizeConfigureService prizeConfigureService) {
        this.prizeConfigureService = prizeConfigureService;
    }
    @GetMapping("/getAll/{eventid}")
    public ResponseListObj getAllPrizeDetails(@PathVariable int eventid) {
        return prizeConfigureService.getAllByEventById(eventid);
    }

    /*    @PostMapping
        public ResponseListObj savePrizeDetails(@PathVariable int eventid){
            return prizeConfigureService.getAllByEventById(eventid);
        }*/
    @PostMapping
    public ResponseListObj saveAll(@RequestBody List<PrizeDetailEntity> persons) {
        prizeConfigureService.saveAll(persons);
        return null;
    }
}