package com.itgroup.model.dto.responce;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CardDto {

    private UUID id;
    private CardTopicDto topic;
    private CardTypeDto type;
    private String task;
    private String description;
    private String question;
    private int leadTime;
    private String dateCreation;
    private String lastModified;
    private long version;
}
