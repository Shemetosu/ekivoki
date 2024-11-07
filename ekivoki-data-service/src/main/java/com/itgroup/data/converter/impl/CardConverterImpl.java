package com.itgroup.data.converter.impl;

import com.itgroup.data.converter.CardConverter;
import com.itgroup.model.dto.request.CardCreateDto;
import com.itgroup.model.dto.request.CardUpdateDto;
import com.itgroup.model.dto.responce.CardDto;
import com.itgroup.data.model.entity.Card;
import com.itgroup.data.util.DateTimeUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class CardConverterImpl implements CardConverter {

    @Override
    public Card convert(CardCreateDto source) {
        if (source == null) {
            return null;
        }
        var target = new Card();
        target.setTopicId(source.getTopicId());
        target.setTypeId(source.getTypeId());
        target.setTask(source.getTask());
        target.setDescription(source.getDescription());
        target.setQuestion(source.getQuestion());
        target.setLeadTime(source.getLeadTime());
        return target;
    }

    @Override
    public Card convert(CardUpdateDto source) {
        if (source == null) {
            return null;
        }
        var target = new Card();
        target.setId(source.getId());
        target.setTopicId(source.getTopicId());
        target.setTypeId(source.getTypeId());
        target.setTask(source.getTask());
        target.setDescription(source.getDescription());
        target.setQuestion(source.getQuestion());
        target.setLeadTime(source.getLeadTime());
        return target;
    }

    @Override
    public CardDto convert(Card source) {
        if (source == null) {
            return null;
        }
        var target = new CardDto();
        target.setId(source.getId());
        //target.setTopic(source.getTopicId());
        //target.setType(source.getTypeId());
        target.setTask(source.getTask());
        target.setDescription(source.getDescription());
        target.setQuestion(source.getQuestion());
        target.setLeadTime(source.getLeadTime());
        target.setDateCreation(DateTimeUtils.convert(source.getDateCreation()));
        target.setLastModified(DateTimeUtils.convert(source.getLastModified()));
        target.setVersion(source.getVersion());
        return target;
    }

    @Override
    public List<CardDto> convert(List<Card> source) {
        if (source == null) {
            return List.of();
        }
        List<CardDto> target = new ArrayList<>(source.size());
        for (Card item : source) {
            target.add(convert(item));
        }
        return target;
    }
}
