package com.game.service;

import com.game.dto.ResponseListObj;
import com.game.entity.EventEntity;
import com.game.entity.EventEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EventService {
    ResponseListObj findAllEvents(int start, int length);

    ResponseListObj findAllEvents();

    //  ResponseListObj findByName(String byTitle,int start, int length);
    ResponseListObj findByNameStartsWith(String byTitle,int start, int length);
    ResponseListObj findByEventId(long eventid);


    String save(EventEntity e);
}
