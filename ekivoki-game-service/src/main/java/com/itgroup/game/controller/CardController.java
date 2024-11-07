package com.itgroup.game.controller;

import com.itgroup.game.feign.CardApiService;
import com.itgroup.model.dto.responce.CardDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/game/cards")
public class CardController {

    private final CardApiService service;

    @GetMapping
    public List<CardDto> get2Cards(@RequestParam UUID sessionId,
                                   @RequestParam int dice) {
        return service.get2Cards(sessionId, dice);
    }
}
