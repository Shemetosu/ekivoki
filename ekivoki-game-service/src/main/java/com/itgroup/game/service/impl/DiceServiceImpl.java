package com.itgroup.game.service.impl;

import com.itgroup.game.exception.GameSessionException;
import com.itgroup.game.feign.GameSessionApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.itgroup.game.service.DiceService;

import java.util.Random;
import java.util.UUID;

@RequiredArgsConstructor
@Service
class DiceServiceImpl implements DiceService {

    private static final int MIN = 1;
    private static final int MAX = 6;

    private final GameSessionApiService service;
    private final Random random;

    @Override
    public int rollDice(UUID sessionId) {
        if (service.existsById(sessionId)) {
            return random.nextInt(MAX) + MIN;
        }
        throw new GameSessionException("Сессия игры не обнаружена");
    }
}
