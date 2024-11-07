package com.itgroup.data.repository.dao;

import com.itgroup.model.dto.request.UserCardCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class UserCardRepository {

    private static final String CREATE_CARD = "INSERT INTO user_card (id, topic_id, type_id, task, description, question, lead_time, date_creation, last_modified, version) VALUES (:id, :topicId, :typeId, :task, :description, :question, :leadTime, :dateCreation, :lastModified, 0)";
    private static final String CREATE_TOPIC_CARD = "INSERT INTO user_topic_card (id, name) VALUES (:id, :name)";

    private final NamedParameterJdbcTemplate jdbc;

    public UUID createCard(UserCardCreateDto dto) {
        var id = UUID.randomUUID();
        var dateTime = LocalDateTime.now();
        var map = Map.of(
                "id", id,
                "topicId", dto.getTopicId(),
                "typeId", dto.getTypeId(),
                "task", dto.getTask(),
                "description", dto.getDescription(),
                "question", dto.getQuestion(),
                "leadTime", dto.getLeadTime() == 0 ? 1 : dto.getLeadTime(),
                "dateCreation", dateTime,
                "lastModified", dateTime
        );
        jdbc.update(CREATE_CARD, map);
        return id;
    }

    public UUID createCardTopic(String name) {
        var id = UUID.randomUUID();
        var map = Map.of("id", id, "name", name);
        jdbc.update(CREATE_TOPIC_CARD, map);
        return id;
    }
}
