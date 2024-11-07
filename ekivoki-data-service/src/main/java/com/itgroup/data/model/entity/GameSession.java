package com.itgroup.data.model.entity;

import com.itgroup.data.model.entity.parent.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GameSession extends BaseEntity {

    private LocalDateTime dateCreation;
}
