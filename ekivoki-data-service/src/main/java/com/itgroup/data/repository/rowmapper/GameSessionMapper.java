package com.itgroup.data.repository.rowmapper;

import com.itgroup.data.model.entity.GameSession;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;

public class GameSessionMapper implements RowMapper<GameSession> {

    @Override
    public GameSession mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var target = new GameSession();
        target.setId(UUID.fromString(resultSet.getString("id")));
        target.setDateCreation(resultSet.getObject("date_creation", LocalDateTime.class));
        return target;
    }
}
