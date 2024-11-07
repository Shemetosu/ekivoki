package com.itgroup.model.dto.responce;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class GameSessionDto {

    private UUID id;
    private LocalDateTime dateCreation;
}
