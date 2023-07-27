package com.game.controller;

import com.game.dto.ResponseListObj;
import com.game.service.PrizeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prize")
public class PrizeMasterController {

    PrizeService prizeService;

    public PrizeMasterController(PrizeService prizeService) {
        this.prizeService = prizeService;
    }
    @GetMapping("/getall")
    public ResponseEntity<ResponseListObj> getAll(){
        return prizeService.findAllPrizeList();
    }

}
