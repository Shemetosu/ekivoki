package com.itgroup.data.repository.dao.impl;

import com.itgroup.data.exception.EntityNotFoundException;
import com.itgroup.data.model.entity.CardTopic;
import com.itgroup.data.repository.dao.CardTopicRepository;
import com.itgroup.data.repository.rowmapper.CardTopicRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
class CardTopicRepositoryImpl implements CardTopicRepository {

    private static final String COUNT = "SELECT COUNT(id) FROM card_topic";
    private static final String FIND_ALL = "SELECT id, name FROM card_topic";
    private static final String FIND_ALL_BY_ID = "SELECT id, name FROM card_topic WHERE id IN (:idList)";
    private static final String FIND_ONE = FIND_ALL + " WHERE id = ?";
    private static final String EXISTS = COUNT + " WHERE id = ?";
    private static final String CREATE = "INSERT INTO card_topic (id, name) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE card_topic SET name = ? WHERE id = ?";
    private static final String REMOVE = "DELETE FROM card_topic WHERE id = ?";

    private final NamedParameterJdbcTemplate npJdbc;
    private final JdbcTemplate jdbc;

    @Override
    public CardTopic findById(UUID id) {
        try {
            return jdbc.queryForObject(FIND_ONE, new CardTopicRowMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            throw new EntityNotFoundException("CardTopic not found by id: " + id);
        }
    }

    @Override
    public boolean existsById(UUID id) {
        return jdbc.queryForObject(EXISTS, Integer.class, id) == 1;
    }

    @Override
    public List<CardTopic> findAll(String queryTail) {
        return jdbc.query(FIND_ALL + queryTail, new CardTopicRowMapper());
    }

    @Override
    public List<CardTopic> findAll(Collection<UUID> idList) {
        return npJdbc.query(
                FIND_ALL_BY_ID,
                Map.of("idList", idList),
                new CardTopicRowMapper()
        );
    }

    public CardTopic create(CardTopic cardType) {
        var id = UUID.randomUUID();
        jdbc.update(
                CREATE,
                id,
                cardType.getName()
        );
        return findById(id);
    }

    public CardTopic update(CardTopic cardType) {
        jdbc.update(
                UPDATE,
                cardType.getName(),
                cardType.getId()
        );
        return findById(cardType.getId());
    }

    @Override
    public long count() {
        return jdbc.queryForObject(COUNT, Long.class);
    }

    @Override
    public void remove(UUID id) {
        jdbc.update(REMOVE, id);
    }
}
