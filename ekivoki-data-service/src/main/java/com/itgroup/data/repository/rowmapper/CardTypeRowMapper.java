package com.itgroup.data.repository.rowmapper;

import com.itgroup.data.model.entity.CardType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CardTypeRowMapper implements RowMapper<CardType> {

    @Override
    public CardType mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var target = new CardType();
        target.setId(resultSet.getObject("id", UUID.class));
        target.setDice(resultSet.getInt("dice"));
        target.setName(resultSet.getString("name"));
        target.setDescription(resultSet.getString("description"));
        return target;
    }
}
