package com.itgroup.model.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CardTopicUpdateDto extends CardTopicCreateDto {

    private UUID id;
}
