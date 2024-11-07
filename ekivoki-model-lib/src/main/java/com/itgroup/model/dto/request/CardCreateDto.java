package com.itgroup.model.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CardCreateDto {

    private UUID topicId;
    private UUID typeId;
    private String task;
    private String description; // пояснение по исполнению задания
    private String question;    // описание задания
    private Integer leadTime;
}
