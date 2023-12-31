package com.game.service;

import com.game.dto.ResponseListObj;
import com.game.entity.EventEntity;
import com.game.entity.PrizeDetailEntity;
import com.game.entity.PrizeEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PrizeConfigureService {
    ResponseListObj getAllByEventById(long eventid);
    ResponseListObj getAllByEventByIdNew(long eventid);

    ResponseListObj saveAll(List<PrizeDetailEntity> lst);

    boolean findPrizeConfigureWithEventAndPrize(EventEntity eventEntity, PrizeEntity prizeEntity);

}
