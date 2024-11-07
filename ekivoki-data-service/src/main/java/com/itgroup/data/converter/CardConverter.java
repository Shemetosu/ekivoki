package com.itgroup.data.converter;

import com.itgroup.model.dto.request.CardCreateDto;
import com.itgroup.model.dto.request.CardUpdateDto;
import com.itgroup.model.dto.responce.CardDto;
import com.itgroup.data.model.entity.Card;

import java.util.List;

public interface CardConverter {

    Card convert(CardCreateDto source);

    Card convert(CardUpdateDto source);

    CardDto convert(Card source);

    List<CardDto> convert(List<Card> source);
}
