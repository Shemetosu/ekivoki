package com.itgroup.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCardCreateDto extends CardCreateDto {

    private String topicName;
}
