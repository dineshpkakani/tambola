package com.game.entity;

import javax.persistence.CascadeType;
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
    @JoinColumn(name = "eventid", referencedColumnName = "id") //eventid column will refer as reference(Foriegn)
    private Event event;                                      // and referenced Column Name will refer primary of parent table


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
