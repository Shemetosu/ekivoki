package com.itgroup.data.converter;

import com.itgroup.model.dto.request.CardTopicCreateDto;
import com.itgroup.model.dto.request.CardTopicUpdateDto;
import com.itgroup.model.dto.responce.CardTopicDto;
import com.itgroup.data.model.entity.CardTopic;

import java.util.List;

public interface CardTopicConverter {

    CardTopic convert(CardTopicCreateDto source);

    CardTopic convert(CardTopicUpdateDto source);

    CardTopicDto convert(CardTopic source);

    List<CardTopicDto> convert(List<CardTopic> source);
}
