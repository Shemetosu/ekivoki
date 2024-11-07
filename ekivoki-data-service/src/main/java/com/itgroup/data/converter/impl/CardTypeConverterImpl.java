package com.itgroup.data.converter.impl;

import com.itgroup.data.converter.CardTypeConverter;
import com.itgroup.model.dto.request.CardTypeCreateDto;
import com.itgroup.model.dto.request.CardTypeUpdateDto;
import com.itgroup.model.dto.responce.CardTypeDto;
import com.itgroup.data.model.entity.CardType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class CardTypeConverterImpl implements CardTypeConverter {

    @Override
    public CardType convert(CardTypeCreateDto source) {
        if (source == null) {
            return null;
        }
        var target = new CardType();
        target.setDice(source.getDice());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        return target;
    }

    @Override
    public CardType convert(CardTypeUpdateDto source) {
        if (source == null) {
            return null;
        }
        var target = new CardType();
        target.setId(source.getId());
        target.setDice(source.getDice());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        return target;
    }

    @Override
    public CardTypeDto convert(CardType source) {
        if (source == null) {
            return null;
        }
        var target = new CardTypeDto();
        target.setId(source.getId());
        target.setDice(source.getDice());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        return target;
    }

    @Override
    public List<CardTypeDto> convert(List<CardType> source) {
        if (source == null) {
            return List.of();
        }
        List<CardTypeDto> target = new ArrayList<>(source.size());
        for (CardType item : source) {
            target.add(convert(item));
        }
        return target;
    }
}
