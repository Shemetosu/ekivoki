package com.itgroup.game.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.itgroup.game.service.DiceService;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/game/dices")
public class DiceController {

    private final DiceService service;

    @GetMapping
    public int rollDice(UUID sessionId) {
        return service.rollDice(sessionId);
    }
}
