package com.itgroup.data.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@AllArgsConstructor
@Repository
public class GameHistoryRepository {

    private static final String CREATE = "INSERT INTO game_history (id, session_id, card_id) VALUES (?, ?, ?)";
    private static final String REMOVE = "";

    private final JdbcTemplate jdbc;

    public void addHistory(UUID sessionId, UUID cardId) {
        jdbc.update(CREATE, UUID.randomUUID().toString(), sessionId.toString(), cardId.toString());
    }
}
