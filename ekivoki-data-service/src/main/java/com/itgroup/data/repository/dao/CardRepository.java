package com.itgroup.data.repository.dao;

import com.itgroup.data.model.entity.Card;
import com.itgroup.data.repository.CommonRepository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface CardRepository extends CommonRepository<Card> {

    boolean existsByTask(String task);

    boolean existsByQuestion(String question);

    List<UUID> getPairByParameters(Map<String, Object> map);
}
