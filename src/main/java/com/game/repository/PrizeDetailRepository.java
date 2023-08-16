package com.game.repository;

import com.game.dto.ResponseListObj;
import com.game.entity.PrizeDetailEntity;
import com.game.modal.PrizeDetailDataModal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrizeDetailRepository extends JpaRepository<PrizeDetailEntity,Long> {
    @Query(value = "SELECT p.prizeEntity.prizename as prizename,p.sequence as sequence,p.prizevalue as prizevalue " +
            " from PrizeDetailEntity p" +
            " where p.eventId =?1 ") //please add alias after column name then pojo will bind
    List<PrizeDetailDataModal> findByEventId(int eventid);

    @Query(value = "SELECT p.prizeEntity.prizename as prizename,p.sequence as sequence,p.prizevalue as prizevalue " +
            " from PrizeDetailEntity p" +
            " where p.eventId =?1 ")
    List<Object[]> findByEventIdNew(int eventid); //Object[] array will return array only no key-value pair

}
