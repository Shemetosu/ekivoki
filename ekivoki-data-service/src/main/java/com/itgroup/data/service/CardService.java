package com.itgroup.data.service;

import com.itgroup.model.dto.responce.CardDto;

import java.util.List;
import java.util.UUID;

public interface CardService {

    List<CardDto> pair(UUID sessionId, int dice);
}
