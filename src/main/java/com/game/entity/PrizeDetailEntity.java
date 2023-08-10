package com.game.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="eventmaster")
public class PrizeDetailEntity implements Serializable {
    @Id
    private Long id;


    // Unidirectional
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "eventid", referencedColumnName = "eid") //eventid(small case) column will refer as reference(Foriegn)
    private EventEntity eventEntity;                                      // and referenced Column Name will refer primary of parent table column nmae not enity field name


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prizeid", referencedColumnName = "prizeid")
    private PrizeEntity prizeEntity;

    @Column(name="sequence")
    private int sequence;

    public EventEntity getEventEntity() {
        return eventEntity;
    }

    public void setEventEntity(EventEntity eventEntity) {
        this.eventEntity = eventEntity;
    }

    public PrizeEntity getPrizeEntity() {
        return prizeEntity;
    }

    public void setPrizeEntity(PrizeEntity prizeEntity) {
        this.prizeEntity = prizeEntity;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getPrizevalue() {
        return prizevalue;
    }

    public void setPrizevalue(int prizevalue) {
        this.prizevalue = prizevalue;
    }

    @Column(name="prizevalue")
    private int prizevalue;


}
