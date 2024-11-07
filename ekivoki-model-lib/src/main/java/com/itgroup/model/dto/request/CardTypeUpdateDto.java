package com.itgroup.model.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CardTypeUpdateDto extends CardTypeCreateDto {

    private UUID id;
}
