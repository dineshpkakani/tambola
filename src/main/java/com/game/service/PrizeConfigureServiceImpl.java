package com.game.service;

import com.game.dto.ResponseListObj;
import com.game.entity.PrizeDetailEntity;
import com.game.modal.PrizeDetailDataModal;
import com.game.repository.PrizeDetailRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PrizeConfigureServiceImpl implements PrizeConfigureService{

    PrizeDetailRepository prizeDetailRepository;

    public PrizeConfigureServiceImpl(PrizeDetailRepository prizeDetailRepository) {
        this.prizeDetailRepository = prizeDetailRepository;
    }

    @Override
    public ResponseListObj getAllByEventById(int eventid) {
        List<PrizeDetailDataModal> pageData= prizeDetailRepository.findByEventId(eventid);

        ResponseListObj responseListObj= ResponseListObj.builder()
                .lst(Collections.singletonList(pageData))
                .build();
        return responseListObj;

    }
    @Override
    public ResponseListObj getAllByEventByIdNew(int eventid) {
        List<Object[]> pageData= prizeDetailRepository.findByEventIdNew(eventid);

        ResponseListObj responseListObj= ResponseListObj.builder()
                .lst(Collections.singletonList(pageData))
                .build();
        return responseListObj;

    }

    @Override
    public ResponseListObj saveAll(List<PrizeDetailEntity> lst) {
        prizeDetailRepository.saveAll(lst);
        return null;
    }


}
