package com.game.modal;

import java.time.LocalDate;

public interface EventNameModel {
     long getEventId();
     String getName();
     LocalDate getEventDate();

     String getStatus();


}
