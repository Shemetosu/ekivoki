package com.itgroup.data.converter;

import com.itgroup.model.dto.responce.GameSessionDto;
import com.itgroup.data.model.entity.GameSession;

import java.util.List;

public interface GameSessionConverter {

    GameSessionDto convert(GameSession source);

    List<GameSessionDto> convert(List<GameSession> source);
}
