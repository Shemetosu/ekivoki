package com.itgroup.data.controller.impl;

import com.itgroup.data.controller.CommonController;
import com.itgroup.data.service.CardService;
import com.itgroup.data.service.CommonService;
import com.itgroup.model.dto.request.CardCreateDto;
import com.itgroup.model.dto.request.CardUpdateDto;
import com.itgroup.model.dto.responce.CardDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/data/cards")
public class CardControllerImpl extends CommonController<CardDto, CardCreateDto, CardUpdateDto> {

    private final CardService cardService;

    public CardControllerImpl(CommonService<CardDto, CardCreateDto, CardUpdateDto> service, CardService cardService) {
        super(service);
        this.cardService = cardService;
    }

    @GetMapping("/pairs")
    public List<CardDto> pair(@RequestParam UUID sessionId,
                              @RequestParam int dice) {
        return cardService.pair(sessionId, dice);
    }
}