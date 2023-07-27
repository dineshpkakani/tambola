package com.game.service;

import com.game.dto.ResponseListObj;
import org.springframework.http.ResponseEntity;

public interface PrizeService {
    ResponseEntity<ResponseListObj> findAllPrizeList();
}
