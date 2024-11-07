package com.itgroup.data.repository.dao.impl;

import com.itgroup.data.exception.EntityNotFoundException;
import com.itgroup.data.model.entity.GameSession;
import com.itgroup.data.repository.dao.GameSessionRepository;
import com.itgroup.data.repository.rowmapper.GameSessionRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class GameSessionRepositoryImpl implements GameSessionRepository {

    private static final String COUNT = "SELECT COUNT(id) FROM game_session";
    private static final String FIND_All = "SELECT id, date_creation FROM game_session";
    private static final String FIND_ONE = FIND_All + " WHERE id = ?";
    private static final String CREATE = "INSERT INTO game_session(id, date_creation) VALUES (?, ?)";
    private static final String EXISTS = COUNT + " WHERE id = ?";
    private static final String REMOVE = "DELETE FROM game_session WHERE id = ?";
    private static final String REMOVE_OLD = "DELETE FROM game_session WHERE date_creation < ?";

    private final JdbcTemplate jdbc;

    @Override
    public GameSession createSession() {
        var id = UUID.randomUUID();
        jdbc.update(CREATE, id, LocalDateTime.now());
        return findById(id);
    }

    @Override
    public GameSession findById(UUID id) {
        try {
            return jdbc.queryForObject(FIND_ONE, new GameSessionRowMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            throw new EntityNotFoundException("GameSession not found by id: " + id);
        }
    }

    @Override
    public boolean existsById(UUID id) {
        return jdbc.queryForObject(EXISTS, Integer.class, id) == 1;
    }

    @Override
    public List<GameSession> findAll(String queryTail) {
        return jdbc.query(FIND_All + queryTail, new GameSessionRowMapper());
    }

    @Override
    public long count() {
        return jdbc.queryForObject(COUNT, Long.class);
    }

    @Override
    public void remove(UUID id) {
        jdbc.update(REMOVE, id);
    }

    @Override
    public int removeOldSessions(LocalDateTime date) {
        return jdbc.update(REMOVE_OLD, date);
    }
}
