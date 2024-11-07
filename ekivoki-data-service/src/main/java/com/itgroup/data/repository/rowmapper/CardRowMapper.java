package com.itgroup.data.repository.rowmapper;

import com.itgroup.data.model.entity.Card;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;

public class CardRowMapper implements RowMapper<Card> {

    @Override
    public Card mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var target = new Card();
        target.setId(resultSet.getObject("id", UUID.class));
        target.setTopicId(resultSet.getObject("topic_id", UUID.class));
        target.setTypeId(resultSet.getObject("type_id", UUID.class));
        target.setTask(resultSet.getString("task"));
        target.setDescription(resultSet.getString("description"));
        target.setQuestion(resultSet.getString("question"));
        target.setLeadTime(resultSet.getInt("lead_time"));
        target.setDateCreation(resultSet.getObject("date_creation", LocalDateTime.class));
        target.setLastModified(resultSet.getObject("last_modified", LocalDateTime.class));
        target.setVersion(resultSet.getLong("version"));
        return target;
    }
}
