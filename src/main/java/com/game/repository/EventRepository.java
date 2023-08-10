package com.game.repository;

import com.game.entity.EventEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EventRepository extends JpaRepository<EventEntity,Long> {


    Page<EventEntity> findAll(Pageable pageable);
    //Page<Event> findByName(String searchby,Pageable pageable);
    Page<EventEntity> findByNameStartsWith(String searchby,Pageable pageable);
    EventEntity findByEventId(long eventId);

    @Query("SELECT e.name FROM EventEntity e")
    List<Object[]> findAlleventByQuery();

   /* @EntityGraph(value = "entityname")
    List<EventEntity> findAlleventByEntityGraph();*/

    List<EventNameIntrfc> findAllByStatus(String status);





}
