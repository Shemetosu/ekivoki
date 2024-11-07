package com.itgroup.user.rest.controller;

import com.itgroup.model.dto.page.PageContentDto;
import com.itgroup.model.dto.request.UserCardCreateDto;
import com.itgroup.model.dto.responce.CardTopicDto;
import com.itgroup.model.dto.responce.CardTypeDto;
import com.itgroup.user.rest.feign.CardServiceClient;
import com.itgroup.user.rest.feign.TopicServiceClient;
import com.itgroup.user.rest.feign.TypeServiceClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users/cards")
public class UserCardController {

    private static final String TOPIC_TABLE_NAME = "card_topic";
    private static final String TOPIC_SORT_FIELD = "name";
    private static final String TYPE_TABLE_NAME = "card_type";
    private static final String TYPE_SORT_FIELD = "dice";

    private final TopicServiceClient topicClient;
    private final TypeServiceClient typeClient;
    private final CardServiceClient cardClient;

    @PostMapping("/topics")
    public PageContentDto<CardTopicDto> topics(@RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber) {
        return topicClient.topics(TOPIC_TABLE_NAME, pageNumber, TOPIC_SORT_FIELD, Map.of());
    }

    @PostMapping("/types")
    public PageContentDto<CardTypeDto> types() {
        return typeClient.types(TYPE_TABLE_NAME, TYPE_SORT_FIELD, Map.of());
    }

    @PostMapping
    public boolean createCard(@RequestBody UserCardCreateDto dto) {
        return cardClient.createCard(dto);
    }
}
