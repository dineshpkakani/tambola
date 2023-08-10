package com.game.service;

import com.game.dto.ResponseListObj;

import com.game.entity.PrizeEntity;
import com.game.repository.PrizeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PrizeServiceImpl implements PrizeService{
    PrizeRepository prizeRepository;

    public PrizeServiceImpl(PrizeRepository prizeRepository) {
        this.prizeRepository = prizeRepository;
    }
    @Override
    public ResponseEntity<ResponseListObj> findAllPrizeList() {
        List<PrizeEntity> pageData= (List<PrizeEntity>) prizeRepository.findAll();
        ResponseListObj responseListObj= ResponseListObj.builder()
                .currentpage(1)
                .totalrecords(pageData.size())
                .lst(Collections.singletonList(pageData))
                .build();
        return ResponseEntity.ok(responseListObj);

    }

    @Override
    public ResponseEntity<ResponseListObj> findNameList() {
        List<String> pageData= prizeRepository.findNameByQuery();
        ResponseListObj responseListObj= ResponseListObj.builder()
                .lst(Collections.singletonList(pageData))
                .build();
        return ResponseEntity.ok(responseListObj);
    }
}
