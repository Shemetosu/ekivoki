package com.itgroup.data.service;

import com.itgroup.data.converter.GameSessionConverter;
import com.itgroup.data.repository.dao.GameSessionRepository;
import com.itgroup.model.dto.responce.GameSessionDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class GameSessionService implements CollectorService<GameSessionDto> {

    private final GameSessionRepository repository;
    private final GameSessionConverter converter;

    public UUID createSession() {
        return repository.createSession().getId();
    }

    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }

    @Override
    public List<GameSessionDto> findAll(String queryTail) {
        return converter.convert(repository.findAll(queryTail));
    }

    @Override
    public long count() {
        return repository.count();
    }

    public void remove(UUID id) {
        repository.remove(id);
    }
}
