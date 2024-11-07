package com.itgroup.data.converter;

import com.itgroup.model.dto.request.CardTypeCreateDto;
import com.itgroup.model.dto.request.CardTypeUpdateDto;
import com.itgroup.model.dto.responce.CardTypeDto;
import com.itgroup.data.model.entity.CardType;

import java.util.List;

public interface CardTypeConverter {

    CardType convert(CardTypeCreateDto source);

    CardType convert(CardTypeUpdateDto source);

    CardTypeDto convert(CardType source);

    List<CardTypeDto> convert(List<CardType> source);
}
