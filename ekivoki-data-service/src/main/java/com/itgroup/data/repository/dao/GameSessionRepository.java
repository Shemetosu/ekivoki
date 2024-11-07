package com.itgroup.data.repository.dao;

import com.itgroup.data.model.entity.GameSession;
import com.itgroup.model.dto.responce.GameSessionDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface GameSessionRepository {

    GameSession createSession();

    GameSession findById(UUID id);

    boolean existsById(UUID id);

    List<GameSession> findAll(String queryTail);

    long count();

    void remove(UUID id);

    int removeOldSessions(LocalDateTime date);
}
