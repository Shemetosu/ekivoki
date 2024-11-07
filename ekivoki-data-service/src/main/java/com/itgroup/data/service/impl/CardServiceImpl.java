package com.itgroup.data.service.impl;

import com.itgroup.data.converter.CardConverter;
import com.itgroup.data.exception.GameSessionException;
import com.itgroup.data.model.entity.Card;
import com.itgroup.data.repository.GameHistoryRepository;
import com.itgroup.data.repository.dao.CardRepository;
import com.itgroup.data.repository.dao.GameSessionRepository;
import com.itgroup.data.service.CardService;
import com.itgroup.data.service.CommonService;
import com.itgroup.data.validation.CardValidator;
import com.itgroup.model.dto.request.CardCreateDto;
import com.itgroup.model.dto.request.CardTopicCreateDto;
import com.itgroup.model.dto.request.CardTopicUpdateDto;
import com.itgroup.model.dto.request.CardTypeCreateDto;
import com.itgroup.model.dto.request.CardTypeUpdateDto;
import com.itgroup.model.dto.request.CardUpdateDto;
import com.itgroup.model.dto.responce.CardDto;
import com.itgroup.model.dto.responce.CardTopicDto;
import com.itgroup.model.dto.responce.CardTypeDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CardServiceImpl implements CommonService<CardDto, CardCreateDto, CardUpdateDto>, CardService {

    private static final int LIMIT = 10;

    private final CardRepository cardRepository;
    private final GameHistoryRepository gameHistoryRepository;
    private final CommonService<CardTopicDto, CardTopicCreateDto, CardTopicUpdateDto> topicService;
    private final CommonService<CardTypeDto, CardTypeCreateDto, CardTypeUpdateDto> typeService;
    private final GameSessionRepository gameRepository;
    private final CardValidator validator;
    private final CardConverter cardConverter;
    private final Random random;

    @Override
    public CardDto findById(UUID id) {
        List<Card> cardList = List.of(cardRepository.findById(id));
        return getFillCards(cardList).get(0);
    }

    @Override
    public List<CardDto> findAll(String queryTail) {
        List<Card> cardList = cardRepository.findAll(queryTail);
        return getFillCards(cardList);
    }

    @Override
    public List<CardDto> findAll(Collection<UUID> idList) {
        List<Card> cardList = cardRepository.findAll(idList);
        return getFillCards(cardList);
    }

    @Override
    public CardDto create(CardCreateDto dto) {
        validator.checkCardCreate(dto);
        var target = cardConverter.convert(cardRepository.create(cardConverter.convert(dto)));
        target.setTopic(topicService.findById(dto.getTopicId()));
        target.setType(typeService.findById(dto.getTypeId()));
        return target;
    }

    @Override
    public CardDto update(CardUpdateDto dto) {
        validator.checkCardUpdate(dto);
        var target = cardConverter.convert(cardRepository.update(cardConverter.convert(dto)));
        target.setTopic(topicService.findById(dto.getTopicId()));
        target.setType(typeService.findById(dto.getTypeId()));
        return target;
    }

    @Override
    public long count() {
        return cardRepository.count();
    }

    @Override
    public void remove(UUID id) {
        cardRepository.remove(id);
    }

    @Override
    public List<CardDto> pair(UUID sessionId, int dice) {
        if (gameRepository.existsById(sessionId)) {
            List<Card> cardList = pairBySessionIdAndDice(sessionId, dice);
            return getFillCards(cardList);
        }
        throw new GameSessionException("Вашей сессии кабздец, идите спать");
    }

    private List<Card> pairBySessionIdAndDice(UUID sessionId, int dice) {
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", sessionId.toString());
        map.put("dice", dice);
        map.put("limit", LIMIT);
        long count = cardRepository.count();
        int offset = count < LIMIT ? (int) count : ((int) cardRepository.count() / LIMIT);
        map.put("offset", offset);

        List<UUID> idList = cardRepository.getPairByParameters(map);
        if (idList.size() < 2) {
            throw new GameSessionException("Карты кончились");
        }

        List<Card> sideList;
        if (idList.size() == 2) {
            sideList = cardRepository.findAll(idList);
        } else {
            int random1 = 0;
            int random2 = 0;
            while (random1 == random2) {
                random1 = random.nextInt(idList.size());
                random2 = random.nextInt(idList.size());
            }
            sideList = cardRepository.findAll(
                    List.of(idList.get(random1), idList.get(random2))
            );
        }

        if (sideList.isEmpty() || sideList.size() < 2) {
            throw new GameSessionException("Карты кончились");
        }
        for (Card item : sideList) {
            gameHistoryRepository.addHistory(sessionId, item.getId());
        }
        return sideList;
    }

    private List<CardDto> getFillCards(List<Card> cardList) {
        Set<UUID> topicIds = cardList.stream().map(Card::getTopicId).collect(Collectors.toSet());
        List<CardTopicDto> cardTopicDtoList = topicService.findAll(topicIds);
        Set<UUID> typeIds = cardList.stream().map(Card::getTypeId).collect(Collectors.toSet());
        List<CardTypeDto> cardTypeDtoList = typeService.findAll(typeIds);

        List<CardDto> target = new ArrayList<>(cardList.size());
        for (Card card : cardList) {
            CardDto dto = cardConverter.convert(card);
            dto.setTopic(
                    cardTopicDtoList
                            .stream()
                            .filter(item -> item.getId().equals(card.getTopicId()))
                            .findFirst().orElse(null)
            );
            dto.setType(
                    cardTypeDtoList
                            .stream()
                            .filter(item -> item.getId().equals(card.getTypeId()))
                            .findFirst()
                            .orElse(null)
            );
            target.add(dto);
        }
        return target;
    }
}
