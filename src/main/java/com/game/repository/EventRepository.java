package com.game.repository;

import com.game.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    Page<Event> findAll(Pageable pageable);
    //Page<Event> findByName(String searchby,Pageable pageable);
    Page<Event> findByNameStartsWith(String searchby,Pageable pageable);
    Event findByEventId(long eventId);

}
