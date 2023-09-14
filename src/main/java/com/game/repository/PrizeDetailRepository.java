package com.game.repository;

import com.game.entity.EventEntity;
import com.game.entity.PrizeDetailEntity;
import com.game.entity.PrizeEntity;
import com.game.modal.PrizeDetailDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrizeDetailRepository extends JpaRepository<PrizeDetailEntity,Long> {
    @Query(value = "SELECT p.prizeEntity.prizename as prizename,p.sequence as sequence,p.prizevalue as prizevalue " +
            " from PrizeDetailEntity p" +
            " where p.eventEntity.eventId =?1 ") //please add alias after column name then pojo will bind
    List<PrizeDetailDataModel> findByEventId(long eventid);


    @Query(value = "SELECT p.prizeEntity.prizename as prizename,p.sequence as sequence,p.prizevalue as prizevalue " +
            " from PrizeDetailEntity p" +
            " where p.eventEntity.eventId =?1 ")
    List<Object[]> findByEventIdNew(long eventid); //Object[] array will return array only no key-value pair*/

    List<PrizeDetailEntity> findByEventEntityAndPrizeEntity(EventEntity eventEntity, PrizeEntity prizeEntity);

}
