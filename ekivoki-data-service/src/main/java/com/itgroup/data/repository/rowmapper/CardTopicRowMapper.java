package com.itgroup.data.repository.rowmapper;

import com.itgroup.data.model.entity.CardTopic;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CardTopicRowMapper implements RowMapper<CardTopic> {

    @Override
    public CardTopic mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var target = new CardTopic();
        target.setId(resultSet.getObject("id", UUID.class));
        target.setName(resultSet.getString("name"));
        return target;
    }
}
