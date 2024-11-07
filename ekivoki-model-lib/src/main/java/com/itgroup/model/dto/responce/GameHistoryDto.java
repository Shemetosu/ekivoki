package com.itgroup.model.dto.responce;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GameHistoryDto {

    private UUID id;
    private GameSessionDto session;
    private CardDto card;
}
