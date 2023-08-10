package com.game.repository;

import com.game.entity.PrizeDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrizeDetailRepository extends JpaRepository<PrizeDetailEntity,Long> {
}
