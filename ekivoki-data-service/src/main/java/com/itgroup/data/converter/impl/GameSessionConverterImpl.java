package com.itgroup.data.converter.impl;

import com.itgroup.data.converter.GameSessionConverter;
import com.itgroup.model.dto.responce.GameSessionDto;
import com.itgroup.data.model.entity.GameSession;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameSessionConverterImpl implements GameSessionConverter {

    @Override
    public GameSessionDto convert(GameSession source) {
        if (source == null) {
            return null;
        }
        var target = new GameSessionDto();
        target.setId(source.getId());
        target.setDateCreation(source.getDateCreation());
        return target;
    }

    @Override
    public List<GameSessionDto> convert(List<GameSession> source) {
        if (source == null) {
            return List.of();
        }
        List<GameSessionDto> target = new ArrayList<>();
        for (GameSession item : source) {
            target.add(convert(item));
        }
        return target;
    }
}
