package com.game.service;

import com.game.dto.ResponseListObj;
import com.game.entity.EventEntity;
import com.game.entity.PrizeDetailEntity;
import com.game.entity.PrizeEntity;
import com.game.modal.PrizeDetailDataModel;
import com.game.repository.PrizeDetailRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class PrizeConfigureServiceImpl implements PrizeConfigureService{

    PrizeDetailRepository prizeDetailRepository;

    public PrizeConfigureServiceImpl(PrizeDetailRepository prizeDetailRepository) {
        this.prizeDetailRepository = prizeDetailRepository;
    }

    @Override
    public ResponseListObj getAllByEventById(long eventid) {
        List<PrizeDetailDataModel> pageData= prizeDetailRepository.findByEventId(eventid);

        ResponseListObj responseListObj= ResponseListObj.builder()
                .lst(Collections.singletonList(pageData))
                .build();
        return responseListObj;

    }
    @Override
    public ResponseListObj getAllByEventByIdNew(long eventid) {
       List<Object[]> pageData= prizeDetailRepository.findByEventIdNew(eventid);

        ResponseListObj responseListObj= ResponseListObj.builder()
                .lst(Collections.singletonList(pageData))
                .build();
        return null;

    }

    @Override
    @Transactional
    public ResponseListObj saveAll(List<PrizeDetailEntity> lst) {
       EventEntity eventEntity=lst.get(0).getEventEntity();
        PrizeEntity prizeEntity=lst.get(0).getPrizeEntity();

        if(findPrizeConfigureWithEventAndPrize(eventEntity,prizeEntity)){
            prizeDetailRepository.saveAll(lst);
            return ResponseListObj.builder().lst(Collections.singletonList("Saved successfully")).build();
        }else{
            return ResponseListObj.builder().lst(Collections.singletonList("Already exist")).build();
        }


    }

    @Override
    public boolean findPrizeConfigureWithEventAndPrize(EventEntity eventEntity, PrizeEntity prizeEntity) {
        List<PrizeDetailEntity> prizeDetailEntities= prizeDetailRepository.findByEventEntityAndPrizeEntity(eventEntity,prizeEntity);
        return prizeDetailEntities.size()==0;
    }


}
