package com.itgroup.data.controller.impl;

import com.itgroup.data.controller.CommonController;
import com.itgroup.model.dto.request.CardTopicCreateDto;
import com.itgroup.model.dto.request.CardTopicUpdateDto;
import com.itgroup.model.dto.responce.CardTopicDto;
import com.itgroup.data.service.CommonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data/cards/topics")
public class CardTopicControllerImpl extends CommonController<CardTopicDto, CardTopicCreateDto, CardTopicUpdateDto> {

    public CardTopicControllerImpl(CommonService<CardTopicDto, CardTopicCreateDto, CardTopicUpdateDto> service) {
        super(service);
    }
}
