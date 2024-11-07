package com.itgroup.data.model.entity;

import com.itgroup.data.model.entity.parent.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Card extends BaseEntity {

    private UUID topicId;
    private UUID typeId;
    private String task;
    private String description;
    private String question;
    private int leadTime;
    private LocalDateTime dateCreation;
    private LocalDateTime lastModified;
    private long version;
}
