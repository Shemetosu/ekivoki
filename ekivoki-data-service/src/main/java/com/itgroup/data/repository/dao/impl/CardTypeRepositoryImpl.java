package com.itgroup.data.repository.dao.impl;

import com.itgroup.data.exception.EntityNotFoundException;
import com.itgroup.data.model.entity.CardType;
import com.itgroup.data.repository.dao.CardTypeRepository;
import com.itgroup.data.repository.rowmapper.CardTypeRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
class CardTypeRepositoryImpl implements CardTypeRepository {

    private static final String COUNT = "SELECT COUNT(id) FROM card_type";
    private static final String FIND_ALL = "SELECT id, dice, name, description FROM card_type";
    private static final String FIND_ALL_BY_ID = "SELECT id, dice, name, description FROM card_type WHERE id IN (:idList)";
    private static final String FIND_ONE = FIND_ALL + " WHERE id = :id";
    private static final String EXISTS = COUNT + " WHERE id = :id";
    private static final String CREATE = "INSERT INTO card_type (id, dice, name, description) VALUES (:id, :dice, :name, :description)";
    private static final String UPDATE = "UPDATE card_type SET dice = :dice, name = :name, description = :description WHERE id = :id";
    private static final String REMOVE = "DELETE FROM card_type WHERE id = :id";
    
    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public CardType findById(UUID id) {
        try {
            return jdbc.queryForObject(FIND_ONE, Map.of("id", id), new CardTypeRowMapper());
        } catch (EmptyResultDataAccessException ex) {
            throw new EntityNotFoundException("CardType not found by id: " + id);
        }
    }

    @Override
    public boolean existsById(UUID id) {
        return jdbc.queryForObject(EXISTS, Map.of("id", id), Integer.class) == 1;
    }

    @Override
    public List<CardType> findAll(String queryTail) {
        return jdbc.query(FIND_ALL + queryTail, new CardTypeRowMapper());
    }

    @Override
    public List<CardType> findAll(Collection<UUID> idList) {
        return jdbc.query(
                FIND_ALL_BY_ID,
                Map.of("idList", idList),
                new CardTypeRowMapper()
        );
    }

    public CardType create(CardType entity) {
        entity.setId(UUID.randomUUID());
        return updateEntity(CREATE, entity);
    }

    public CardType update(CardType entity) {
        return updateEntity(UPDATE, entity);
    }

    @Override
    public long count() {
        return jdbc.queryForObject(COUNT, Map.of(), Long.class);
    }

    @Override
    public void remove(UUID id) {
        jdbc.update(REMOVE, Map.of("id", id));
    }

    private CardType updateEntity(String query, CardType entity) {
        jdbc.update(
                query,
                Map.of(
                        "id", entity.getId(),
                        "dice", entity.getDice(),
                        "name", entity.getName(),
                        "description", entity.getDescription()
                )
        );
        return findById(entity.getId());
    }
}
