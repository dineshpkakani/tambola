package com.game.repository;

import com.game.entity.PrizeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrizeRepository extends CrudRepository<PrizeEntity,Long> {
    @Query("SELECT p.prizename FROM PrizeEntity p")
    List<String> findNameByQuery();
}
