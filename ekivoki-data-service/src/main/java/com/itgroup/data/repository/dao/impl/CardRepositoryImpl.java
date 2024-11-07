package com.itgroup.data.repository.dao.impl;

import com.itgroup.data.exception.EntityNotFoundException;
import com.itgroup.data.exception.NotImplementedException;
import com.itgroup.data.model.entity.Card;
import com.itgroup.data.repository.dao.CardRepository;
import com.itgroup.data.repository.rowmapper.CardRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
class CardRepositoryImpl implements CardRepository {

    private static final String COUNT = "SELECT COUNT(id) FROM card";
    private static final String FIND_ALL = "SELECT id, topic_id, type_id, task, description, question, lead_time, date_creation, last_modified, version FROM card";
    private static final String FIND_ALL_BY_ID = "SELECT id, topic_id, type_id, task, description, question, lead_time, date_creation, last_modified, version FROM card WHERE id IN (:idList)";
    private static final String FIND_ONE = FIND_ALL + " WHERE id = :id";
    private static final String CREATE = "INSERT INTO card(id, topic_id, type_id, task, description, question, lead_time, date_creation, last_modified, version) VALUES (:id, :topicId, :typeId, :task, :description, :question, :leadTime, :dateCreation, :lastModified, 0)";
    private static final String UPDATE = "UPDATE card SET topic_id = :topicId, type_id = :typeId, task = :task, description = :description, question = :question, lead_time = :leadTime, last_modified = :lastModified, version = :version WHERE id = :id";
    private static final String REMOVE = "DELETE FROM card WHERE id = :id";

    private static final String FIND_CARD = "SELECT c.id "
            + "FROM card c "
            + "INNER JOIN card_type ct ON ct.id = c.type_id "
            + "WHERE ct.dice = :dice "
            + "AND c.id NOT IN "
            + "( "
            + "SELECT c.id "
            + "FROM card c "
            + "LEFT JOIN game_history gh ON gh.card_id = c.id "
            + "LEFT JOIN game_session gs ON gs.id = gh.session_id "
            + "WHERE gs.id = :sessionId "
            + "AND gh.card_id IS NOT NULL "
            + ") "
            + "LIMIT :limit "
            + "OFFSET :offset";

    private static final String GET_2_CARD = "SELECT id, topic_id, type_id, task, description, question, lead_time, date_creation, last_modified, version "
            + "FROM card "
            + "WHERE id IN (:idList)";

    private final NamedParameterJdbcTemplate npJdbc;
    private final JdbcTemplate jdbc;

    @Override
    public Card findById(UUID id) {
        try {
            var map = Map.of("id", id);
            return npJdbc.queryForObject(FIND_ONE, map, new CardRowMapper());
        } catch (EmptyResultDataAccessException ex) {
            throw new EntityNotFoundException("Card not found by id: " + id);
        }
    }

    @Override
    public boolean existsById(UUID id) {
        throw new NotImplementedException("Not implemented yet");
    }

    @Override
    public List<Card> findAll(String queryTail) {
        return npJdbc.query(FIND_ALL + queryTail, new CardRowMapper());
    }

    @Override
    public Card create(Card entity) {
        entity.setId(UUID.randomUUID());
        var date = LocalDateTime.now();
        Map<String, Object> map = new HashMap<>();
        map.put("dateCreation", date);
        map.put("lastModified", date);
        map.putAll(getParameterMap(entity));
        npJdbc.update(CREATE, map);
        return findById(entity.getId());
    }

    @Override
    public Card update(Card entity) {
        var exists = findById(entity.getId());
        Map<String, Object> map = new HashMap<>();
        map.put("lastModified", LocalDateTime.now());
        map.put("version", exists.getVersion() + 1);
        map.putAll(getParameterMap(entity));
        npJdbc.update(UPDATE, map);
        return findById(entity.getId());
    }

    @Override
    public void remove(UUID id) {
        var map = Map.of("id", id);
        npJdbc.update(REMOVE, map);
    }

    @Override
    public long count() {
        return npJdbc.queryForObject(COUNT, Map.of(), Long.class);
    }

    @Override
    public boolean existsByTask(String task) {
        return existsByField("task", task);
    }

    @Override
    public boolean existsByQuestion(String question) {
        return existsByField("question", question);
    }

    @Override
    public List<UUID> getPairByParameters(Map<String, Object> map) {
        return npJdbc.queryForList(FIND_CARD, map, UUID.class);
    }

    @Override
    public List<Card> findAll(Collection<UUID> idList) {
        return npJdbc.query(
                FIND_ALL_BY_ID,
                Map.of("idList", idList),
                new CardRowMapper()
        );
    }

    private boolean existsByField(String field, String value) {
        String query = COUNT + " WHERE " + field + " = ?";
        return jdbc.queryForObject(query, Integer.class, value) == 1;
    }

    private Map<String, Object> getParameterMap(Card entity) {
        return Map.of(
                "id", entity.getId(),
                "topicId", entity.getTopicId(),
                "typeId", entity.getTypeId(),
                "task", entity.getTask(),
                "description", entity.getDescription(),
                "question", entity.getQuestion(),
                "leadTime", entity.getLeadTime() == 0 ? 1 : entity.getLeadTime()
        );
    }
}
