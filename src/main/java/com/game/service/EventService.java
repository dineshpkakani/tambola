package com.game.service;

import com.game.dto.ResponseListObj;
import com.game.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EventService {
    ResponseListObj findAllEvents(int start, int length);

//  ResponseListObj findByName(String byTitle,int start, int length);
    ResponseListObj findByNameStartsWith(String byTitle,int start, int length);
    ResponseListObj findByEventId(long eventid);


    String save(Event e);
}
