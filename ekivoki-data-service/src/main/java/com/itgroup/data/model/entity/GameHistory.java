package com.itgroup.data.model.entity;

import com.itgroup.data.model.entity.parent.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GameHistory extends BaseEntity {

    private UUID sessionId;
    private UUID cardId;
}
