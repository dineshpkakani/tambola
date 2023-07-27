package com.game.service;

import com.game.dto.ResponseListObj;
import com.game.entity.Prize;
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
        List<Prize> pageData= (List<Prize>) prizeRepository.findAll();
        ResponseListObj responseListObj= ResponseListObj.builder()
                .currentpage(1)
                .totalrecords(pageData.size())
                .lst(Collections.singletonList(pageData))
                .build();
        return ResponseEntity.ok(responseListObj);

    }
}
