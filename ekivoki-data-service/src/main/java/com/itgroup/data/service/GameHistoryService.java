package com.itgroup.data.service;

import com.itgroup.data.repository.GameHistoryRepository;
import com.itgroup.model.dto.responce.GameHistoryDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GameHistoryService implements CollectorService<GameHistoryDto> {

    private final GameHistoryRepository repository;

    @Override
    public long count() {
        return 0;
    }

    @Override
    public List<GameHistoryDto> findAll(String queryTail) {
        return null;
    }
}
