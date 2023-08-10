package com.game.repository;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public interface EventNameIntrfc {
     long getEventId();
     String getName();

}
