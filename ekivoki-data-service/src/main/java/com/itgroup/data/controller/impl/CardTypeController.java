package com.itgroup.data.controller.impl;

import com.itgroup.data.controller.CommonController;
import com.itgroup.model.dto.request.CardTypeCreateDto;
import com.itgroup.model.dto.request.CardTypeUpdateDto;
import com.itgroup.model.dto.responce.CardTypeDto;
import com.itgroup.data.service.CommonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data/cards/types")
public class CardTypeController extends CommonController<CardTypeDto, CardTypeCreateDto, CardTypeUpdateDto> {

    public CardTypeController(CommonService<CardTypeDto, CardTypeCreateDto, CardTypeUpdateDto> service) {
        super(service);
    }
}