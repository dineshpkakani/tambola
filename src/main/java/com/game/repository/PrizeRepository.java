package com.game.repository;

import com.game.entity.Prize;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrizeRepository extends CrudRepository<Prize,Long> {
}
