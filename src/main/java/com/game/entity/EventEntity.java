package com.game.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@DynamicUpdate
@Table(name="eventmaster")
public class EventEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="eid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long eventId;

    @NotBlank(message = "The eventname is required.")
    @Size(min = 5, max = 50, message = "The event name must be from 5 to 50 characters.")
    @Column(name="name",unique = true)
    String name;

    @NotNull()
    @Future(message = "The event date must be in the future.")
    @JsonFormat(pattern = "MM/dd/yyyy", shape = JsonFormat.Shape.STRING)
    @Column(name = "eventdate")
    LocalDate eventDate;

    @Column(name="maxtickets")
    @Min(value = 1, message ="Atleast one tickets per player" )
    @Max(value = 5,message = "Maximum five tickets per player")
    int noOfTickets;

    @Column(name="priceperticket")
    @Min(value = 10, message ="Atleast 10 rupees per ticket" )
    int pricePerTicket;

    @Column(name="soldtickets")
    int soldTickets;

    @Column(name="noofusers")
    int noOfUsers;

    @Column(name="status")
    String status;

    @Column(name="createddate",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable = false,updatable = false)
    LocalDate createdDate=LocalDate.now();

    @Column(name="createdby")
    Long userid;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }
    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
    public int getNoOfTickets() {
        return noOfTickets;
    }
    public void setNoOfTickets(int noOfTickets) {
        this.noOfTickets = noOfTickets;
    }
    public int getPricePerTicket() {
        return pricePerTicket;
    }
    public void setPricePerTicket(int pricePerTicket) {
        this.pricePerTicket = pricePerTicket;
    }
    public int getSoldTickets() {
        return soldTickets;
    }
    public void setSoldTickets(int soldTickets) {
        this.soldTickets = soldTickets;
    }
    public int getNoOfUsers() {
        return noOfUsers;
    }
    public void setNoOfUsers(int noOfUsers) {
        this.noOfUsers = noOfUsers;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDate getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}