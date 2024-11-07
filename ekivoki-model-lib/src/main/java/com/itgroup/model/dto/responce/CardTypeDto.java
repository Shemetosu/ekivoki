package com.itgroup.model.dto.responce;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CardTypeDto {

    private UUID id;
    private Integer dice;
    private String name;
    private String description;
}
