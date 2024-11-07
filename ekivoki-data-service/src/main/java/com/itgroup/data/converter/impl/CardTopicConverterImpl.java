package com.itgroup.data.converter.impl;

import com.itgroup.data.converter.CardTopicConverter;
import com.itgroup.model.dto.request.CardTopicCreateDto;
import com.itgroup.model.dto.request.CardTopicUpdateDto;
import com.itgroup.model.dto.responce.CardTopicDto;
import com.itgroup.data.model.entity.CardTopic;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class CardTopicConverterImpl implements CardTopicConverter {

    @Override
    public CardTopic convert(CardTopicCreateDto source) {
        if (source == null) {
            return null;
        }
        var target = new CardTopic();
        target.setName(source.getName());
        return target;
    }

    @Override
    public CardTopic convert(CardTopicUpdateDto source) {
        if (source == null) {
            return null;
        }
        var target = new CardTopic();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }

    @Override
    public CardTopicDto convert(CardTopic source) {
        if (source == null) {
            return null;
        }
        var target = new CardTopicDto();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }

    @Override
    public List<CardTopicDto> convert(List<CardTopic> source) {
        if (source == null) {
            return List.of();
        }
        List<CardTopicDto> target = new ArrayList<>(source.size());
        for (CardTopic item : source) {
            target.add(convert(item));
        }
        return target;
    }
}
